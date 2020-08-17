package pojos;

public class User {
	private Integer idUser;
	private String username;
	private String password;
	private Integer idClient;
	
	public User(Integer idUser, String username, String password, Integer idClient) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.idClient = idClient;
	}
	
	public User(String username, String password, Integer idClient) {
		super();
		this.username = username;
		this.password = password;
		this.idClient = idClient;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}
}
