package com.example.calc2.controller;

import com.example.calc2.math.CurrencyConversionService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CurrencyConverterController {

    @FXML
    private TextField fromAmountTextField;

    @FXML
    private TextField toAmountTextField;

    @FXML
    private ComboBox<String> fromCurrencyComboBox;

    @FXML
    private ComboBox<String> toCurrencyComboBox;

    // Создаем экземпляр CurrencyConversionService
    private CurrencyConversionService conversionService = new CurrencyConversionService();

    // Обработчик события для кнопки "Convert"
    @FXML
    private void convertCurrency() {
        String fromCurrency = fromCurrencyComboBox.getValue();
        String toCurrency = toCurrencyComboBox.getValue();

        try {
            double amount = Double.parseDouble(fromAmountTextField.getText());
            double convertedAmount = conversionService.convertCurrency(amount, fromCurrency, toCurrency);
            toAmountTextField.setText(String.valueOf(convertedAmount));
        } catch (NumberFormatException e) {
            // Обработка ошибки, если пользователь ввел некорректное число
            toAmountTextField.setText("Invalid input");
        }
    }

    @FXML
    private void initialize() {
        try {
            // Загрузите API-ключ
            CurrencyConversionService.loadApiKey();

            // Загрузите курсы валют из API и получите список доступных валют
            Map<String, Double> exchangeRates = conversionService.loadExchangeRates();
            List<String> currencies = new ArrayList<>(exchangeRates.keySet());

            // Обновите ComboBox'ы с доступными валютами
            fromCurrencyComboBox.getItems().addAll(currencies);
            toCurrencyComboBox.getItems().addAll(currencies);

            // Установите значения по умолчанию для ComboBox'ов
            fromCurrencyComboBox.setValue("USD");
            toCurrencyComboBox.setValue("EUR");
        } catch (Exception e) {
            // Обработка ошибки при загрузке курсов валют или API-ключа
            e.printStackTrace();
        }
    }


}
