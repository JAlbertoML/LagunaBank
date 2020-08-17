package bs;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pojos.Contact;
import pojos.Direction;
import pojos.Person;
import pojos.User;

public class RegisterBs {
	
	private static Boolean isAllRequiredFiled(Map<String, String[]> parameterMap) {
		Boolean correct = true;
		if (parameterMap.get("nameTxt")[0].equals("")) {
			correct = false;
		} else if (parameterMap.get("surnameTxt")[0].equals("")) {
			correct = false;
		} else if (parameterMap.get("lastnameTxt")[0].equals("")) {
			correct = false;
		} else if (parameterMap.get("curpTxt")[0].equals("")) {
			correct = false;
		} else if (parameterMap.get("birthdayDate")[0].equals("")) {
			correct = false;
		} else if (parameterMap.get("genderTxt")[0].equals("")) {
			correct = false;
		} else if (parameterMap.get("usernameTxt")[0].equals("")) {
			correct = false;
		} else if (parameterMap.get("passwordTxt")[0].equals("")) {
			correct = false;
		} else if (parameterMap.get("repeatPasswordTxt")[0].equals("")) {
			correct = false;
		} else if (parameterMap.get("emailTxt")[0].equals("")) {
			correct = false;
		} else if (parameterMap.get("phoneTxt")[0].equals("")) {
			correct = false;
		} else if (parameterMap.get("streetTxt")[0].equals("")) {
			correct = false;
		} else if (parameterMap.get("numberTxt")[0].equals("")) {
			correct = false;
		} else if (parameterMap.get("suburbTxt")[0].equals("")) {
			correct = false;
		} else if (parameterMap.get("townhallTxt")[0].equals("")) {
			correct = false;
		} else if (parameterMap.get("stateTxt")[0].equals("")) {
			correct = false;
		} else if (parameterMap.get("countryTxt")[0].equals("")) {
			correct = false;
		}
		return correct;
	}

	public static Person getTmpPerson(Map<String, String[]> parameterMap) {
		Contact contact = new Contact(parameterMap.get("phoneTxt")[0], parameterMap.get("emailTxt")[0]);
		Direction direction = new Direction(parameterMap.get("streetTxt")[0], parameterMap.get("numberTxt")[0],
				parameterMap.get("suburbTxt")[0], parameterMap.get("townhallTxt")[0], parameterMap.get("stateTxt")[0],
				parameterMap.get("countryTxt")[0]);
		String[] dateParts = parameterMap.get("birthdayDate")[0].split("-");
		Date birthday;
		try {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, Integer.parseInt(dateParts[0]));
			cal.set(Calendar.MONTH, Integer.parseInt(dateParts[1]));
			cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateParts[2]));
			birthday = cal.getTime();
		} catch (NumberFormatException e) {
			birthday = null;
		}
		return new Person(parameterMap.get("nameTxt")[0], parameterMap.get("surnameTxt")[0],
				parameterMap.get("lastnameTxt")[0], parameterMap.get("curpTxt")[0], contact, direction, birthday,
				parameterMap.get("genderTxt")[0]);
	}

	private static Boolean passwordsMatch(String pass, String passRepeat) {
		Boolean match = false;
		if (pass.equals(passRepeat)) {
			match = true;
		}
		return match;
	}

	private static Boolean isCurpCorrect(String curp) {
		Boolean correct = false;
		Pattern pat = Pattern.compile("[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}"
				+ "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])" + "[HM]{1}"
				+ "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)"
				+ "[B-DF-HJ-NP-TV-Z]{3}" + "[0-9A-Z]{1}[0-9]{1}$");
		Matcher mat = pat.matcher(curp);
		if (mat.matches()) {
			correct = true;
		}
		return correct;
	}

	private static Boolean isEmailCorrect(String email) {
		Boolean correct = false;
		Pattern pat = Pattern.compile("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");
		Matcher mat = pat.matcher(email);
		if (mat.matches()) {
			correct = true;
		}
		return correct;
	}

	private static Boolean isPhoneCorrect(String phone) {
		Boolean correct = false;
		Pattern pat = Pattern.compile("^[2-9]{2}[0-9]{8}$");
		Matcher mat = pat.matcher(phone);
		if (mat.matches()) {
			correct = true;
		}
		return correct;
	}

	public static String getRegisterMessage(Map<String, String[]> parameterMap) {
		String message = null;
		if (isAllRequiredFiled(parameterMap)) {
			String curp = parameterMap.get("curpTxt")[0];
			if(isCurpCorrect(curp)) {
				String email = parameterMap.get("emailTxt")[0];
				if(isEmailCorrect(email)) {
					String phone = parameterMap.get("phoneTxt")[0];
					if(isPhoneCorrect(phone)) {
						String pass = parameterMap.get("passwordTxt")[0];
						String passRepeat = parameterMap.get("repeatPasswordTxt")[0];
						if (passwordsMatch(pass, passRepeat)) {
							if(pass.length() >= 8) {
								String username = parameterMap.get("usernameTxt")[0];
								User user = UserBs.getUserByName(username);
								if (user == null) {
									if(ClientBs.getClientByCurp(curp) == null) {
										if(ClientBs.getClientByEmail(email) == null) {
											if(ClientBs.getClientByPhone(phone) == null) {
												message = null;
											} else {
												message = "El teléfono que estás tratando de ingresar ya existe. Intenta con otra o inicia sesión";
											}
										} else {
											message = "El correo electrónico que estás tratando de ingresar ya existe. Intenta con otra o inicia sesión";
										}
									} else {
										message = "La CURP que estás tratando de ingresar ya existe. Intenta con otra o inicia sesión";
									}
								} else {
									message = "El usuario que estas tratando de ingresar ya existe. Intenta con otro o inicia sesión.";
								}
							} else {
								message = "La contraseña debe ser mayor a 8 caracteres";
							}
						} else {
							message = "Las constraseñas no coinciden. Vuelve a intentarlo.";
						}
					} else {
						message = "Ingresa un numero de teléfono valido.";
					}
				} else {
					message ="Ingresa un correo electrónico valido.";
				}
			} else {
				message = "Ingresa una CURP valida.";
			}
		} else {
			message = "Asegurate de llenar todos los campos de las secciones obligatorias.";
		}
		return message;
	}
}
