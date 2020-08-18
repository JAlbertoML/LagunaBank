package bs;

import java.util.List;
import pojos.Account;

public class SavedAccountsBs {
	public static String addAccount(Integer idClient, String idAccount, String name, List<Account> savedAccounts) {
		String message = null;
		if(isAllFilled(idAccount, name)) {
			if(isIdClientCorrect(idAccount)) {
				if(idClient != Integer.parseInt(idAccount)) {
					Boolean exists = false;
					for(Account account: savedAccounts) {
						if(account.getIdAccout() == Integer.parseInt(idAccount)) {
							exists = true;
							break;
						}
					}
					if(!exists) {
						savedAccounts.add(new Account(Integer.parseInt(idAccount), name));
						ClientBs.editSavedAccount(idClient, savedAccounts);
					} else {
						message = "El cliente que estás intentando registrar ya está en tu lista de cuentas guardadas.";
					}
				} else {
					message = "No puedes agregar tu propia cuenta.";
				}
			} else {
				message = "El número de cliente ingresado no existe o es incorrecto. Intentalo de nuevo.";
			}
		} else {
			message = "Asegurate de llenar todos los campos.";
		}
		return message;
	}
	
	private static Boolean isIdClientCorrect(String idAccount) {
		Boolean correct = false;
		try {
			Integer idClient = Integer.parseInt(idAccount);
			if(ClientBs.getClientById(idClient) != null) {
				correct = true;
			} else {
				correct = false;
			}
		} catch (NumberFormatException e) {
			correct = false;
		}
		return correct;
	}
	
	private static Boolean isAllFilled(String idAccount, String name) {
		Boolean correct = true;
		if(idAccount.equals("") || name.equals("")) {
			correct = false;
		} 
		return correct;
	}
}
