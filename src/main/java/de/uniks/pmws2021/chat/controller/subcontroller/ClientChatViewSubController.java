package de.uniks.pmws2021.chat.controller.subcontroller;

import de.uniks.pmws2021.chat.ChatEditor;
import javafx.scene.Parent;

public class ClientChatViewSubController {
    private ChatEditor editor;
    private Parent view;

    public ClientChatViewSubController(Parent view, ChatEditor editor) {
        this.editor = editor;
        this.view = view;
    }

    // ===========================================================================================
    // Controller
    // ===========================================================================================

    public void init() {
        // Load all view references
        // Add mouse actions
        // Init view with model
    }

    public void stop() {

    }

    // ===========================================================================================
    // Button Action Methods
    // ===========================================================================================

}
