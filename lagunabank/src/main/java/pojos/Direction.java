package pojos;

public class Direction {
	private String street;
	private String number;
	private String suburb;
	private String townhall;
	private String state;
	private String country;
	
	public Direction(String street, String number, String suburb, String townhall, String state, String country) {
		super();
		this.street = street;
		this.number = number;
		this.suburb = suburb;
		this.townhall = townhall;
		this.state = state;
		this.country = country;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSuburb() {
		return suburb;
	}
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	public String getTownhall() {
		return townhall;
	}
	public void setTownhall(String townhall) {
		this.townhall = townhall;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
