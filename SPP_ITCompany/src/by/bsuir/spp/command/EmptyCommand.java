package by.bsuir.spp.command;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.resource.ConfigurationManager;

public class EmptyCommand implements ActionCommand {
	@Override
	public String execute(HttpServletRequest request) {
		/* � ������ ������ ��� ������� ��������� � �����������
	 	* ������������� �� �������� ����� ������ */
		String page = ConfigurationManager.getProperty("path.page.login");
		return page;
	}

}
