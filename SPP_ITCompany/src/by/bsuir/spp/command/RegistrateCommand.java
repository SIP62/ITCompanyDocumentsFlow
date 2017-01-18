package by.bsuir.spp.command;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.RegistrationService;

public class RegistrateCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		
		String page = null;
		
		RegistrationService registrationService = new RegistrationService();
		boolean isRegistrated = registrationService.addUser(request);
		if (isRegistrated) {
			request.setAttribute("registrationMessage",
					MessageManager.getProperty("message.registration"));
			//  определение пути к client.jsp
			page = ConfigurationManager.getProperty("path.page.login");

		} else {
			request.setAttribute("errorRegistrationMessage",
			MessageManager.getProperty("message.registrationerror"));
			page = ConfigurationManager.getProperty("path.page.login");
		}
		return page;
	}

}
