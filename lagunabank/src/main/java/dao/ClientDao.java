package dao;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pojos.Account;
import pojos.Client;
import pojos.Contact;
import pojos.Direction;
import pojos.Movement;
import pojos.Person;

public class ClientDao {
	public static Client getClientById(Integer idClient) {
		Client client = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from client where idclient = ?");
			preparedStatement.setInt(1, idClient);
			preparedStatement.execute();
			ResultSet result = preparedStatement.getResultSet();
			if (result.next()) {
				Gson gson = new Gson();
				Type movementListType = new TypeToken<List<Movement>>() {
				}.getType();
				Type balancesListType = new TypeToken<List<BigDecimal>>() {
				}.getType();
				Type savedAccountsListType = new TypeToken<List<Account>>() {
				}.getType();
				String name = result.getString("name");
				String surname = result.getString("surname");
				String lastname = result.getString("lastname");
				String curp = result.getString("curp");
				String phone = result.getString("phone");
				String email = result.getString("email");
				String street = result.getString("street");
				String number = result.getString("number");
				String suburb = result.getString("suburb");
				String townhall = result.getString("townhall");
				String state = result.getString("state");
				String country = result.getString("country");
				LocalDate birthday = result.getDate("birthday").toLocalDate();
				String gender = result.getString("gender");
				BigDecimal balance = result.getBigDecimal("balance");
				List<Movement> movements = gson.fromJson(result.getString("movements"), movementListType);
				if(movements == null) {
					movements = new ArrayList<Movement>();
				}
				List<BigDecimal> historicalBalances = gson.fromJson(result.getString("historicalBalances"),
						balancesListType);
				List<Account> savedAccounts = gson.fromJson(result.getString("savedAccounts"), savedAccountsListType);
				String photo = result.getString("photo");
				if (photo == null || photo.equals("")) {
					if (gender.equals(Person.MALE_GENDER)) {
						photo = "img/profileMan.png";
					} else if (gender.equals(Person.FEMALE_GENDER)) {
						photo = "img/profileWoman.png";
					} else if (gender.equals(Person.OTHER_GENDER)) {
						photo = "img/profileNeutral.png";
					}
				}
				Contact contact = new Contact(phone, email);
				Direction direction = new Direction(street, number, suburb, townhall, state, country);
				client = new Client(name, surname, lastname, curp, contact, direction, birthday, idClient, balance,
						historicalBalances, movements, savedAccounts, photo, gender);
			}
		} catch (SQLException e) {
			System.out.println("--> Error en la consulta de usuario");
			e.printStackTrace();
		}
		return client;
	}

	public static Client getClientByCurp(String curp) {
		Client client = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from client where curp = ?");
			preparedStatement.setString(1, curp);
			preparedStatement.execute();
			ResultSet result = preparedStatement.getResultSet();
			if (result.next()) {
				Gson gson = new Gson();
				Type movementListType = new TypeToken<List<Movement>>() {
				}.getType();
				Type balancesListType = new TypeToken<List<BigDecimal>>() {
				}.getType();
				Type savedAccountsListType = new TypeToken<List<Account>>() {
				}.getType();
				Integer idClient = result.getInt("idclient");
				String name = result.getString("name");
				String surname = result.getString("surname");
				String lastname = result.getString("lastname");
				String phone = result.getString("phone");
				String email = result.getString("email");
				String street = result.getString("street");
				String number = result.getString("number");
				String suburb = result.getString("suburb");
				String townhall = result.getString("townhall");
				String state = result.getString("state");
				String country = result.getString("country");
				LocalDate birthday = result.getDate("birthday").toLocalDate();
				String gender = result.getString("gender");
				BigDecimal balance = result.getBigDecimal("balance");
				List<Movement> movements = gson.fromJson(result.getString("movements"), movementListType);
				if(movements == null) {
					movements = new ArrayList<Movement>();
				}
				List<BigDecimal> historicalBalances = gson.fromJson(result.getString("historicalBalances"),
						balancesListType);
				List<Account> savedAccounts = gson.fromJson(result.getString("savedAccounts"), savedAccountsListType);
				String photo = result.getString("photo");
				if (photo == null || photo == "") {
					if (gender.equals(Person.MALE_GENDER)) {
						photo = "img/profileMan.png";
					} else if (gender.equals(Person.FEMALE_GENDER)) {
						photo = "img/profileWoman.png";
					} else if (gender.equals(Person.OTHER_GENDER)) {
						photo = "img/profileNeutral.png";
					}
				}
				Contact contact = new Contact(phone, email);
				Direction direction = new Direction(street, number, suburb, townhall, state, country);
				client = new Client(name, surname, lastname, curp, contact, direction, birthday, idClient, balance,
						historicalBalances, movements, savedAccounts, photo, gender);
			}
		} catch (SQLException e) {
			System.out.println("--> Error en la consulta de usuario");
			e.printStackTrace();
		}
		return client;
	}

	public static Client getClientByEmail(String email) {
		Client client = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from client where email = ?");
			preparedStatement.setString(1, email);
			preparedStatement.execute();
			ResultSet result = preparedStatement.getResultSet();
			if (result.next()) {
				Gson gson = new Gson();
				Type movementListType = new TypeToken<List<Movement>>() {
				}.getType();
				Type balancesListType = new TypeToken<List<BigDecimal>>() {
				}.getType();
				Type savedAccountsListType = new TypeToken<List<Account>>() {
				}.getType();
				Integer idClient = result.getInt("idclient");
				String name = result.getString("name");
				String surname = result.getString("surname");
				String lastname = result.getString("lastname");
				String phone = result.getString("phone");
				String curp = result.getString("curp");
				String street = result.getString("street");
				String number = result.getString("number");
				String suburb = result.getString("suburb");
				String townhall = result.getString("townhall");
				String state = result.getString("state");
				String country = result.getString("country");
				LocalDate birthday = result.getDate("birthday").toLocalDate();
				String gender = result.getString("gender");
				BigDecimal balance = result.getBigDecimal("balance");
				List<Movement> movements = gson.fromJson(result.getString("movements"), movementListType);
				if(movements == null) {
					movements = new ArrayList<Movement>();
				}
				List<BigDecimal> historicalBalances = gson.fromJson(result.getString("historicalBalances"),
						balancesListType);
				List<Account> savedAccounts = gson.fromJson(result.getString("savedAccounts"), savedAccountsListType);
				String photo = result.getString("photo");
				if (photo == null || photo == "") {
					if (gender.equals(Person.MALE_GENDER)) {
						photo = "img/profileMan.png";
					} else if (gender.equals(Person.FEMALE_GENDER)) {
						photo = "img/profileWoman.png";
					} else if (gender.equals(Person.OTHER_GENDER)) {
						photo = "img/profileNeutral.png";
					}
				}
				Contact contact = new Contact(phone, email);
				Direction direction = new Direction(street, number, suburb, townhall, state, country);
				client = new Client(name, surname, lastname, curp, contact, direction, birthday, idClient, balance,
						historicalBalances, movements, savedAccounts, photo, gender);
			}
		} catch (SQLException e) {
			System.out.println("--> Error en la consulta de usuario");
			e.printStackTrace();
		}
		return client;
	}

	public static Client getClientByPhone(String phone) {
		Client client = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from client where phone = ?");
			preparedStatement.setString(1, phone);
			preparedStatement.execute();
			ResultSet result = preparedStatement.getResultSet();
			if (result.next()) {
				Gson gson = new Gson();
				Type movementListType = new TypeToken<List<Movement>>() {
				}.getType();
				Type balancesListType = new TypeToken<List<BigDecimal>>() {
				}.getType();
				Type savedAccountsListType = new TypeToken<List<Account>>() {
				}.getType();
				Integer idClient = result.getInt("idclient");
				String name = result.getString("name");
				String surname = result.getString("surname");
				String lastname = result.getString("lastname");
				String curp = result.getString("curp");
				String email = result.getString("email");
				String street = result.getString("street");
				String number = result.getString("number");
				String suburb = result.getString("suburb");
				String townhall = result.getString("townhall");
				String state = result.getString("state");
				String country = result.getString("country");
				LocalDate birthday = result.getDate("birthday").toLocalDate();
				String gender = result.getString("gender");
				BigDecimal balance = result.getBigDecimal("balance");
				List<Movement> movements = gson.fromJson(result.getString("movements"), movementListType);
				if(movements == null) {
					movements = new ArrayList<Movement>();
				}
				List<BigDecimal> historicalBalances = gson.fromJson(result.getString("historicalBalances"),
						balancesListType);
				List<Account> savedAccounts = gson.fromJson(result.getString("savedAccounts"), savedAccountsListType);
				String photo = result.getString("photo");
				if (photo == null || photo == "") {
					if (gender.equals(Person.MALE_GENDER)) {
						photo = "img/profileMan.png";
					} else if (gender.equals(Person.FEMALE_GENDER)) {
						photo = "img/profileWoman.png";
					} else if (gender.equals(Person.OTHER_GENDER)) {
						photo = "img/profileNeutral.png";
					}
				}
				Contact contact = new Contact(phone, email);
				Direction direction = new Direction(street, number, suburb, townhall, state, country);
				client = new Client(name, surname, lastname, curp, contact, direction, birthday, idClient, balance,
						historicalBalances, movements, savedAccounts, photo, gender);
			}
		} catch (SQLException e) {
			System.out.println("--> Error en la consulta de usuario");
			e.printStackTrace();
		}
		return client;
	}

	public static Boolean addClient(Client client) {
		Gson gson = new Gson();
		boolean correct = false;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into client (name, surname, lastname, curp, phone, email, street, number, suburb, townhall, state, country, birthday, movements, balance, historicalbalances, photo, savedaccounts, gender) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, client.getName());
			preparedStatement.setString(2, client.getSurname());
			preparedStatement.setString(3, client.getLastname());
			preparedStatement.setString(4, client.getCurp());
			preparedStatement.setString(5, client.getContact().getPhone());
			preparedStatement.setString(6, client.getContact().getEmail());
			preparedStatement.setString(7, client.getDirection().getStreet());
			preparedStatement.setString(8, client.getDirection().getNumber());
			preparedStatement.setString(9, client.getDirection().getSuburb());
			preparedStatement.setString(10, client.getDirection().getTownhall());
			preparedStatement.setString(11, client.getDirection().getState());
			preparedStatement.setString(12, client.getDirection().getCountry());
			preparedStatement.setDate(13, java.sql.Date.valueOf(client.getBirthday()));
			preparedStatement.setString(14, gson.toJson(client.getMovements()));
			preparedStatement.setBigDecimal(15, client.getBalance());
			preparedStatement.setString(16, gson.toJson(client.getHistoricalBalances()));
			preparedStatement.setString(17, client.getPhoto());
			preparedStatement.setString(18, gson.toJson(client.getSavedAccounts()));
			preparedStatement.setString(19, client.getGender());
			Integer result = preparedStatement.executeUpdate();
			if (result > 0) {
				correct = true;
			}
		} catch (SQLException e) {
			System.out.println("Error al agregar registro");
			e.printStackTrace();
		}
		return correct;
	}

	public static Boolean editClient(Client client, Integer idClient) {
		Boolean correct = false;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update client set name = ?, surname = ?, lastname = ?, curp = ?, phone = ?, email = ?, street = ?, number = ?, suburb = ?, townhall = ?, state = ?, country = ?, birthday = ?, gender = ? where idclient = ?");
			preparedStatement.setString(1, client.getName());
			preparedStatement.setString(2, client.getSurname());
			preparedStatement.setString(3, client.getLastname());
			preparedStatement.setString(4, client.getCurp());
			preparedStatement.setString(5, client.getContact().getPhone());
			preparedStatement.setString(6, client.getContact().getEmail());
			preparedStatement.setString(7, client.getDirection().getStreet());
			preparedStatement.setString(8, client.getDirection().getNumber());
			preparedStatement.setString(9, client.getDirection().getSuburb());
			preparedStatement.setString(10, client.getDirection().getTownhall());
			preparedStatement.setString(11, client.getDirection().getState());
			preparedStatement.setString(12, client.getDirection().getCountry());
			preparedStatement.setDate(13, java.sql.Date.valueOf(client.getBirthday()));
			preparedStatement.setString(14, client.getGender());
			preparedStatement.setInt(15, idClient);
			Integer result = preparedStatement.executeUpdate();
			if (result > 0) {
				correct = true;
			}
		} catch (SQLException e) {
			System.out.println("Error al modificar registro");
			e.printStackTrace();
		}
		return correct;
	}

	public static Boolean editSavedAccounts(Integer idClient, List<Account> savedAccounts) {
		Boolean correct = false;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update client set savedaccounts = ? where idclient = ?");
			Gson gson = new Gson();
			preparedStatement.setString(1, gson.toJson(savedAccounts));
			preparedStatement.setInt(2, idClient);
			Integer result = preparedStatement.executeUpdate();
			if(result > 0) {
				correct = true;
			}
		} catch (SQLException e) {
			System.out.println("Error al modificar registro");
			e.printStackTrace();
		}
		return correct;
	}
	
	public static Boolean editMovements(Integer idClient, List<Movement> movements) {
		Boolean correct = false;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update client set movements = ? where idclient = ?");
			Gson gson = new Gson();
			preparedStatement.setString(1, gson.toJson(movements));
			preparedStatement.setInt(2, idClient);
			Integer result = preparedStatement.executeUpdate();
			if(result > 0) {
				correct = true;
			}
		} catch (SQLException e) {
			System.out.println("Error al modificar registro");
			e.printStackTrace();
		}
		return correct;
	}
	
	public static Boolean editBalance(Integer idClient, BigDecimal balance) {
		Boolean correct = false;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update client set balance = ? where idclient = ?");
			preparedStatement.setBigDecimal(1, balance);
			preparedStatement.setInt(2, idClient);
			Integer result = preparedStatement.executeUpdate();
			if(result > 0) {
				correct = true;
			}
		} catch (SQLException e) {
			System.out.println("Error al modificar registro");
			e.printStackTrace();
		}
		return correct;
	}
}
