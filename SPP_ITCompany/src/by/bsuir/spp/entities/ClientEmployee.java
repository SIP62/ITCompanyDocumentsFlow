package by.bsuir.spp.entities;

public class ClientEmployee {
	private int id;
	private String name;
	private String phone;
	private String email;
	private String skype;
	private String status;
	private Client client;
	
	public ClientEmployee() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getSkype() {
		return skype;
	}
	public void setSkype(String skype) {
		this.skype = skype;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Client getClient() {
		if (client == null) client = new Client();
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
}
