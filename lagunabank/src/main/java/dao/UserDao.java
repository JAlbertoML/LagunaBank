package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.User;

public class UserDao {
	public static User getUserByName(String username) {
		User user = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from \"user\" where username = ?");
			preparedStatement.setString(1, username);
			preparedStatement.execute();
			ResultSet result = preparedStatement.getResultSet();
			if(result.next()) {
				Integer idUser = result.getInt("iduser");
				String password = result.getString("password");
				Integer idClient = result.getInt("clienteidclient");
				user = new User(idUser, username, password, idClient);
			}
		} catch (SQLException e) {
			System.out.println("--> Error en la consulta de usuario");
			e.printStackTrace();
		}
		return user;
	}
	
	public static User getUserByClientId(Integer idClient) {
		User user = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from \"user\" where clienteidclient = ?");
			preparedStatement.setInt(1, idClient);
			preparedStatement.execute();
			ResultSet result = preparedStatement.getResultSet();
			if(result.next()) {
				String username = result.getString("username");
				Integer idUser = result.getInt("iduser");
				String password = result.getString("password");
				user = new User(idUser, username, password, idClient);
			}
		} catch (SQLException e) {
			System.out.println("--> Error en la consulta de usuario");
			e.printStackTrace();
		}
		return user;
	}
	
	public static Boolean addUser(User user) {
		Boolean correct = false;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("insert into \"user\" (username, password, clienteidclient) values (?, ?, ?)");
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getIdClient());
			Integer result = preparedStatement.executeUpdate();
			if(result > 0) {
				correct = true;
			}
		} catch (Exception e) {
			System.out.println("Error al agregar el usuario");
			e.printStackTrace();
		}
		return correct;
	}
	
	public static Boolean editUsername(String username, Integer idClient) {
		Boolean correct = false;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("update \"user\" set username = ? where clienteidclient = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setInt(2, idClient);
			Integer result = preparedStatement.executeUpdate();
			if(result > 0) {
				correct = true;
			}
		} catch (SQLException e) {
			System.out.println("error al modificar el usuario");
			e.printStackTrace();
		}
		return correct;
	}
	
	public static Boolean editPassword(String password, Integer idClient) {
		Boolean correct = false;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("update \"user\" set password = ? where clienteidclient = ?");
			preparedStatement.setString(1, password);
			preparedStatement.setInt(2, idClient);
			Integer result = preparedStatement.executeUpdate();
			if(result > 0) {
				correct = true;
			}
		} catch (SQLException e) {
			System.out.println("error al modificar el usuario");
			e.printStackTrace();
		}
		return correct;
	}
}
