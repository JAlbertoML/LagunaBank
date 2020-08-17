package bs;

public class LoginBs {
	public static final Integer SESSION_ACTIVE = 0;
	public static final Integer SESSION_INACTIVE = 1;
	public static Boolean validateCredentials(String passwordInput, String passwordDB) {
		Boolean correct = false;
		if(CryptWithMD5.cryptWithMD5(passwordInput).equals(passwordDB)) {
			correct = true;
		}
		return correct;
	}
}
