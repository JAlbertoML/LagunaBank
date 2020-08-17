package pojos;

public class Account {
	private Integer idAccout;
	private String Alias;

	public Account(Integer idAccout, String alias) {
		super();
		this.idAccout = idAccout;
		Alias = alias;
	}

	public Integer getIdAccout() {
		return idAccout;
	}

	public void setIdAccout(Integer idAccout) {
		this.idAccout = idAccout;
	}

	public String getAlias() {
		return Alias;
	}

	public void setAlias(String alias) {
		Alias = alias;
	}

}
