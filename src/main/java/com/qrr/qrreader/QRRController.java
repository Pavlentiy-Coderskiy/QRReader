package com.qrr.qrreader;

import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/*---------------------------
    - Сохранение настроек
    - 
    - 
    - 
    - 
    - 
  
------------------------------*/
public class QRRController {

    Set<String> hotkey = QRRApp.hotkey;

    @FXML
    private TextField hotkeyTextField;

    @FXML
    private Button editHotkeyButton;

    @FXML
    void editHotkey(ActionEvent event) {
        String currentHotkey = "";
        
        hotkeyTextField.setText(currentHotkey);
    }

    

   
}