package com.example.calc2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

public class SettingsController {

    @FXML
    private TextField apiKeyTextField;

    // Метод для сохранения ключа API
    @FXML
    private void saveApiKey() {
        String apiKey = apiKeyTextField.getText();
        if (!apiKey.isEmpty()) {
            try {
                String resourcePath = "/com/example/calc2/config.properties";
                Properties properties = new Properties();

                // Загрузка текущих свойств из ресурсов
                try (InputStream input = getClass().getResourceAsStream(resourcePath)) {
                    properties.load(input);
                }

                // Изменение свойства "api.key"
                properties.setProperty("api.key", apiKey);

                // Создание временного файла и сохранение обновленных свойств в него
                File tempFile = File.createTempFile("config", ".properties");
                try (OutputStream output = new FileOutputStream(tempFile)) {
                    properties.store(output, null);
                }

                // Замена исходного файла обновленным временным файлом
                Files.copy(tempFile.toPath(), Paths.get(getClass().getResource(resourcePath).toURI()), StandardCopyOption.REPLACE_EXISTING);

                // Удаление временного файла
                tempFile.delete();
                System.exit(0);
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}
