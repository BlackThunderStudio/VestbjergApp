package com.teamSuperior.guiApp.GUI;

import com.teamSuperior.guiApp.enums.ErrorCode;
import javafx.scene.control.Alert;

/**
 * Error Render
 */
public class Error {
    public static void displayError(ErrorCode code) {
        String errorTitle = code.getErrorTitle();
        String errorMessage = code.getErrorMessage();
        Alert.AlertType t = code.getT();
        if (t == null) {
            t = Alert.AlertType.WARNING;
        }
        Alert alert = new Alert(t);

        if (code.getErrorMessage().isEmpty() || code.getErrorMessage() == null) {
            alert.setHeaderText(errorTitle);
            alert.showAndWait();
        } else {
            alert.setHeaderText(errorTitle);
            alert.setContentText(errorMessage);
            alert.showAndWait();
        }
    }
}
