package com.example.calc2.controller;

import com.example.calc2.math.ExpressionParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ButtonController {
    @FXML
    private TextField inputField;

    public void onNumberButtonClick(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String buttonText = button.getText();
        inputField.appendText(buttonText);
    }

    public void onOperatorButtonClick(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String buttonText = button.getText();
        inputField.appendText(buttonText);
    }

    public void onSymbolButtonClick(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String buttonText = button.getText();
        inputField.appendText(buttonText);
    }

    public void onClearButtonClick(ActionEvent actionEvent) {
        inputField.clear();
    }

    public void onEqualsButtonClick(ActionEvent actionEvent) {
        String expression = inputField.getText();

        try {
            ExpressionParser parser = new ExpressionParser(expression);
            double result = parser.evaluate();
            inputField.setText(String.valueOf(result));
        } catch (IllegalArgumentException e) {
            inputField.setText("Error");
        }
    }

    public void onBackspaceButtonClick(ActionEvent actionEvent) {
        String currentText = inputField.getText();
        if (!currentText.isEmpty()) {
            inputField.setText(currentText.substring(0, currentText.length() - 1));
        }
    }
}
