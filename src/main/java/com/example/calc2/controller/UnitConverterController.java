package com.example.calc2.controller;
import com.example.calc2.math.UnitConversionService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class UnitConverterController {

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private ComboBox<String> fromUnitComboBox;

    @FXML
    private ComboBox<String> toUnitComboBox;

    @FXML
    private TextField fromTextField;

    @FXML
    private TextField toTextField;

    @FXML
    private void initialize() {
        // Заполняем выпадающий список категорий
        categoryComboBox.getItems().addAll("Масса и вес", "Длина", "Объем", "Площадь", "Скорость");

        // Устанавливаем обработчик для выбора категории
        categoryComboBox.setOnAction(event -> onCategorySelected());

        // Другие инициализации
    }

    private void onCategorySelected() {
        // Очищаем выпадающие списки при выборе новой категории
        fromUnitComboBox.getItems().clear();
        toUnitComboBox.getItems().clear();

        // Получаем выбранную категорию
        String selectedCategory = categoryComboBox.getValue();

        // Заполняем выпадающие списки единицами в зависимости от категории
        switch (selectedCategory) {
            case "Масса и вес":
                fromUnitComboBox.getItems().addAll("Килограммы (кг)", "Фунты (lb)", "Граммы (г)", "Унции (oz)");
                toUnitComboBox.getItems().addAll("Килограммы (кг)", "Фунты (lb)", "Граммы (г)", "Унции (oz)");
                break;
            case "Длина":
                fromUnitComboBox.getItems().addAll("Метры (м)", "Футы (ft)", "Сантиметры (см)", "Дюймы (in)");
                toUnitComboBox.getItems().addAll("Метры (м)", "Футы (ft)", "Сантиметры (см)", "Дюймы (in)");
                break;
            case "Объем":
                fromUnitComboBox.getItems().addAll("Литры (л)", "Галлоны (gal)", "Кубические метры (м³)", "Кубические футы (ft³)");
                toUnitComboBox.getItems().addAll("Литры (л)", "Галлоны (gal)", "Кубические метры (м³)", "Кубические футы (ft³)");
                break;
            case "Площадь":
                fromUnitComboBox.getItems().addAll("Квадратные метры (м²)", "Квадратные футы (ft²)", "Ары (a)", "Гектары (га)");
                toUnitComboBox.getItems().addAll("Квадратные метры (м²)", "Квадратные футы (ft²)", "Ары (a)", "Гектары (га)");
                break;
            case "Скорость":
                fromUnitComboBox.getItems().addAll("Метры в секунду (м/с)", "Километры в час (км/ч)", "Мили в час (mph)", "Футы в секунду (ft/s)");
                toUnitComboBox.getItems().addAll("Метры в секунду (м/с)", "Километры в час (км/ч)", "Мили в час (mph)", "Футы в секунду (ft/s)");
                break;
            default:
                // Обработка некорректного выбора категории
                break;
        }
    }

    @FXML
    private void convertUnits() {
        String fromUnit = fromUnitComboBox.getValue();
        String toUnit = toUnitComboBox.getValue();
        try {
            double value = Double.parseDouble(fromTextField.getText());
            double convertedValue = UnitConversionService.convert(value, fromUnit, toUnit);
            toTextField.setText(String.valueOf(convertedValue));
        } catch (NumberFormatException e) {
            // Обработка ошибок ввода значения
        }
    }

}
