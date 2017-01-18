package by.bsuir.spp.service;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.AddClientDAO;
import by.bsuir.spp.entities.Client;

public class AddClientService {
	AddClientDAO acd = new AddClientDAO();

	public boolean addClient(HttpServletRequest request) {
		
		Client client = new Client();
		PassScrambler ps = new PassScrambler();
		
		client.getUsers().setName(request.getParameter("name"));
		client.setPaymentCredentials(request.getParameter("payment_credentials"));
		client.setPhone(request.getParameter("phone"));
		client.setEmail(request.getParameter("email"));
		client.setDiscount(Float.parseFloat(request.getParameter("discount")));
		client.getUsers().setLogin(request.getParameter("login"));
		client.getUsers().setPassword(ps.scramble(request.getParameter("password")));
		client.setAddress(request.getParameter("address"));
		client.getUsers().getRoles().setId(Integer.parseInt(request.getParameter("id_roles")));
		
		return acd.addClientInDB(client);

	}

}
