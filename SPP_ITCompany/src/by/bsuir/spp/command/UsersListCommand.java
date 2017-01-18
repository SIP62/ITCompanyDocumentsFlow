package by.bsuir.spp.command;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.itextpdf.text.DocumentException;

import by.bsuir.spp.entities.Users;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.UserCSVOutput;
import by.bsuir.spp.service.UserExcelOutput;
import by.bsuir.spp.service.UserPDFOutput;
import by.bsuir.spp.service.UsersListService;

public class UsersListCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		boolean isOutput = false;
		String message = null;
		String outputFile = request.getParameter("output_file");
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		
		UsersListService usersListService = new UsersListService();
		List<Users> userList = usersListService.getUsersList();
		request.setAttribute("userList", userList);
		
		if(outputFile == null) outputFile = "";
		System.out.println("outputFile = " + outputFile);
		switch (outputFile) {
		case "excel":
			UserExcelOutput ueo = new UserExcelOutput();
			try {
				isOutput = ueo.sendDataToExcel(userList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message = "message.userexceloutput";
			break;
		case "pdf":
			UserPDFOutput upo = new UserPDFOutput();
			try {
				isOutput = upo.sendDataToPDF(userList);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message = "message.userpdfoutput";
			break;
		case "csv":
			UserCSVOutput uco = new UserCSVOutput();
			try {
				isOutput = uco.sendDataToCSV(userList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message = "message.usercsvoutput";
			break;

		default:
			break;
		}
		if (isOutput) {
			request.setAttribute("userOutputMessage",
					MessageManager.getProperty(message));
		}
		
		page = ConfigurationManager.getProperty("path.page.admin");
			
		request.setAttribute("user_id", userId);
		request.setAttribute("role", role);
		request.setAttribute("user", user);
		return page;
	}

}
