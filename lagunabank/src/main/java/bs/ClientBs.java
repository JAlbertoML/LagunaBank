package bs;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
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
		Date birthday;
		String[] dateParts = parameterMap.get("birthdayDate")[0].split("-");
		try {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, Integer.parseInt(dateParts[0]));
			cal.set(Calendar.MONTH, Integer.parseInt(dateParts[1]));
			cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateParts[2]));
			birthday = cal.getTime();
		} catch (NumberFormatException e) {
			birthday = null;
		}
		List<Movement> movements = null;
		BigDecimal balance = new BigDecimal(parameterMap.get("balanceTxt")[0]);
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
}
