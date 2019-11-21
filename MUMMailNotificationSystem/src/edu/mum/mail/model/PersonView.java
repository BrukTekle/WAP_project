package edu.mum.mail.model;

public class PersonView {
	private int personId;
	private String lastName;
	private String firstName;
	private String email;
	private String tel;
	private String boxNumber;
	private String type;
	
	public PersonView(int personId, String lastName, String firstName, String email, String tel, String boxNumber,
			String type) {
		this.personId = personId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.tel = tel;
		this.boxNumber = boxNumber;
		this.type = type;
	}
	
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBoxNumber() {
		return boxNumber;
	}
	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
