package de.uniks.pmws2021.chat.controller;

import de.uniks.pmws2021.chat.ChatEditor;
import de.uniks.pmws2021.chat.model.User;
import de.uniks.pmws2021.chat.util.AlternateServerUserListCellFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class ServerScreenController {

    private Parent view;
    private Button disconnectAllButton;
    private Button disconnectOneButton;
    private Button closeServerButton;
    private ChatEditor editor;
    private ListView<User> serverUserList;

    public ServerScreenController(Parent view, ChatEditor editor) {
        this.view = view;
        this.editor = editor;
    }

    public void init() {
        disconnectAllButton = (Button) view.lookup("#disconnectAllButton");
        disconnectAllButton.setOnAction(this::disconnectAllButtonOnClick);

        disconnectOneButton = (Button) view.lookup("#disconnectOneButton");
        disconnectOneButton.setOnAction(this::disconnectOneButtonOnClick);

        closeServerButton = (Button) view.lookup("#closeServerButton");
        closeServerButton.setOnAction(this::closeServerOnClick);

        this.serverUserList = (ListView<User>) view.lookup("#serverUserList");
//        this.serverUserList.setCellFactory(new AlternateServerUserListCellFactory());
//
//        this.serverUserList.setItems(FXCollections.observableList(editor.getUsers()));
//        this.serverUserList.setOnMouseReleased(this::onServerUserListDoubleClicked);

    }

    public void stop() {
        // Clear references
        // Clear action listeners
        disconnectAllButton.setOnAction(null);
    }
    
    // Additional methods
    private void disconnectAllButtonOnClick(ActionEvent actionEvent) {

    }

    private void disconnectOneButtonOnClick(ActionEvent actionEvent) {

    }

    private void closeServerOnClick(ActionEvent actionEvent) {

    }

    private void onServerUserListDoubleClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            // ?
        }
    }
}