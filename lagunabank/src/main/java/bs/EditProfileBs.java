package bs;

import java.time.LocalDate;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pojos.Client;
import pojos.Contact;
import pojos.Direction;

public class EditProfileBs {
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

	public static Client getTmpClient(Map<String, String[]> parameterMap) {
		Contact contact = new Contact(parameterMap.get("phoneTxt")[0], parameterMap.get("emailTxt")[0]);
		Direction direction = new Direction(parameterMap.get("streetTxt")[0], parameterMap.get("numberTxt")[0],
				parameterMap.get("suburbTxt")[0], parameterMap.get("townhallTxt")[0], parameterMap.get("stateTxt")[0],
				parameterMap.get("countryTxt")[0]);
		String[] dateParts = parameterMap.get("birthdayDate")[0].split("-");
		LocalDate birthday = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
		return new Client(parameterMap.get("nameTxt")[0], parameterMap.get("surnameTxt")[0],
				parameterMap.get("lastnameTxt")[0], parameterMap.get("curpTxt")[0], contact, direction, birthday, parameterMap.get("genderTxt")[0]);
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

	private static Boolean passwordsMatch(String pass, String passRepeat) {
		Boolean match = false;
		if (pass.equals(passRepeat)) {
			match = true;
		}
		return match;
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

	private static Boolean isCurpAvailable(String curp, String actualCurp) {
		Boolean available = false;
		if (curp.equals(actualCurp)) {
			available = true;
		} else if (ClientBs.getClientByCurp(curp) == null) {
			available = true;
		}
		return available;
	}

	private static Boolean isPhoneAvailable(String phone, String actualPhone) {
		Boolean available = false;
		if (phone.equals(actualPhone)) {
			available = true;
		} else if (ClientBs.getClientByCurp(phone) == null) {
			available = true;
		}
		return available;
	}

	private static Boolean isEmailAvailable(String email, String actualEmail) {
		Boolean available = false;
		if (email.equals(actualEmail)) {
			available = true;
		} else if (ClientBs.getClientByCurp(email) == null) {
			available = true;
		}
		return available;
	}

	public static String getEditProfileMessage(Map<String, String[]> parameterMap, Client actualClient) {
		String message = null;
		if (isAllRequiredFiled(parameterMap)) {
			String curp = parameterMap.get("curpTxt")[0];
			if (isCurpCorrect(curp)) {
				String email = parameterMap.get("emailTxt")[0];
				if (isEmailCorrect(email)) {
					String phone = parameterMap.get("phoneTxt")[0];
					if (isPhoneCorrect(phone)) {
						if (isCurpAvailable(curp, actualClient.getCurp())) {
							if (isEmailAvailable(email, actualClient.getContact().getEmail())) {
								if (isPhoneAvailable(phone, actualClient.getContact().getPhone())) {
									String pass = parameterMap.get("newPasswordTxt")[0];
									String repeatedPass = parameterMap.get("repeatPasswordTxt")[0];
									if (!pass.equals("") || !repeatedPass.equals("")) {
										if (pass.length() >= 8) {
											if (passwordsMatch(pass, repeatedPass)) {
												message = "0";
											} else {
												message = "Las contraseñas no coinciden";
											}
										} else {
											message = "La contraseña debe tener, al menos, 8 caracteres.";
										}
									} else {
										message = null;
									}
								} else {
									message = "El teléfono que estás tratando de ingresar ya existe. Intenta de nuevo.";
								}
							} else {
								message = "El correo electrónico que estás tratando de ingresar ya está registrado. Intenta de nuevo.";
							}
						} else {
							message = "La CURP que estás tratando de ingresar ya existe. Intenta de nuevo.";
						}
					} else {
						message = "Ingresa un numero de teléfono valido.";
					}
				} else {
					message = "Ingresa un correo electrónico valido.";
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