/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package project.crudsystem;

/**
 *
 * @author Student.Admin
 */


// Java User Management System with MongoDB

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.net.UnknownHostException;

public class CRUDSystem {

	// JFrame for GUI
	private JFrame frame;
	
	// Labels for first name, last name, middle name, date of birth, age, gender, phone, email, and address
	private JLabel firstName;
	private JLabel lastName;
	private JLabel middleName;
	private JLabel dateOfBirth;
	private JLabel age;
	private JLabel gender;
	private JLabel phone;
	private JLabel email;
	private JLabel address;
	
	// TextFields for each user information
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField middleNameField;
	private JTextField dateOfBirthField;
	private JTextField ageField;
	private JTextField genderField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField addressField;
	
	// Buttons for CRUD operations
	private JButton create;
	private JButton read;
	private JButton update;
	private JButton delete;
	
	// MongoDB connection
	private MongoCollection<org.bson.Document> collection;
 
	public static void main(String[] args) throws UnknownHostException {
		CRUDSystem userManagement = new CRUDSystem();
		userManagement.initGUI();
		userManagement.initMongoDB();
	}
	
	public void initGUI() {
		// Initializing JFrame 
		frame = new JFrame("User Management System");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(9, 2));
		
		// Initializing labels 
		firstName = new JLabel("First Name");
		lastName = new JLabel("Last Name");
		middleName = new JLabel("Middle Name");
		dateOfBirth = new JLabel("Date of Birth");
		age = new JLabel("Age");
		gender = new JLabel("Gender");
		phone = new JLabel("Phone");
		email = new JLabel("Email");
		address = new JLabel("Address");
		
		// Initializing JTextFields
		firstNameField = new JTextField(20);
		lastNameField = new JTextField(20);
		middleNameField = new JTextField(20);
		dateOfBirthField = new JTextField(20);
		ageField = new JTextField(20);
		genderField = new JTextField(20);
		phoneField = new JTextField(20);
		emailField = new JTextField(20);
		addressField = new JTextField(20);
		
		// Initializing Buttons
		create = new JButton("Create");
		read = new JButton("Read");
		update = new JButton("Update");
		delete = new JButton("Delete");
		
		// Adding labels and text fields to Frame
		frame.getContentPane().add(firstName);
		frame.getContentPane().add(firstNameField);
		frame.getContentPane().add(lastName);
		frame.getContentPane().add(lastNameField);
		frame.getContentPane().add(middleName);
		frame.getContentPane().add(middleNameField);
		frame.getContentPane().add(dateOfBirth);
		frame.getContentPane().add(dateOfBirthField);
		frame.getContentPane().add(age);
		frame.getContentPane().add(ageField);
		frame.getContentPane().add(gender);
		frame.getContentPane().add(genderField);
		frame.getContentPane().add(phone);
		frame.getContentPane().add(phoneField);
		frame.getContentPane().add(email);
		frame.getContentPane().add(emailField);
		frame.getContentPane().add(address);
		frame.getContentPane().add(addressField);
		
		// Adding Buttons to Frame
		frame.getContentPane().add(create);
		frame.getContentPane().add(read);
		frame.getContentPane().add(update);
		frame.getContentPane().add(delete);
		
		// Setting the visibility of the frame
		frame.setVisible(true);
		
		// Adding action listeners to the buttons
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to create user
				createUser();
			}
		});
		
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to read user
				readUser();
			}
		});
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to update user
				updateUser();
			}
		});
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code to delete user
				deleteUser();
			}
		});
	}
	
	public void initMongoDB() throws UnknownHostException {
		// Connecting to MongoDB
                com.mongodb.client.MongoClient client = MongoClients.create("mongodb+srv://Aron:3l3v3n308@cluster0.tzc415o.mongodb.net/?retryWrites=true&w=majority");
               MongoDatabase db= client.getDatabase("UserManagement");
		//client = new MongoClient();
		//db = client.getDatabase("userDb");
		collection = db.getCollection("Users");
	}
	
	public void createUser() {
		// Creating a user
		org.bson.Document user = new org.bson.Document("firstName", firstNameField.getText())
				.append("lastName", lastNameField.getText())
				.append("middleName", middleNameField.getText())
				.append("dateOfBirth", dateOfBirthField.getText())
				.append("age", ageField.getText())
				.append("gender", genderField.getText())
				.append("phone", phoneField.getText())
				.append("email", emailField.getText())
				.append("address", addressField.getText());
		collection.insertOne(user);
	}
	
	public void readUser() {
		// Reading a user
		MongoCursor<org.bson.Document> cursor = collection.find().iterator();
		try {
			while (cursor.hasNext()) {
				org.bson.Document user = cursor.next();
				System.out.println(user.toJson());
			}
		} finally {
			cursor.close();
		}
	}
	
	public void updateUser() {
		// Updating a user
		org.bson.Document user = new org.bson.Document("firstName", firstNameField.getText())
				.append("lastName", lastNameField.getText())
				.append("middleName", middleNameField.getText())
				.append("dateOfBirth", dateOfBirthField.getText())
				.append("age", ageField.getText())
				.append("gender", genderField.getText())
				.append("phone", phoneField.getText())
				.append("email", emailField.getText())
				.append("address", addressField.getText());
		collection.findOneAndReplace(user, user);
	}
	
	public void deleteUser() {
		// Deleting a user
		org.bson.Document user = new org.bson.Document("firstName", firstNameField.getText())
				.append("lastName", lastNameField.getText())
				.append("middleName", middleNameField.getText())
				.append("dateOfBirth", dateOfBirthField.getText())
				.append("age", ageField.getText())
				.append("gender", genderField.getText())
				.append("phone", phoneField.getText())
				.append("email", emailField.getText())
				.append("address", addressField.getText());
		collection.deleteOne(user);
	}

}