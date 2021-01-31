package de.uniks.pmws2021.chat;

import de.uniks.pmws2021.chat.model.Chat;
import de.uniks.pmws2021.chat.model.User;

import java.util.List;

public class ChatEditor {

    // Editor lookup lists
    private List<User> users;

    // Connection to model root object
    private Chat chat;

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    // ===========================================================================================
    // Logic
    // ===========================================================================================



}
