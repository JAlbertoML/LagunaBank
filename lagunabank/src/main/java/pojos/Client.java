package pojos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Client extends Person {
	private Integer idClient;
	private BigDecimal balance;
	private List<BigDecimal> historicalBalances;
	private List<Movement> movements;
	private List<Account> savedAccounts;
	private String photo;
	
	public Client(String name, String surname, String lastname, String curp, Contact contact, Direction direction,
			LocalDate birthday, Integer idClient, BigDecimal balance, List<BigDecimal> historicalBalances,
			List<Movement> movements, List<Account> savedAccounts, String photo, String gender) {
		super(name, surname, lastname, curp, contact, direction, birthday, gender);
		this.idClient = idClient;
		this.balance = balance;
		this.historicalBalances = historicalBalances;
		this.movements = movements;
		this.savedAccounts = savedAccounts;
		this.photo = photo;
	}
	
	public Client(String name, String surname, String lastname, String curp, Contact contact, Direction direction,
			LocalDate birthday, BigDecimal balance, List<BigDecimal> historicalBalances,
			List<Movement> movements, List<Account> savedAccounts, String photo, String gender) {
		super(name, surname, lastname, curp, contact, direction, birthday, gender);
		this.balance = balance;
		this.historicalBalances = historicalBalances;
		this.movements = movements;
		this.savedAccounts = savedAccounts;
		this.photo = photo;
	}
	
	public Client(String name, String surname, String lastname, String curp, Contact contact, Direction direction,
			LocalDate birthday, String gender) {
		super(name, surname, lastname, curp, contact, direction, birthday, gender);
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public List<BigDecimal> getHistoricalBalances() {
		return historicalBalances;
	}

	public void setHistoricalBalances(List<BigDecimal> historicalBalances) {
		this.historicalBalances = historicalBalances;
	}

	public List<Movement> getMovements() {
		return movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}

	public List<Account> getSavedAccounts() {
		return savedAccounts;
	}

	public void setSavedAccounts(List<Account> savedAccounts) {
		this.savedAccounts = savedAccounts;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
