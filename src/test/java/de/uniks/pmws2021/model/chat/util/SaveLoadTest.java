package de.uniks.pmws2021.model.chat.util;

import de.uniks.pmws2021.chat.constants.Status;
import de.uniks.pmws2021.chat.model.Chat;
import de.uniks.pmws2021.chat.model.User;
import de.uniks.pmws2021.chat.util.ResourceManager;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.util.List;

public class SaveLoadTest {

    @Test
    public void saveLoadTest() {
        try {
            if (Files.exists(ResourceManager.getFilePath())) {
                Files.deleteIfExists(ResourceManager.getFilePath());
            }
        } catch (Exception e) {
            System.err.println("Error while deleting " + ResourceManager.getFilePath());
            e.printStackTrace();
        }

        String username = "Karl";
        String username2 = "Hans";
        User user1 = new User().setIp("1.1.1.1").setName(username).setStatus(Status.ONLINE);
        User user2 = new User().setIp("2.2.2.2").setName(username2).setStatus(Status.OFFLINE);

        ResourceManager.saveServerUsers(user1);
        ResourceManager.saveServerUsers(user2);

        List<User> users = ResourceManager.loadServerUsers();

        users.forEach((User u) -> {
            if (u.getName().equals(username)) {
                Assert.assertEquals(username, u.getName());
                Assert.assertEquals("1.1.1.1", u.getIp());
                Assert.assertEquals(Status.ONLINE, u.getStatus());
            } else if (u.getName().equals(username2)) {
                Assert.assertEquals(username2, u.getName());
                Assert.assertEquals("2.2.2.2", u.getIp());
                Assert.assertEquals(Status.OFFLINE, u.getStatus());
            }
        });

    }
}
