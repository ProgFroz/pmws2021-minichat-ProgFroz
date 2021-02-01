package de.uniks.pmws2021.model.chat;

import de.uniks.pmws2021.chat.ChatEditor;
import de.uniks.pmws2021.chat.StageManager;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class StageManagerTest extends ApplicationTest {
    private Stage stage;
    private StageManager app;

    @Override
    public void start(Stage stage) {
        // start applicatio n
        this.stage = stage;
        this.app = new StageManager();
        this.app.start(stage);
        this.stage.centerOnScreen();
    }

    @Test
    public void changeViewTest() {
        String username = "username";
        Button serverButton = lookup("#serverButton").queryButton();
        Button clientButton = lookup("#clientButton").queryButton();

        Assert.assertEquals("Server", serverButton.getText());
        Assert.assertEquals("Client", clientButton.getText());

        Assert.assertEquals("MiniChat - Start", stage.getTitle());

        clickOn(clientButton);
        TextField usernameTextField = lookup("#usernameTextField").query();
        clickOn(usernameTextField).write(username + '\n');

        Assert.assertEquals("MiniChat - Client", stage.getTitle());

        Button clientLeaveButton = lookup("#clientLeaveButton").query();
        Button clientSendButton = lookup("#clientSendButton").query();
        TextField clientTextField = lookup("#clientTextField").query();
        clickOn(clientTextField).write(username);
        Assert.assertEquals(username, clientTextField.getText());
        Assert.assertEquals("Leave", clientLeaveButton.getText());
        Assert.assertEquals("Send", clientSendButton.getText());

        clickOn(clientSendButton);

        clickOn(clientLeaveButton);

        Assert.assertEquals("MiniChat - Start", stage.getTitle());

        serverButton = lookup("#serverButton").queryButton();
        clickOn(serverButton);

        Assert.assertEquals("MiniChat - Server", stage.getTitle());

        Button disconnectOneButton = lookup("#disconnectOneButton").query();
        Assert.assertEquals("Disconnect One", disconnectOneButton.getText());
        clickOn(disconnectOneButton);
        Button disconnectAllButton = lookup("#disconnectAllButton").query();
        Assert.assertEquals("Disconnect All", disconnectAllButton.getText());
        clickOn(disconnectAllButton);

        Button closeServerButton = lookup("#closeServerButton").query();
        clickOn(closeServerButton);

        Assert.assertEquals("MiniChat - Start", stage.getTitle());
    }
}