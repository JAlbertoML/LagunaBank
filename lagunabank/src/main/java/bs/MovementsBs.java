package bs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojos.Client;
import pojos.Movement;

public class MovementsBs {
	public static String makeWithdrawal(Client client, String amount, String description) {
		String message = null;
		try {
			BigDecimal amountMov = new BigDecimal(amount);
			Date movDate = new Date(System.currentTimeMillis());
			if (client.getBalance().compareTo(amountMov) == 1) {
				Movement movement = new Movement(amountMov, Movement.MOV_WITHDRAWAL, movDate, description);
				List<Movement> movements = (ArrayList<Movement>) client.getMovements();
				movements.add(0, movement);
				if (ClientBs.editMovements(client.getIdClient(), movements)) {
					if (ClientBs.editBalance(client.getIdClient(), client.getBalance().subtract(amountMov))) {
						message = null;
					} else {
						message = "El retiro no fue completado con éxito.";
					}
				} else {
					message = "El retiro no fue completado con éxito.";
				}
			} else {
				message = "No tienes fondos suficientes para hacer ese retiro.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Ingresa un monto valido";
		}
		return message;
	}

	public static String makeTopUpBalance(Client client, String amount) {
		String message = null;
		try {
			BigDecimal tubAmount = new BigDecimal(amount);
			Date movDate = new Date(System.currentTimeMillis());
			Movement movement = new Movement(tubAmount, Movement.MOV_TOP_UP_BALANCE, movDate, "Recarga de saldo");
			List<Movement> movements = (ArrayList<Movement>) client.getMovements();
			movements.add(0, movement);
			if (ClientBs.editMovements(client.getIdClient(), movements)) {
				if (ClientBs.editBalance(client.getIdClient(), client.getBalance().add(tubAmount))) {
					message = null;
				} else {
					message = "La recarga no fue completada con éxito.";
				}
			} else {
				message = "La recarga no fue completada con éxito.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Ingresa un monto valido";
		}
		return message;
	}

	public static String makeTransfer(Client client, String amount, String idReceiver, String description) {
		String message = null;
		try {
			BigDecimal transferAmount = new BigDecimal(amount);
			if (editSender(client, transferAmount, idReceiver, description)) {
				if (editReceiver(client.getIdClient(), transferAmount, idReceiver, description)) {
					message = null;
				} else {
					message = "La transferecia no fue completada con éxito.";
				}
			} else {
				message = "La transferecia no fue completada con éxito.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Ingresa un monto valido";
		}
		return message;
	}

	private static Boolean editSender(Client client, BigDecimal amount, String idReceiver, String description) {
		Boolean correct = false;
		Date movDate = new Date(System.currentTimeMillis());
		Movement movement = new Movement(amount, Movement.MOV_TRANSFER, movDate,
				description + " - Al N° de cliente " + idReceiver);
		List<Movement> movements = (ArrayList<Movement>) client.getMovements();
		movements.add(0, movement);
		if (ClientBs.editMovements(client.getIdClient(), movements)) {
			if (ClientBs.editBalance(client.getIdClient(), client.getBalance().subtract(amount))) {
				correct = true;
			}
		}
		return correct;
	}

	private static Boolean editReceiver(Integer idSender, BigDecimal amount, String idReceiver, String description) {
		Boolean correct = false;
		Date movDate = new Date(System.currentTimeMillis());
		Integer idClient = Integer.parseInt(idReceiver);
		Client client = ClientBs.getClientById(idClient);
		Movement movement = new Movement(amount, Movement.MOV_PAYMENT, movDate,
				description + " - Del N° de cliente " + idSender.toString());
		List<Movement> movements = (ArrayList<Movement>) client.getMovements();
		movements.add(0, movement);
		if (ClientBs.editMovements(client.getIdClient(), movements)) {
			if (ClientBs.editBalance(client.getIdClient(), client.getBalance().add(amount))) {
				correct = true;
			}
		}
		return correct;
	}
}
