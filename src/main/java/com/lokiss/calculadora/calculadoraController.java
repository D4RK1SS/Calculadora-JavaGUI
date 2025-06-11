package com.lokiss.calculadora;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.lang.Math;

public class calculadoraController {
    @FXML
    private Label display;

    private double num1 = 0;
    private String operator = "";
    //variavel para checar se é o primeiro numero a ser digitado
    private boolean startNewNumber = true;

//    codigo basico que pega o texto dentro do botão
//    e adicioan ele da forma certa no display

    @FXML
    private void handleDigit(javafx.event.ActionEvent event) {
        String digit = ((Button) event.getSource()).getText();
        //caso seja o primeiro numero imprime no display e retorna a variavel como false
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
            case "^" -> Math.pow(num1, num2);
            case "%" -> (num1 / 100) * num2;
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