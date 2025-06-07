module com.lokiss.calculadora {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lokiss.calculadora to javafx.fxml;
    exports com.lokiss.calculadora;
}