package by.bsuir.spp.command.factory;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.command.ActionCommand;
import by.bsuir.spp.command.EmptyCommand;
import by.bsuir.spp.command.client.CommandEnum;
import by.bsuir.spp.resource.MessageManager;



public class ActionFactory {
	
	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand();
		// ���������� ����� ������� �� �������
		String action = request.getParameter("command");
		if (action == null || action.isEmpty()) {
			// ���� ������� �� ������ � ������� �������
			return current;
		}
		// ��������� �������, ���������������� �������
		try {
			CommandEnum currentEnum =
					CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action
					+ MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}

}
