package by.bsuir.spp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.bsuir.spp.entities.Client;

public class ClientUpdater {

public void updateClient(PreparedStatement ps, Client client) {
		

		try {
			
			ps.setString(1, client.getPaymentCredentials());
			ps.setString(2, client.getPhone());
			ps.setString(3, client.getEmail());
			ps.setFloat(4, client.getDiscount());
			ps.setString(5, client.getAddress());
			ps.setInt(6, client.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Record to db is failed");
			e.printStackTrace();
		}

	}
}
