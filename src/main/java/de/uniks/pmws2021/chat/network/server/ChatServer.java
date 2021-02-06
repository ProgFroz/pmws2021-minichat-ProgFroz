package de.uniks.pmws2021.chat.network.server;

import de.uniks.pmws2021.chat.ChatEditor;
import de.uniks.pmws2021.chat.model.Chat;
import de.uniks.pmws2021.chat.model.User;
import de.uniks.pmws2021.chat.network.server.controller.UserController;
import de.uniks.pmws2021.chat.network.server.websocket.ChatSocket;

import java.io.EOFException;

import static spark.Spark.*;

public class ChatServer {
    private final Chat model;
    private final ChatEditor editor;

    // controller
    private final UserController userController;

    // websocket
    private final ChatSocket chatSocket;

    public ChatServer(Chat model, ChatEditor editor) {

        // set port

        // create chatsocket

        // create user controller

        // start websocket

        // rest setup
        before("*", ((request, response) -> response.header("Access-Control-Allow-Origin", "*")));
        before("*", ((request, response) -> response.header("Access-Control-Allow-Headers", "*")));
        before("*", ((request, response) -> response.header("Content-Type", "application/json")));

        // define routes with api prefix
        // define endpoints under user path
        // get all logged in users
        // user login
        // user logout

        // error handling
        notFound((request, response) -> "404 - This aren't the droids you're looking for");
        internalServerError(((request, response) -> "Server tired, server sleeping"));

        // catch all exceptions from server
        exception(Exception.class, (e, req, res) -> {
            if (!(e instanceof EOFException)) {
                System.err.println("Error in chat server:");
                e.printStackTrace();
            }
        });
    }

    public void disconnectUser(User user) {
        // disconnect given user
    }

    public void stopServer() {
        // disconnect all users

        stop();
    }
}
