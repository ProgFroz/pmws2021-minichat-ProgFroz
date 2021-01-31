package de.uniks.pmws2021.chat.controller;

import de.uniks.pmws2021.chat.ChatEditor;
import de.uniks.pmws2021.chat.StageManager;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class StartScreenController {
    private Parent view;
    private Button serverButton;
    private Button clientButton;
    private ChatEditor editor;

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
    }

    // Additional methods
    private void clientButtonOnClick(ActionEvent actionEvent) {
        StageManager.showClientScreen();
    }

    private void serverButtonOnClick(ActionEvent actionEvent) {
        StageManager.showServerScreen();
    }
}