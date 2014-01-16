package ContactInfo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * Student Name: Dov Greenwood
 * Date: 7/11/13
 * 
 * This program allows the reading, writing, and deleting of contacts to a file.  Upon launching,
 * it prompts for the name of a file to read/write to, and then gives four options:
 * a) display all contacts
 * b) delete a contact
 * c) add a contact
 * d) exit
 * 
 * Displaying the contacts simply reads the TreeMap of contacts from the file, and
 * loops through them, printing the information as it does so.
 * 
 * Deleting a contact prompts the user for a key (slightly different from the last name),
 * and then uses the TreeMap.remove(key) method to remove that contact, and then writes the
 * contacts back to the file.
 * 
 * Adding contact first reads the TreeMap of contacts from the file, then appends the new contact
 * to the contact list (first changing the key just in case another contact has the same last name),
 * and lastly writes the TreeMap back to the file.
 * */

public class GetContactsInformation {
	
	public static void main(String [] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean loopCondition = true;
		
		System.out.print("File name please: ");
		String fileName = keyboard.nextLine();
		
		while(loopCondition) {
			TreeMap<String, Contact> contactList = readContacts(fileName);
			System.out.println("Would you like to:\n" + 
								"a) display all contacts\n" +
								"b) delete a contact\n" +
								"c) add a contact\n" +
								"d) exit");
			String choice = keyboard.nextLine();
			switch(choice) {
				case "a":
					System.out.println("\n");
					for(Map.Entry contact : contactList.entrySet()) {
						System.out.println(contact.getKey() + " - " + contact.getValue() + "\n");
					}
					break;
				case "b":
					deleteContact(fileName, keyboard, contactList);
					break;
				case "c":
					addContact(fileName, keyboard, contactList);
					break;
				case "d":
					loopCondition = false;
					break;
				default:
					System.out.println("Error: unidentifiable input. '" + choice + "' Returning to main menu...");
					break;
			}
		}
	}

	private static void addContact(String fileName, Scanner keyboard, TreeMap<String, Contact> contactList) {

		System.out.print("First name: ");
		String firstName = keyboard.nextLine();
		System.out.print("Last name: ");
		String lastName = keyboard.nextLine();
		System.out.print("Phone number: ");
		String phoneNumber = keyboard.nextLine();
		System.out.print("Email address: ");
		String email = keyboard.nextLine();
		
		
		contactList.put(lastName + ":" + firstName, new Contact(firstName, lastName, phoneNumber, email));

		
		try {
			ObjectOutputStream out = new ObjectOutputStream(
										new BufferedOutputStream(
										new FileOutputStream(fileName)));
			out.writeObject(contactList);
			out.flush();
			out.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	private static void deleteContact(String fileName, Scanner keyboard, TreeMap<String, Contact> contactList) {
		
		System.out.print("Key of contact to remove: ");
		String name = keyboard.nextLine();
		contactList.remove(name);
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(
										new BufferedOutputStream(
										new FileOutputStream(fileName)));
			out.writeObject(contactList);
			out.flush();
			out.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	private static TreeMap<String, Contact> readContacts(String fileName) {
		TreeMap<String, Contact> rVal = new TreeMap<String, Contact>();
		try {
			ObjectInputStream in = new ObjectInputStream(
									new BufferedInputStream(
									new FileInputStream(fileName)));
			rVal = (TreeMap<String, Contact>) in.readObject();
			in.close();
		}
		catch (Exception e) {
		}
		return rVal;
	}
	
}
