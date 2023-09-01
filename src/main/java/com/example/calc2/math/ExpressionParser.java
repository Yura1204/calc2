package com.example.calc2.math;

/**
 * Класс ExpressionParser выполняет разбор математических выражений, состоящих из чисел, операторов и скобок,
 * и вычисляет результат выражения.
 */
public class ExpressionParser {
    private String input;
    private int position;

    public ExpressionParser(String input) {
        this.input = input;
        this.position = 0;
    }

    /**
     * Выполняет разбор выражения и возвращает результат вычисления.
     */
    public double evaluate() {
        return parseExpression();
    }

    /**
     * Разбирает выражение, состоящее из сложения и вычитания, и возвращает результат.
     */
    private double parseExpression() {
        double result = parseTerm();
        while (position < input.length()) {
            char operator = input.charAt(position);
            if (operator == '+' || operator == '-') {
                position++;
                double term = parseTerm();
                if (operator == '+') {
                    result += term;
                } else {
                    result -= term;
                }
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * Разбирает выражение, состоящее из умножения и деления, и возвращает результат.
     */
    private double parseTerm() {
        double result = parseFactor();
        while (position < input.length()) {
            char operator = input.charAt(position);
            if (operator == '*' || operator == '/') {
                position++;
                double factor = parseFactor();
                if (operator == '*') {
                    result *= factor;
                } else {
                    result /= factor;
                }
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * Разбирает фактор выражения, который может быть числом, скобкой или ошибкой.
     *
     * @return Результат вычисления фактора.
     * @throws IllegalArgumentException Если встретился некорректный символ или ошибка синтаксиса.
     */
    private double parseFactor() {
        char currentChar = input.charAt(position);
        if (Character.isDigit(currentChar)) {
            return parseNumber();
        } else if (currentChar == '(') {
            position++;
            double result = parseExpression();
            if (position < input.length() && input.charAt(position) == ')') {
                position++;
            } else {
                throw new IllegalArgumentException("Expected closing parenthesis");
            }
            return result;
        } else {
            throw new IllegalArgumentException("Unexpected character: " + currentChar);
        }
    }

    /**
     * Разбирает числовое значение из строки и возвращает его.
     *
     * @return Разобранное числовое значение.
     */
    private double parseNumber() {
        StringBuilder numberBuilder = new StringBuilder();
        while (position < input.length() && (Character.isDigit(input.charAt(position))
                || input.charAt(position) == '.')) {
            numberBuilder.append(input.charAt(position));
            position++;
        }
        return Double.parseDouble(numberBuilder.toString());
    }
}
