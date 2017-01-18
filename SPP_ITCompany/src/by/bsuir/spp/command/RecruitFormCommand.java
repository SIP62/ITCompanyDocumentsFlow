package by.bsuir.spp.command;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.resource.ConfigurationManager;

public class RecruitFormCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		request.setAttribute("role", role);
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		page = ConfigurationManager.getProperty("path.page.recruitform");
		return page;
	}

}
