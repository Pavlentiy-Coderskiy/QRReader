package com.qrr.qrreader;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class QRRApp extends Application {
    public static Set<String> hotkey = new HashSet<>();
    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QRRApp.class.getResource("QRRUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 140);
        stage.setTitle("QR-Reader");
        stage.setResizable(false);
        editHotkey(scene);
        stage.setScene(scene);
        stage.show();
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = bounds.getMinX() + (bounds.getWidth() - scene.getWidth());
        double y = bounds.getMinY() + (bounds.getHeight() - scene.getHeight()) * 0.01;
        stage.setX(x);
        stage.setY(y);
    }

    public static void main(String[] args) {
        launch();
    }

    public static void editHotkey(@SuppressWarnings("exports") Scene scene) throws IOException {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent kevent){
                if(kevent.isControlDown()){
                    if(hotkey.size() > 3)
                        hotkey.clear();
                    hotkey.add(kevent.getCode().toString());
                    System.out.println(hotkey);
                }
            }
        });
    }
}