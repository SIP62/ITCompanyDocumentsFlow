package by.bsuir.spp.service;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.spp.dao.UpdateClientDataDAO;
import by.bsuir.spp.entities.Client;

public class UpdateClientDataService {
	UpdateClientDataDAO ucdd = new UpdateClientDataDAO();

	public boolean updateClientData(HttpServletRequest request) {
		
		Client client = new Client();
		PassScrambler ps = new PassScrambler();
		
		client.getUsers().setId(Integer.parseInt(request.getParameter("id_users")));
		client.getUsers().setName(request.getParameter("name"));
		client.getUsers().setLogin(request.getParameter("login"));
		client.getUsers().setPassword(ps.scramble(request.getParameter("password")));
		client.getUsers().getRoles().setId(Integer.parseInt(request.getParameter("id_roles")));
		
		client.setId(Integer.parseInt(request.getParameter("id_client")));
		client.setPaymentCredentials(request.getParameter("payment_credentials"));
		client.setPhone(request.getParameter("phone"));
		client.setEmail(request.getParameter("email"));
		client.setAddress(request.getParameter("address"));
		
		
		return ucdd.updateClientInDB(client);
	}

}
