package com.example.calc2.math;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Класс, отвечающий за конвертацию валют и получение курсов валют из API.
 */
public class CurrencyConversionService {

    private static String apiKey;
    private static final Map<String, Double> exchangeRates = new HashMap<>();
    private static String EXCHANGE_RATES_API_URL;

    public CurrencyConversionService() {
        loadApiKey();
        EXCHANGE_RATES_API_URL = "http://api.exchangeratesapi.io/v1/latest?access_key=" + apiKey;
    }

    /**
     * Загружает ключ API из файла config.properties.
     */
    public static void loadApiKey() {
        Properties properties = new Properties();
        try (InputStream input = CurrencyConversionService.class.getResourceAsStream(
                "/com/example/calc2/config.properties")) {
            properties.load(input);
            apiKey = properties.getProperty("api.key");
        } catch (IOException e) {
            // Обработка ошибок
            e.printStackTrace();
        }
    }

    /**
     * Получает курсы валют из API и обновляет карту exchangeRates.
     *
     * @return карта, содержащая последние курсы валют.
     * @throws IOException          если возникает ошибка ввода-вывода.
     * @throws ParseException        если возникает ошибка при разборе ответа JSON.
     * @throws InterruptedException если поток прерывается.
     */
    public Map<String, Double> loadExchangeRates() throws IOException, ParseException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(EXCHANGE_RATES_API_URL))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();

            // Преобразование полученного JSON-ответа в объект JSONObject
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonResponse);

            // Проверка наличия ключа "rates" в JSON-объекте
            if (jsonObject.containsKey("rates")) {
                // Если ключ "rates" присутствует, извлекаем курсы валют из JSON и обновляем exchangeRates
                JSONObject rates = (JSONObject) jsonObject.get("rates");
                for (Object key : rates.keySet()) {
                    String currency = (String) key;
                    // Преобразование числовых значений в Double
                    double rate = ((Number) rates.get(key)).doubleValue();
                    exchangeRates.put(currency, rate);
                }
            } else {
                // Обработка случая, если ключ "rates" отсутствует в JSON-ответе
                System.err.println("JSON response does not contain key 'rates'");
            }
        } catch (IOException | InterruptedException e) {
            // Обработка ошибок при выполнении HTTP-запроса
            e.printStackTrace();
        }
        return exchangeRates;
    }


    /**
     * Конвертирует указанную сумму денег из одной валюты в другую.
     *
     * @param amount      сумма денег, которую необходимо конвертировать.
     * @param fromCurrency валюта, в которой указана сумма денег.
     * @param toCurrency   валюта, в которую необходимо конвертировать сумму денег.
     * @return конвертированная сумма денег, или 0.0, если конвертация невозможна.
     */
    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (exchangeRates.containsKey(fromCurrency) && exchangeRates.containsKey(toCurrency)) {
            double fromRate = exchangeRates.get(fromCurrency);
            double toRate = exchangeRates.get(toCurrency);
            return amount * (toRate / fromRate);
        }
        return 0.0;
    }
}
