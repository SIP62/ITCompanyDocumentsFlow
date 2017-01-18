package by.bsuir.spp.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import by.bsuir.spp.entities.Employee;

public class EmployeeCSVOutput {

	public boolean sendDataToCSV(Employee employee) throws IOException {
		boolean isOutput = false;
		@SuppressWarnings("resource")
		FileOutputStream out = new FileOutputStream(new File("employeedataoutput.csv"));
		String source = "Name," + employee.getUsers().getName() +"\n";
		source = source + "Address," + employee.getAddress() +"\n";
		source = source + "Phone," + employee.getPhone() +"\n";
		source = source + "Passport," + employee.getPassport() +"\n";
		source = source + "Credit card," + employee.getCreditCard() +"\n";
		source = source + "Resume," + employee.getResume() +"\n";
		source = source + "Specialization," + employee.getSpecialization() +"\n";
		source = source + "Salary," + employee.getSalary() +"\n";
		source = source + "Recruitment date," + employee.getRecruitmentDate() +"\n";
		source = source + "Contract expiration date," + employee.getContractExpirationDate() +"\n";
		source = source + "Status," + employee.getUsers().getRoles().getRole();
		byte buf[] = source.getBytes();
		out.write(buf);
		
		isOutput = true;
	    System.out.println("employeedataoutput.csv written successfully");
		return isOutput;
	}

}
