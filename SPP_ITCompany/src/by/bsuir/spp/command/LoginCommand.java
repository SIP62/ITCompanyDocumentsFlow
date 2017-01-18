package by.bsuir.spp.command;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.Users;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.AuthentificationService;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		// извлечение из запроса логина и пароля
		AuthentificationService authentificationService = new AuthentificationService();
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		String role = "anonym";
		
		// проверка логина и пароля
		
		Users user = authentificationService.checkLogin(login, pass);
		
		if (user != null) {
			request.setAttribute("user_id", user.getId());
			request.setAttribute("user", user.getName());
			role = user.getRoles().getRole();
			request.setAttribute("role", role);
			
			switch (role) {
			case "client":
				page = ConfigurationManager.getProperty("path.page.client");
				break;
			case "programmer":
			case "team_leader":
			case "project_manager":
			case "client_manager":	
			case "HR":
				page = ConfigurationManager.getProperty("path.page.employee");
				break;
			case "admin":
				page = ConfigurationManager.getProperty("path.page.admin");
				break;
			case "guest":
				page = ConfigurationManager.getProperty("path.page.user");
				break;
			default:
				page = ConfigurationManager.getProperty("path.page.login");
			}
		} else {
			request.setAttribute("errorLoginPassMessage",
			MessageManager.getProperty("message.loginerror"));
			page = ConfigurationManager.getProperty("path.page.login");
		}
		return page;
	}

}
