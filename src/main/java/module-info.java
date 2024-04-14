module com.qrr.qrreader {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.qrr.qrreader to javafx.fxml;
    exports com.qrr.qrreader;
}