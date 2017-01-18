package by.bsuir.spp.entities;

public class Users {
	private int id;
	private String name;
	private String login;
	private String password;
	private Roles roles;
	
	public Users() {}

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Roles getRoles() {
		if (roles == null) roles = new Roles();
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	
	
}
