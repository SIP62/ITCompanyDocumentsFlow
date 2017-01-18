package by.bsuir.spp.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import by.bsuir.spp.entities.Users;

public class UserCSVOutput {

	public boolean sendDataToCSV(List<Users> userList) throws IOException {
		boolean isOutput = false;
		@SuppressWarnings("resource")
		FileOutputStream out = new FileOutputStream(new File("userlistoutput.csv"));
		String source = "ID,User,Status";
		if (!userList.isEmpty()) {
	    	  for (Users user: userList) {
	    		  source = source +"\n" + user.getId() + "," + user.getName() + "," 
	    				  + user.getRoles().getRole();
	    	  }
		}
		System.out.println(source);
		byte buf[] = source.getBytes();
		out.write(buf);
		
		isOutput = true;
	    System.out.println("userlistoutput.csv written successfully");
		return isOutput;
	}

}
