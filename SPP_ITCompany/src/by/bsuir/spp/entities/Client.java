package by.bsuir.spp.entities;

import java.util.List;

public class Client {
	private int id;
	private String paymentCredentials;
	private String phone;
	private String email;
	private float discount;
	private String address;
	private List<ClientEmployee> clientEmployees;
	private Users users;
	
	public Client(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaymentCredentials() {
		return paymentCredentials;
	}
	public void setPaymentCredentials(String paymentCredentials) {
		this.paymentCredentials = paymentCredentials;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public List<ClientEmployee> getCeList() {
		return clientEmployees;
	}

	public void setCeList(List<ClientEmployee> ceList) {
		this.clientEmployees = ceList;
	}

	public Users getUsers() {
		if (users == null) users = new Users();
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
}
