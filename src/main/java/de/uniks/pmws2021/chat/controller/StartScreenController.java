package de.uniks.pmws2021.chat.controller;

import de.uniks.pmws2021.chat.ChatEditor;
import de.uniks.pmws2021.chat.StageManager;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;

public class StartScreenController {
    private Parent view;
    private Button serverButton;
    private Button clientButton;
    private ChatEditor editor;
    private TextInputDialog dialog;
    public StartScreenController(Parent view, ChatEditor editor) {
        this.view = view;
        this.editor = editor;
    }

    public void init() {
        serverButton = (Button) view.lookup("#serverButton");
        serverButton.setOnAction(this::serverButtonOnClick);

        clientButton = (Button) view.lookup("#clientButton");
        clientButton.setOnAction(this::clientButtonOnClick);
    }

    public void stop() {
        // Clear references
        // Clear action listeners
        serverButton.setOnAction(null);
        clientButton.setOnAction(null);
    }

    // Additional methods
    private void clientButtonOnClick(ActionEvent actionEvent) {
        dialog = new TextInputDialog();
        dialog.setTitle("Enter Username");
        dialog.setHeaderText(null);
        dialog.setContentText("Username");
        dialog.getEditor().setId("usernameTextField");

        dialog.showAndWait().ifPresent((name) -> {
            editor.enterChat(name);
            StageManager.showClientScreen();
        });
    }

    private void serverButtonOnClick(ActionEvent actionEvent) {
        StageManager.showServerScreen();
    }
}