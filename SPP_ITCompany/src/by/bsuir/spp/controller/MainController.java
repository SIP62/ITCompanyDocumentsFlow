package by.bsuir.spp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.spp.command.ActionCommand;
import by.bsuir.spp.command.factory.ActionFactory;
import by.bsuir.spp.resource.ConfigurationManager;
import by.bsuir.spp.resource.MessageManager;

/**
 * Servlet implementation class MainController
 */
@WebServlet(description = "Main Controller", urlPatterns = { "/mainController" })
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		String page = null;
		// ����������� �������, ��������� �� JSP
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);
		/*
		* ����� �������������� ������ execute() � �������� ����������
		* ������-����������� ���������� �������
		*/
		page = command.execute(request);
		// ����� ���������� �������� ������
		// page = null; // ��������������������!
		if (page != null) {
			RequestDispatcher dispatcher =
			getServletContext().getRequestDispatcher(page);
			// ����� �������� ������ �� ������
			dispatcher.forward(request, response);
		} else {
			// ��������� �������� c c��������� �� ������
			page = ConfigurationManager.getProperty("path.page.index");
			request.getSession().setAttribute("nullPage",
			MessageManager.getProperty("message.nullpage"));
			response.sendRedirect(request.getContextPath() + page);
		}
	}	

	

}
