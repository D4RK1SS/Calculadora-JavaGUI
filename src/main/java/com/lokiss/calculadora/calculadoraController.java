package com.lokiss.calculadora;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class calculadoraController {
    @FXML
    private Label display;

    private double num1 = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    @FXML
    private void handleDigit(javafx.event.ActionEvent event) {
        String digit = ((Button) event.getSource()).getText();
        if (startNewNumber) {
            display.setText(digit);
            startNewNumber = false;
        } else {
            display.setText(display.getText() + digit);
        }
    }

    @FXML
    private void handleOperator(javafx.event.ActionEvent event) {
        operator = ((Button) event.getSource()).getText();
        num1 = Double.parseDouble(display.getText());
        startNewNumber = true;
    }

    @FXML
    private void handleEquals() {
        double num2 = Double.parseDouble(display.getText());

        if(operator.equals("/") && num2 == 0 || num1 ==0){
            display.setText("ERRO");
            startNewNumber = true;
            return;
        }

        double result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> num2;
        };
        display.setText(String.valueOf(result));
        startNewNumber = true;
    }

    @FXML
    private void handleClear() {
        display.setText("0");
        num1 = 0;
        operator = "";
        startNewNumber = true;
    }
}