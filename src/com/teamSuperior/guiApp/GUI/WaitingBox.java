package com.teamSuperior.guiApp.GUI;

import com.jfoenix.controls.JFXProgressBar;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Domestos on 16.12.20.
 */
public class WaitingBox {
    public static void display(String message, int timeInMilliseconds) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Processing operation...");
        window.setMinWidth(350);

        Label label = new Label(message);
        JFXProgressBar bar = new JFXProgressBar();
        bar.setPrefWidth(350);
        bar.setPrefHeight(30);
        bar.setProgress(-1.0f);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, bar);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.setResizable(false);
        window.setAlwaysOnTop(true);

        Task waitForTime = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Thread.sleep(timeInMilliseconds);
                Platform.runLater(window::close);
                return null;
            }
        };

        Thread wait = new Thread(waitForTime);
        wait.setDaemon(true);
        wait.start();

        window.showAndWait();
    }

    private String msg;
    private boolean isAlive;

    public WaitingBox(String message) {
        msg = message;
        isAlive = true;
        displayIndefinite();
    }

    public WaitingBox() {
        isAlive = true;
    }

    ;

    public void setMessage(String message) {
        msg = message;
    }

    public void closeWindow() {
        isAlive = false;
    }

    public void displayIndefinite() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Processing operation...");
        window.setMinWidth(350);

        Label label = new Label(msg);
        JFXProgressBar bar = new JFXProgressBar();
        bar.setPrefWidth(350);
        bar.setPrefHeight(30);
        bar.setProgress(-1.0f);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, bar);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.setResizable(false);
        window.setAlwaysOnTop(true);

        Task waitForTime = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                while (isAlive) {
                    Thread.sleep(10);
                }
                Platform.runLater(window::close);
                return null;
            }
        };

        Thread wait = new Thread(waitForTime);
        wait.setDaemon(true);
        wait.start();

        window.show();
    }
}
