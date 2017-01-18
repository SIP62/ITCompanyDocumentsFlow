package by.bsuir.spp.resource;

import java.util.ResourceBundle;

public class ConfigurationManager {
	private final static ResourceBundle resourceBundle =
			ResourceBundle.getBundle("by.bsuir.spp.resource.config");
	// ����� ��������� ���������� �� ����� config.properties
	private ConfigurationManager() { }
	public static String getProperty(String key) {
		return resourceBundle.getString(key);				
	}

}
