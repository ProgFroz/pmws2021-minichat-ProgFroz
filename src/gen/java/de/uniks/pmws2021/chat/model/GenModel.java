package de.uniks.pmws2021.chat.model;

import org.fulib.builder.ClassModelDecorator;
import org.fulib.builder.ClassModelManager;
import org.fulib.builder.Type;
import org.fulib.builder.reflect.Link;
import org.fulib.classmodel.Clazz;

import java.util.List;

public class GenModel implements ClassModelDecorator
{
	class User {
		String name;
		String ip;
		boolean status;

		@Link("availableUser")
		Chat chat;
	}

	class Chat {
		String currentUsername;

		@Link("chat")
		List<User> availableUser;
	}
	@Override
	public void decorate(ClassModelManager mm)
	{
		mm.haveNestedClasses(GenModel.class);
	}
}
