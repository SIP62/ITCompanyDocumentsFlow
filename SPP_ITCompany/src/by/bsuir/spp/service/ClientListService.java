package by.bsuir.spp.service;

import java.util.ArrayList;
import java.util.List;

import by.bsuir.spp.dao.ClientListDAO;
import by.bsuir.spp.entities.Client;

public class ClientListService {

	public List<Client> getClientList() {
		List<Client> clientList = new ArrayList<Client>();
		ClientListDAO eld = new ClientListDAO();
		clientList = eld.viewClientList();
		return clientList;
	}

}
