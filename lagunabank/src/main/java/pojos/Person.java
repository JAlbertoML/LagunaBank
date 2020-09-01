package pojos;

import java.time.LocalDate;

public class Person {
	public static final String MALE_GENDER = "Masculino";
	public static final String FEMALE_GENDER = "Femenino";
	public static final String OTHER_GENDER = "Otro";	
	
	private String name;
	private String surname;
	private String lastname;
	private String curp;
	private Contact contact;
	private Direction direction;
	private LocalDate birthday;
	private String gender;
	
	public Person(String name, String surname, String lastname, String curp, Contact contact, Direction direction,
			LocalDate birthday, String gender) {
		super();
		this.name = name;
		this.surname = surname;
		this.lastname = lastname;
		this.curp = curp;
		this.contact = contact;
		this.direction = direction;
		this.birthday = birthday;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
