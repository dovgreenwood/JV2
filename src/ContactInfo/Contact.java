package ContactInfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Student Name: Dov Greenwood
 * Date: 7/11/13
 * 
 * This serializable object contains the necessary information for a contact (full name, phone number,
 * email address).
 * */

public class Contact implements Serializable{
	
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	
	public Contact(String firstName, String lastName, String phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException {
		out.writeUTF(firstName);
		out.writeUTF(lastName);
		out.writeUTF(phoneNumber);
		out.writeUTF(email);
	}
	
	private void readObject(ObjectInputStream in) throws IOException {
		firstName = in.readUTF();
		lastName = in.readUTF();
		phoneNumber = in.readUTF();
		email = in.readUTF();
	}
	
	public String toString() {
		return firstName + " " + lastName + ": " + phoneNumber + ", " + email;
	}
	
}
