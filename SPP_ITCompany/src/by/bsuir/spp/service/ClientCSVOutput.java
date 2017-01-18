package by.bsuir.spp.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import by.bsuir.spp.entities.Client;

public class ClientCSVOutput {

	public boolean sendDataToCSV(Client client) throws IOException {
		boolean isOutput = false;
		@SuppressWarnings("resource")
		FileOutputStream out = new FileOutputStream(new File("clientdataoutput.csv"));
		String source = "Name," + client.getUsers().getName() +"\n";
		source = source + "Payment Credentials," + client.getPaymentCredentials() +"\n";
		source = source + "Phone," + client.getPhone() +"\n";
		source = source + "e-Mail," + client.getEmail() +"\n";
		source = source + "Address," + client.getAddress() +"\n";
		source = source + "Discount," + client.getDiscount();
		byte buf[] = source.getBytes();
		out.write(buf);
		
		isOutput = true;
	    System.out.println("clientdataoutput.csv written successfully");
		return isOutput;
	}

}
