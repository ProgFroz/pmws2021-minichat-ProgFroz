package de.uniks.pmws2021.chat.util;

import de.uniks.pmws2021.chat.model.User;
import org.fulib.yaml.YamlIdMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResourceManager {
    // Choose your own SAVED_HEROES_FOLDER_NAME and SAVED_HEROES_FILE_NAME
    // Add the saved-hero-folder-name to your .gitignore
    private static final Path USERS_FOLDER = Path.of("saves");
    private static final Path USERS_FILE = USERS_FOLDER.resolve("users");

    // static constructor magic to create the file if absent
    static {
        try {
            if (!Files.isDirectory(USERS_FOLDER)) {
                Files.createDirectory(USERS_FOLDER);
            }
            if (!Files.exists(USERS_FILE)) {
                Files.createFile(USERS_FILE);
            }
        } catch (Exception e) {
            System.err.println("Error while loading " + USERS_FILE);
            e.printStackTrace();
        }
    }

    public static List<User> loadServerUsers() {
        List<User> result = new ArrayList<>();
        try {
            if (!Files.exists(USERS_FILE)) {
                Files.createFile(USERS_FILE);
            }
            // try to read heroList from File
            String heroString = Files.readString(USERS_FILE);

            // parse yaml-string to YamlIdMap
            YamlIdMap yamlIdMap = new YamlIdMap(User.class.getPackageName());

            // decode map
            yamlIdMap.decode(heroString);

            // map the decoded yaml data to real java objects and return list of heros
            yamlIdMap.getObjIdMap().values().forEach((Object object) -> {
                if (object instanceof User) {
                    result.add((User) object);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void saveServerUsers(User user) {
        // load all existing heroes
        List<User> oldUsers = loadServerUsers();
        
        // delete existing hero with the same name as the victor
        oldUsers.removeIf(oldUser -> oldUser.getName().equals(user.getName()));
        // add copy of victor to list
        User toSave = new User().setIp(user.getIp()).setName(user.getName()).setStatus(user.getStatus());

        // serialize as yaml

        oldUsers.add(toSave);
        // save as .yaml
        YamlIdMap yamlIdMap = new YamlIdMap(User.class.getPackageName());
        yamlIdMap.discoverObjects(oldUsers);
        String yamlData = yamlIdMap.encode();

        try {
            Files.write(USERS_FILE, Collections.singleton(yamlData));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Path getFilePath() {
        return USERS_FILE;
    }
}
