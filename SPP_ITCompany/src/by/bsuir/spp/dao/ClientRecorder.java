package by.bsuir.spp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.bsuir.spp.entities.Client;


public class ClientRecorder {
	public void insertClient(PreparedStatement ps, Client client) {
		

		try {
			ps.setString(1, client.getUsers().getName());
			ps.setString(2, client.getPaymentCredentials());
			ps.setString(3, client.getPhone());
			ps.setString(4, client.getEmail());
			ps.setFloat(5, client.getDiscount());
			ps.setString(6, client.getAddress());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Record to db is failed");
			e.printStackTrace();
		}

	}
}
