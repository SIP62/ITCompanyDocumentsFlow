package by.bsuir.spp.resource;

import java.util.ResourceBundle;

public class MessageManager {
	private final static ResourceBundle resourceBundle =
			ResourceBundle.getBundle("by.bsuir.spp.resource.messages");
	// класс извлекает информацию из файла messages.properties
	private MessageManager() { }
	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}

}
