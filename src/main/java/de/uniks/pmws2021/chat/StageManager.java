package de.uniks.pmws2021.chat;

import de.uniks.pmws2021.chat.controller.ClientScreenController;
import de.uniks.pmws2021.chat.controller.ServerScreenController;
import de.uniks.pmws2021.chat.controller.StartScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageManager extends Application {

    private static Stage stage;
    private static ServerScreenController serverScreenController;
    private static StartScreenController startScreenController;
    private static ClientScreenController clientScreenController;
    private static ChatEditor editor;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        editor = new ChatEditor();
        showStartScreen();
        primaryStage.show();
    }
    
    @Override
    public void stop() throws Exception {
        super.stop();
        cleanup();
    }
    
    public static void showServerScreen() {
        cleanup();
        try {
            Parent root = FXMLLoader.load(StageManager.class.getResource("view/ServerScreen.fxml"));
            Scene scene = new Scene(root);
//            List<Hero> heroes = ResourceManager.loadAllHeroes();
//            editor.setHeroes(heroes);

            serverScreenController = new ServerScreenController(root, editor);
            serverScreenController.init();

            stage.setTitle("MiniChat - Server");
            stage.setScene(scene);
            stage.centerOnScreen();
        } catch (Exception e) {
            System.err.println("Error showing ServerScreen");
            e.printStackTrace();
        }
    }
    
    public static void showStartScreen() {
        cleanup();
        try {
            Parent root = FXMLLoader.load(StageManager.class.getResource("view/StartScreen.fxml"));
            Scene scene = new Scene(root);

            startScreenController = new StartScreenController(root, editor);
            startScreenController.init();

            stage.setTitle("MiniChat - Start");
            stage.setScene(scene);
            stage.centerOnScreen();

        } catch (Exception e) {
            System.err.println("Error showing StartScreen");
            e.printStackTrace();
        }
    }

    public static void showClientScreen() {
        cleanup();
        try {
            Parent root = FXMLLoader.load(StageManager.class.getResource("view/ClientScreen.fxml"));
            Scene scene = new Scene(root);

            clientScreenController = new ClientScreenController(root, editor);
            clientScreenController.init();

            stage.setTitle("MiniChat - Client");
            stage.setScene(scene);
            stage.centerOnScreen();

        } catch (Exception e) {
            System.err.println("Error showing DungeonScreen");
            e.printStackTrace();
        }
    }
    
    private static void cleanup() {
        if (serverScreenController != null) {
            serverScreenController.stop();
            serverScreenController = null;
        }
        if (startScreenController != null) {
            startScreenController.stop();
            startScreenController = null;
        }
        if (clientScreenController != null) {
            clientScreenController.stop();
            clientScreenController = null;
        }
    }

    public ChatEditor getEditor() {
        return editor;
    }
}
