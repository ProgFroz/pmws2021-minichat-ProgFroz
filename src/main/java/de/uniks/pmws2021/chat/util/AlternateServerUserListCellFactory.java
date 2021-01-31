package de.uniks.pmws2021.chat.util;

import de.uniks.pmws2021.chat.model.User;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class AlternateServerUserListCellFactory implements Callback<ListView<User>, ListCell<User>> {

    @Override
    public ListCell<User> call(ListView<User> param) {
        return new UserListCell();
    }

    public static class UserListCell extends ListCell<User> {
        @Override
        protected void updateItem(User item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                this.setText(item.getName());
            }
        }
    }
}
