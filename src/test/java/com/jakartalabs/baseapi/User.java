package com.jakartalabs.baseapi;

public class User {
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private String phone_number;
	private String user_type;
	private String organization;
	
	public User() { }
	
	public User(String firstName, String lastName, String email, String password, String phoneNumber, String userType, String organization) {
		this.first_name = firstName;
		this.last_name = lastName;
		this.email = email;
		this.password = password;
		this.phone_number = phoneNumber;
		this.user_type = userType;
		this.organization = organization;
	}
	
	public void setName(String firstName, String lastName) {
		this.first_name = firstName;
		this.last_name = lastName;
	}
	
	public void setName(String name) {
		this.first_name = name;
		this.last_name = "";
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPhone(String phone) {
		this.phone_number = phone;
	}
	
	public void setUserType(String userType) {
		this.user_type = userType;
	}
	
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	@Override
	public String toString() {
		return "{\"user\":{\"first_name\":\""+ this.first_name +
				"\",\"last_name\":\""+ this.last_name +
				"\",\"email\":\""+ this.email +
				"\",\"password\":\""+ this.password +
				"\",\"phone_number\":\""+ this.phone_number +
				"\",\"user_type\":\""+ this.user_type +
				"\",\"organisation\":\""+ this.organization +"\"}}";
	}
}
