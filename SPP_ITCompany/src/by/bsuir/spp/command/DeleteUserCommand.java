package by.bsuir.spp.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.entities.Users;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.DeleteUserService;
import by.bsuir.spp.service.UsersListService;

public class DeleteUserCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		
		DeleteUserService deleteUserService = new DeleteUserService();
		boolean isDeleted = deleteUserService.removeUser(request);

		UsersListService usersListService = new UsersListService();
		List<Users> userList = usersListService.getUsersList();
		request.setAttribute("userList", userList);
		
		if (!isDeleted) {
			request.setAttribute("errorDeleteMessage",
					MessageManager.getProperty("message.deleteerror"));
		}
		
		page = ConfigurationManager.getProperty("path.page.admin");
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("role", role);
		
		return page;
	}

}
