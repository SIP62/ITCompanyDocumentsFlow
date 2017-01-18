package by.bsuir.spp.command;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.AddRecruitService;

public class AddRecruitCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		AddRecruitService addRecruitService = new AddRecruitService();
		boolean isRecruitAdded = addRecruitService.addRecruit(request);
		
		if (isRecruitAdded) {
			request.setAttribute("addRecruitMessage",
					MessageManager.getProperty("message.newrecruit"));
			//  определение пути к jsp
			page = ConfigurationManager.getProperty("path.page.user");
		} else {
			request.setAttribute("errorRecruitMessage",
			MessageManager.getProperty("message.recruiterror"));
			page = ConfigurationManager.getProperty("path.page.recruitform");
		}
		request.setAttribute("user_id", userId);
		request.setAttribute("role", role);
		request.setAttribute("user", user);
		
		return page;
	}

}
