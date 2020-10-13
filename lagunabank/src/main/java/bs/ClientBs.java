package bs;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import dao.ClientDao;
import pojos.Account;
import pojos.Client;
import pojos.Contact;
import pojos.Direction;
import pojos.Movement;

public class ClientBs {
	public static Client getClientById(Integer idClient) {
		return ClientDao.getClientById(idClient);
	}
	
	public static Client getClientByCurp(String curp) {
		return ClientDao.getClientByCurp(curp);
	}
	
	public static Client getClientByEmail(String email) {
		return ClientDao.getClientByEmail(email);
	}
	
	public static Client getClientByPhone(String phone) {
		return ClientDao.getClientByPhone(phone);
	}
	
	public static Boolean addClient(Map<String, String[]> parameterMap) {
		Boolean correct = false;
		String name = parameterMap.get("nameTxt")[0];
		String surname = parameterMap.get("surnameTxt")[0];
		String lastname = parameterMap.get("lastnameTxt")[0];
		String curp = parameterMap.get("curpTxt")[0];
		String phone = parameterMap.get("phoneTxt")[0];
		String email = parameterMap.get("emailTxt")[0];
		String street = parameterMap.get("streetTxt")[0];
		String number = parameterMap.get("numberTxt")[0];
		String suburb = parameterMap.get("suburbTxt")[0];
		String townhall = parameterMap.get("townhallTxt")[0];
		String state = parameterMap.get("stateTxt")[0];
		String country = parameterMap.get("countryTxt")[0];
		String[] dateParts = parameterMap.get("birthdayDate")[0].split("-");
		LocalDate birthday = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
		List<Movement> movements = null;
		BigDecimal balance;
		if(parameterMap.get("balanceTxt")[0] == "") {
			balance = new BigDecimal("0");
		} else {
			balance = new BigDecimal(parameterMap.get("balanceTxt")[0]);
		}
		List<BigDecimal> historicalBalances = null;
		String photo = "";
		List<Account> savedAccounts = null;
		String gender = parameterMap.get("genderTxt")[0];
		Contact contact = new Contact(phone, email);
		Direction direction = new Direction(street, number, suburb, townhall, state, country);
		Client client = new Client(name, surname, lastname, curp, contact, direction, birthday, balance, historicalBalances, movements, savedAccounts, photo, gender);
		if(ClientDao.addClient(client)) {
			correct = true;
		}
		return correct;
	}

	public static Boolean editClient(Client client, Integer idClient) {
		return ClientDao.editClient(client, idClient);
	}
	
	public static Boolean editSavedAccount(Integer idClient, List<Account> savedAccounts) {
		return ClientDao.editSavedAccounts(idClient, savedAccounts);
	}
	
	public static Boolean editMovements(Integer idClient, List<Movement> movements) {
		return ClientDao.editMovements(idClient, movements);
	}
	
	public static Boolean editBalance(Integer idClient, BigDecimal balance) {
		return ClientDao.editBalance(idClient, balance);
	}
	
	public static Boolean changeProfilePhoto(String profilePhoto, Client client) {
		return ClientDao.changeProfilePhoto(profilePhoto, client);
	}
	
	public static Boolean removeProfilePhoto(Client client) {
		return ClientDao.removeProfilePhoto(client);
	}
}
