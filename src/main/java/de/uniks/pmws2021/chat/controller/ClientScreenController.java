package de.uniks.pmws2021.chat.controller;

import de.uniks.pmws2021.chat.ChatEditor;
import de.uniks.pmws2021.chat.StageManager;
import de.uniks.pmws2021.chat.model.Chat;
import de.uniks.pmws2021.chat.model.User;
import de.uniks.pmws2021.chat.util.AlternateServerUserListCellFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ClientScreenController {
    private Parent view;
    private Button clientLeaveButton;
    private TabPane clientTabView;
    private TextField clientTextField;
    private Button clientSendButton;
    private ListView<User> clientUserList;
    private ChatEditor editor;
//    private List<ClientChatViewSubController> clientChatViewSubControllers;

    public ClientScreenController(Parent view, ChatEditor editor) {
        this.view = view;
        this.editor = editor;
//        this.clientChatViewSubControllers = new ArrayList<>();
    }

    public void init() {
        clientLeaveButton = (Button) view.lookup("#clientLeaveButton");
        clientLeaveButton.setOnAction(this::clientLeaveButtonOnClick);

        clientSendButton = (Button) view.lookup("#clientSendButton");
        clientSendButton.setOnAction(this::clientSendButtonOnClick);

        clientTextField = (TextField) view.lookup("#clientTextField");
        clientTextField.setPromptText("Enter Message...");

        this.clientUserList = (ListView<User>) view.lookup("#clientUserList");
//        this.clientUserList.setCellFactory(new AlternateServerUserListCellFactory());
//
//        this.clientUserList.setItems(FXCollections.observableList(editor.getUsers()));
//        this.clientUserList.setOnMouseReleased(this::onClientUserListDoubleClick);

        Chat chat = editor.getChat();
        clientTabView = (TabPane) view.lookup("#clientTabView");
    }

    private void onClientUserListDoubleClick(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            // ?
        }
    }

    public void stop() {
        // Clear references
        // Clear action listeners
        clientLeaveButton.setOnAction(null);
        clientSendButton.setOnAction(null);
    }

    // Additional methods
    private void clientLeaveButtonOnClick(ActionEvent actionEvent) {
        System.out.println("Leaving Client");
        StageManager.showStartScreen();
    }

    private void clientSendButtonOnClick(ActionEvent actionEvent) {
        System.out.println(this.clientTextField.getText());
    }
}