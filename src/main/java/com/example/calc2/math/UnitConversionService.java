package com.example.calc2.math;

public class UnitConversionService {

    public static double convert(double value, String fromUnit, String toUnit) {
        // Конвертация Массы и Веса
        if (fromUnit.equals("Килограммы (кг)") && toUnit.equals("Фунты (lb)")) {
            return value * 2.20462; // Конвертация килограммов в фунты
        } else if (fromUnit.equals("Фунты (lb)") && toUnit.equals("Килограммы (кг)")) {
            return value / 2.20462; // Конвертация фунтов в килограммы
        } else if (fromUnit.equals("Граммы (г)") && toUnit.equals("Унции (oz)")) {
            return value / 28.3495; // Конвертация граммов в унции
        } else if (fromUnit.equals("Унции (oz)") && toUnit.equals("Граммы (г)")) {
            return value * 28.3495; // Конвертация унций в граммы
        } else if (fromUnit.equals("Граммы (г)") && toUnit.equals("Фунты (lb)")) {
            return value / 453.59237; // Конвертация граммов в фунты
        } else if (fromUnit.equals("Фунты (lb)") && toUnit.equals("Граммы (г)")) {
            return value * 453.59237; // Конвертация фунтов в граммы
        } else if (fromUnit.equals("Унции (oz)") && toUnit.equals("Фунты (lb)")) {
            return value / 16.0; // Конвертация унций в фунты
        } else if (fromUnit.equals("Фунты (lb)") && toUnit.equals("Унции (oz)")) {
            return value * 16.0; // Конвертация фунтов в унции
        } else if (fromUnit.equals("Унции (oz)") && toUnit.equals("Килограммы (кг)")) {
            return value / 35.274; // Конвертация унций в килограммы
        } else if (fromUnit.equals("Килограммы (кг)") && toUnit.equals("Унции (oz)")) {
            return value * 35.274; // Конвертация килограммов в унции
        } else if (fromUnit.equals("Килограммы (кг)") && toUnit.equals("Граммы (г)")) {
            return value * 1000; // Конвертация килограммов в граммы
        } else if (fromUnit.equals("Граммы (г)") && toUnit.equals("Килограммы (кг)")) {
            return value / 1000; // Конвертация граммов в килограммы
        }





        // Конвертация Длины
        if (fromUnit.equals("Метры (м)") && toUnit.equals("Футы (ft)")) {
            return value * 3.28084; // Конвертация метров в футы
        } else if (fromUnit.equals("Футы (ft)") && toUnit.equals("Метры (м)")) {
            return value / 3.28084; // Конвертация футов в метры
        } else if (fromUnit.equals("Сантиметры (см)") && toUnit.equals("Дюймы (in)")) {
            return value / 2.54; // Конвертация сантиметров в дюймы
        } else if (fromUnit.equals("Дюймы (in)") && toUnit.equals("Сантиметры (см)")) {
            return value * 2.54; // Конвертация дюймов в сантиметры
        } else if (fromUnit.equals("Метры (м)") && toUnit.equals("Сантиметры (см)")) {
            return value * 100; // Конвертация метров в сантиметры
        } else if (fromUnit.equals("Сантиметры (см)") && toUnit.equals("Метры (м)")) {
            return value / 100; // Конвертация сантиметров в метры
        } else if (fromUnit.equals("Дюймы (in)") && toUnit.equals("Футы (ft)")) {
            return value / 12.0; // Конвертация дюймов в футы
        } else if (fromUnit.equals("Футы (ft)") && toUnit.equals("Дюймы (in)")) {
            return value * 12.0; // Конвертация футов в дюймы
        } else if (fromUnit.equals("Метры (м)") && toUnit.equals("Дюймы (in)")) {
            return value * 39.3701; // Конвертация метров в дюймы
        } else if (fromUnit.equals("Дюймы (in)") && toUnit.equals("Метры (м)")) {
            return value / 39.3701; // Конвертация дюймов в метры
        } else if (fromUnit.equals("Футы (ft)") && toUnit.equals("Сантиметры (см)")) {
            return value * 30.48; // Конвертация футов в сантиметры
        } else if (fromUnit.equals("Сантиметры (см)") && toUnit.equals("Футы (ft)")) {
            return value / 30.48; // Конвертация сантиметров в футы
        }




        // Конвертация Объема
        if (fromUnit.equals("Литры (л)") && toUnit.equals("Галлоны (gal)")) {
            return value * 0.264172; // Конвертация литров в галлоны
        } else if (fromUnit.equals("Галлоны (gal)") && toUnit.equals("Литры (л)")) {
            return value / 0.264172; // Конвертация галлонов в литры
        } else if (fromUnit.equals("Кубические метры (м³)") && toUnit.equals("Кубические футы (ft³)")) {
            return value * 35.3147; // Конвертация кубических метров в кубические футы
        } else if (fromUnit.equals("Кубические футы (ft³)") && toUnit.equals("Кубические метры (м³)")) {
            return value / 35.3147; // Конвертация кубических футов в кубические метры
        } else if (fromUnit.equals("Литры (л)") && toUnit.equals("Кубические метры (м³)")) {
            return value / 1000.0; // Конвертация литров в кубические метры
        } else if (fromUnit.equals("Кубические метры (м³)") && toUnit.equals("Литры (л)")) {
            return value * 1000.0; // Конвертация кубических метров в литры
        } else if (fromUnit.equals("Галлоны (gal)") && toUnit.equals("Кубические метры (м³)")) {
            return value * 0.00378541; // Конвертация галлонов в кубические метры
        } else if (fromUnit.equals("Кубические метры (м³)") && toUnit.equals("Галлоны (gal)")) {
            return value / 0.00378541; // Конвертация кубических метров в галлоны
        } else if (fromUnit.equals("Литры (л)") && toUnit.equals("Кубические футы (ft³)")) {
            return value * 0.0353147; // Конвертация литров в кубические футы
        } else if (fromUnit.equals("Кубические футы (ft³)") && toUnit.equals("Литры (л)")) {
            return value / 0.0353147; // Конвертация кубических футов в литры
        } else if (fromUnit.equals("Галлоны (gal)") && toUnit.equals("Кубические футы (ft³)")) {
            return value * 0.133681; // Конвертация галлонов в кубические футы
        } else if (fromUnit.equals("Кубические футы (ft³)") && toUnit.equals("Галлоны (gal)")) {
            return value / 0.133681; // Конвертация кубических футов в галлоны
        }


        // Конвертация Площади
        if (fromUnit.equals("Квадратные метры (м²)") && toUnit.equals("Квадратные футы (ft²)")) {
            return value * 10.7639; // Конвертация квадратных метров в квадратные футы
        } else if (fromUnit.equals("Квадратные футы (ft²)") && toUnit.equals("Квадратные метры (м²)")) {
            return value / 10.7639; // Конвертация квадратных футов в квадратные метры
        } else if (fromUnit.equals("Ары (a)") && toUnit.equals("Гектары (га)")) {
            return value / 100; // Конвертация аров в гектары
        } else if (fromUnit.equals("Гектары (га)") && toUnit.equals("Ары (a)")) {
            return value * 100; // Конвертация гектаров в ары
        } else if (fromUnit.equals("Квадратные метры (м²)") && toUnit.equals("Ары (a)")) {
            return value / 100; // Конвертация квадратных метров в ары
        } else if (fromUnit.equals("Ары (a)") && toUnit.equals("Квадратные метры (м²)")) {
            return value * 100; // Конвертация аров в квадратные метры
        } else if (fromUnit.equals("Квадратные футы (ft²)") && toUnit.equals("Ары (a)")) {
            return value / 9.2903; // Конвертация квадратных футов в ары
        } else if (fromUnit.equals("Ары (a)") && toUnit.equals("Квадратные футы (ft²)")) {
            return value * 9.2903; // Конвертация аров в квадратные футы
        } else if (fromUnit.equals("Квадратные метры (м²)") && toUnit.equals("Гектары (га)")) {
            return value / 10000; // Конвертация квадратных метров в гектары
        } else if (fromUnit.equals("Гектары (га)") && toUnit.equals("Квадратные метры (м²)")) {
            return value * 10000; // Конвертация гектаров в квадратные метры
        } else if (fromUnit.equals("Квадратные футы (ft²)") && toUnit.equals("Гектары (га)")) {
            return value / 107639; // Конвертация квадратных футов в гектары
        } else if (fromUnit.equals("Гектары (га)") && toUnit.equals("Квадратные футы (ft²)")) {
            return value * 107639; // Конвертация гектаров в квадратные футы
        }


        // Конвертация Скорости
        if (fromUnit.equals("Метры в секунду (м/с)") && toUnit.equals("Километры в час (км/ч)")) {
            return value * 3.6; // Конвертация метров в секунду в километры в час
        } else if (fromUnit.equals("Километры в час (км/ч)") && toUnit.equals("Метры в секунду (м/с)")) {
            return value / 3.6; // Конвертация километров в час в метры в секунду
        } else if (fromUnit.equals("Мили в час (mph)") && toUnit.equals("Футы в секунду (ft/s)")) {
            return value * 1.467; // Конвертация миль в час в футы в секунду
        } else if (fromUnit.equals("Футы в секунду (ft/s)") && toUnit.equals("Мили в час (mph)")) {
            return value / 1.467; // Конвертация футов в секунду в мили в час
        } else if (fromUnit.equals("Метры в секунду (м/с)") && toUnit.equals("Футы в секунду (ft/s)")) {
            return value * 3.281; // Конвертация метров в секунду в футы в секунду
        } else if (fromUnit.equals("Футы в секунду (ft/s)") && toUnit.equals("Метры в секунду (м/с)")) {
            return value / 3.281; // Конвертация футов в секунду в метры в секунду
        } else if (fromUnit.equals("Километры в час (км/ч)") && toUnit.equals("Мили в час (mph)")) {
            return value / 1.609; // Конвертация километров в час в мили в час
        } else if (fromUnit.equals("Мили в час (mph)") && toUnit.equals("Километры в час (км/ч)")) {
            return value * 1.609; // Конвертация миль в час в километры в час
        } else if (fromUnit.equals("Футы в секунду (ft/s)") && toUnit.equals("Километры в час (км/ч)")) {
            return value * 1.097; // Конвертация футов в секунду в километры в час
        } else if (fromUnit.equals("Километры в час (км/ч)") && toUnit.equals("Футы в секунду (ft/s)")) {
            return value / 1.097; // Конвертация километров в час в футы в секунду
        } else if (fromUnit.equals("Метры в секунду (м/с)") && toUnit.equals("Мили в час (mph)")) {
            return value * 2.237; // Конвертация метров в секунду в мили в час
        } else if (fromUnit.equals("Мили в час (mph)") && toUnit.equals("Метры в секунду (м/с)")) {
            return value / 2.237; // Конвертация миль в час в метры в секунду
        }


        return value;
    }
}


