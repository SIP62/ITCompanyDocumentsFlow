package by.bsuir.spp.command;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.itextpdf.text.DocumentException;

import by.bsuir.spp.entities.Client;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.ClientCSVOutput;
import by.bsuir.spp.service.ClientDataService;
import by.bsuir.spp.service.ClientExcelOutput;
import by.bsuir.spp.service.ClientPDFOutput;

public class ClientDataCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		boolean isOutput = false;
		String message = null;
		String outputFile = request.getParameter("output_file");
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		
		ClientDataService clientDataService = new ClientDataService();
		Client client = clientDataService.getClientData(request);
		request.setAttribute("client", client);
		
		if(outputFile == null) outputFile = "";
		System.out.println("outputFile = " + outputFile);
		switch (outputFile) {
		case "excel":
			ClientExcelOutput ceo = new ClientExcelOutput();
			try {
				isOutput = ceo.sendDataToExcel(client);
				message = "message.clientexceloutput";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "pdf":
			ClientPDFOutput cpo = new ClientPDFOutput();
			try {
				isOutput = cpo.sendDataToPDF(client);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message = "message.clientpdfoutput";
			break;
		case "csv":
			ClientCSVOutput cco = new ClientCSVOutput();
			try {
				isOutput = cco.sendDataToCSV(client);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message = "message.clientcsvoutput";
			break;

		default:
			break;
		}
		if (isOutput) {
			request.setAttribute("clientOutputMessage",
					MessageManager.getProperty(message));
		}
		switch (role) {
		case "client":
			page = ConfigurationManager.getProperty("path.page.client");
			break;
		case "programmer":
		case "team_leader":
		case "project_manager":
		case "HR":
		case "client_manager":	
			page = ConfigurationManager.getProperty("path.page.employee");
			break;
		case "admin":
		
			page = ConfigurationManager.getProperty("path.page.admin");
			break;
		case "guest":
			page = ConfigurationManager.getProperty("path.page.login");
			break;
		default:
			page = ConfigurationManager.getProperty("path.page.login");
		}
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("role", role);
		
		return page;
	}

}
