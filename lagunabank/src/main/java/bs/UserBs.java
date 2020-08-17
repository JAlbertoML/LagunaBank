package bs;

import dao.UserDao;
import pojos.User;

public class UserBs {
	public static User getUserByName(String username) {
		return UserDao.getUserByName(username);
	}
	
	public static User getUserByClientId(Integer idClient) {
		return UserDao.getUserByClientId(idClient);
	}
	
	public static Boolean addUser(String username, String password, Integer idClient) {
		Boolean correct = false;
		User user = new User(username, CryptWithMD5.cryptWithMD5(password), idClient);
		if(UserDao.addUser(user)) {
			correct = true;
		}
		return correct;
	}
	
	public static Boolean editUsername(String username, Integer idClient) {
		return UserDao.editUsername(username, idClient);
	}
	
	public static Boolean editPassword(String password, Integer idClient) {
		return UserDao.editPassword(CryptWithMD5.cryptWithMD5(password), idClient);
	}
}
