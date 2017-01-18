package by.bsuir.spp.command;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.itextpdf.text.DocumentException;

import by.bsuir.spp.entities.Employee;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;
import by.bsuir.spp.service.EmployeeCSVOutput;
import by.bsuir.spp.service.EmployeeDataService;
import by.bsuir.spp.service.EmployeeExcelOutput;
import by.bsuir.spp.service.EmployeePDFOutput;

public class EmployeeDataCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		boolean isOutput = false;
		String message = null;
		String outputFile = request.getParameter("output_file");
		String userId = request.getParameter("user_id");
		String user = request.getParameter("user");
		String role = request.getParameter("role");
		
		EmployeeDataService employeeDataService = new EmployeeDataService();
		Employee employee = employeeDataService.getEmployeeData(request);
		request.setAttribute("employee", employee);
		
		if(outputFile == null) outputFile = "";
		System.out.println("outputFile = " + outputFile);
		switch (outputFile) {
		case "excel":
			EmployeeExcelOutput eeo = new EmployeeExcelOutput();
			try {
				isOutput = eeo.sendDataToExcel(employee);
				message = "message.employeeexceloutput";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "pdf":
			EmployeePDFOutput epo = new EmployeePDFOutput();
			try {
				isOutput = epo.sendDataToPDF(employee);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message = "message.employeepdfoutput";
			break;
		case "csv":
			EmployeeCSVOutput eco = new EmployeeCSVOutput();
			try {
				isOutput = eco.sendDataToCSV(employee);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message = "message.employeecsvoutput";
			break;

		default:
			break;
		}
		if (isOutput) {
			request.setAttribute("employeeOutputMessage",
					MessageManager.getProperty(message));
		}
		
		request.setAttribute("user_id", userId);
		request.setAttribute("user", user);
		request.setAttribute("role", role);
		if (role.equals("admin")) {
			page = ConfigurationManager.getProperty("path.page.admin");
		} else {
			page = ConfigurationManager.getProperty("path.page.employee");
		}
		return page;
	}

}
