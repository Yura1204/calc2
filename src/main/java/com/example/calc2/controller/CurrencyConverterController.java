package com.example.calc2.controller;

import com.example.calc2.math.CurrencyConversionService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

            fromCurrencyComboBox.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.isEmpty()) {
                    fromCurrencyComboBox.getItems().clear();
                    fromCurrencyComboBox.getItems().addAll(currencies);
                } else {
                    filterCurrencies(fromCurrencyComboBox, currencies, newValue);
                    fromCurrencyComboBox.show();
                }
            });

            toCurrencyComboBox.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.isEmpty()) {
                    toCurrencyComboBox.getItems().clear();
                    toCurrencyComboBox.getItems().addAll(currencies);
                } else {
                    filterCurrencies(toCurrencyComboBox, currencies, newValue);
                    toCurrencyComboBox.show();
                }
            });
        } catch (Exception e) {
            // Обработка ошибки при загрузке курсов валют или API-ключа
            e.printStackTrace();
        }
    }

    private void filterCurrencies(ComboBox<String> comboBox, List<String> currencies, String newValue) {
        if (newValue.isEmpty()) {
            comboBox.getItems().clear();
            comboBox.getItems().addAll(currencies);
        } else {
            List<String> filteredCurrencies = currencies.stream()
                    .filter(currency -> currency.toLowerCase().contains(newValue.toLowerCase()))
                    .collect(Collectors.toList());
            comboBox.getItems().clear();
            comboBox.getItems().addAll(filteredCurrencies);
        }
    }

}
