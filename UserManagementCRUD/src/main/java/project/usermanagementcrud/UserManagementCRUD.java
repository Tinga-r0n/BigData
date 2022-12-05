/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package project.usermanagementcrud;

/**
 *
 * @author Student.Admin
 */


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import com.mongodb.client.model.Updates;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserManagementCRUD extends JFrame {

	private JPanel contentPane;
	private JTextField firstNameTxt;
	private JTextField lastNameTxt;
	private JTextField middleNameTxt;
	private JTextField dateOfBirthTxt;
	private JTextField ageTxt;
	private JTextField genderTxt;
	private JTextField phoneTxt;
	private JTextField emailTxt;
	private JTextField addressTxt;
	private MongoClient client;
	private MongoCollection<Document> collection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagementCRUD frame = new UserManagementCRUD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserManagementCRUD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(51, 36, 64, 14);
		contentPane.add(lblNewLabel);
		
		firstNameTxt = new JTextField();
		firstNameTxt.setBounds(125, 33, 86, 20);
		contentPane.add(firstNameTxt);
		firstNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(51, 61, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		lastNameTxt = new JTextField();
		lastNameTxt.setBounds(125, 58, 86, 20);
		contentPane.add(lastNameTxt);
		lastNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Middle Name");
		lblNewLabel_2.setBounds(51, 86, 64, 14);
		contentPane.add(lblNewLabel_2);
		
		middleNameTxt = new JTextField();
		middleNameTxt.setBounds(125, 83, 86, 20);
		contentPane.add(middleNameTxt);
		middleNameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Date Of Birth");
		lblNewLabel_3.setBounds(51, 111, 64, 14);
		contentPane.add(lblNewLabel_3);
		
		dateOfBirthTxt = new JTextField();
		dateOfBirthTxt.setBounds(125, 108, 86, 20);
		contentPane.add(dateOfBirthTxt);
		dateOfBirthTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Age");
		lblNewLabel_4.setBounds(51, 136, 64, 14);
		contentPane.add(lblNewLabel_4);
		
		ageTxt = new JTextField();
		ageTxt.setBounds(125, 133, 86, 20);
		contentPane.add(ageTxt);
		ageTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setBounds(51, 161, 64, 14);
		contentPane.add(lblNewLabel_5);
		
		genderTxt = new JTextField();
		genderTxt.setBounds(125, 158, 86, 20);
		contentPane.add(genderTxt);
		genderTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Phone");
		lblNewLabel_6.setBounds(51, 186, 64, 14);
		contentPane.add(lblNewLabel_6);
		
		phoneTxt = new JTextField();
		phoneTxt.setBounds(125, 183, 86, 20);
		contentPane.add(phoneTxt);
		phoneTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setBounds(51, 211, 64, 14);
		contentPane.add(lblNewLabel_7);
		
		emailTxt = new JTextField();
		emailTxt.setBounds(125, 208, 86, 20);
		contentPane.add(emailTxt);
		emailTxt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Address");
		lblNewLabel_8.setBounds(51, 236, 64, 14);
		contentPane.add(lblNewLabel_8);
		
		addressTxt = new JTextField();
		addressTxt.setBounds(125, 233, 86, 20);
		contentPane.add(addressTxt);
		addressTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            try {
                                connectToMongoDB();
                            } catch (UnknownHostException ex) {
                                Logger.getLogger(UserManagementCRUD.class.getName()).log(Level.SEVERE, null, ex);
                            }
				
				String firstName = firstNameTxt.getText();
				String lastName = lastNameTxt.getText();
				String middleName = middleNameTxt.getText();
				String dateOfBirth = dateOfBirthTxt.getText();
				String age = ageTxt.getText();
				String gender = genderTxt.getText();
				String phone = phoneTxt.getText();
				String email = emailTxt.getText();
				String address = addressTxt.getText();
				
				Document user = new Document("firstName", firstName)
						.append("lastName", lastName)
						.append("middleName", middleName)
						.append("dateOfBirth", dateOfBirth)
						.append("age", age)
						.append("gender", gender)
						.append("phone", phone)
						.append("email", email)
						.append("address", address);
				
				collection.insertOne(user);
				JOptionPane.showMessageDialog(null, "User successfully registered!");
			}
		});
		btnNewButton.setBounds(265, 32, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try {
                                connectToMongoDB();
                            } catch (UnknownHostException ex) {
                                Logger.getLogger(UserManagementCRUD.class.getName()).log(Level.SEVERE, null, ex);
                            }
				
				String firstName = firstNameTxt.getText();
				String lastName = lastNameTxt.getText();
				String middleName = middleNameTxt.getText();
				String dateOfBirth = dateOfBirthTxt.getText();
				String age = ageTxt.getText();
				String gender = genderTxt.getText();
				String phone = phoneTxt.getText();
				String email = emailTxt.getText();
				String address = addressTxt.getText();
				
				Document searchQuery = new Document("firstName", firstName);
				
				Document update = new Document("$set", 
							new Document("firstName", firstName)
                                                        .append("lastName",lastName)
							.append("middleName", middleName)
							.append("dateOfBirth", dateOfBirth)
							.append("age", age)
							.append("gender", gender)
							.append("phone", phone)
							.append("email", email)
							.append("address", address));
				
				collection.updateOne(searchQuery, update);
				JOptionPane.showMessageDialog(null, "User successfully updated!");
			}
		});
		btnNewButton_1.setBounds(265, 57, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try {
                                connectToMongoDB();
                            } catch (UnknownHostException ex) {
                                Logger.getLogger(UserManagementCRUD.class.getName()).log(Level.SEVERE, null, ex);
                            }
				
				String firstName = firstNameTxt.getText();
				
				Document searchQuery = new Document("firstName", firstName);
				
				collection.deleteOne(searchQuery);
				JOptionPane.showMessageDialog(null, "User successfully deleted!");
			}
		});
		btnNewButton_2.setBounds(265, 82, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Read");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try {
                                connectToMongoDB();
                            } catch (UnknownHostException ex) {
                                Logger.getLogger(UserManagementCRUD.class.getName()).log(Level.SEVERE, null, ex);
                            }
				
				String firstName = firstNameTxt.getText();
				
				Document searchQuery = new Document("firstName", firstName);
				
				Document user = collection.find(searchQuery).first();
				
				// Set values in text fields
				lastNameTxt.setText(user.getString("lastName"));
				middleNameTxt.setText(user.getString("middleName"));
				dateOfBirthTxt.setText(user.getString("dateOfBirth"));
				ageTxt.setText(user.getString("age"));
				genderTxt.setText(user.getString("gender"));
				phoneTxt.setText(user.getString("phone"));
				emailTxt.setText(user.getString("email"));
				addressTxt.setText(user.getString("address"));
			}
		});
		btnNewButton_3.setBounds(265, 107, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Log in");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = JOptionPane.showInputDialog("Enter username:");
				String password = JOptionPane.showInputDialog("Enter password:");
				
				// Authenticate user
				if (username.equals("admin") && password.equals("password")) {
					JOptionPane.showMessageDialog(null, "Welcome admin!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid username or password!");
				}
			}
		});
		btnNewButton_4.setBounds(265, 208, 89, 23);
		contentPane.add(btnNewButton_4);
	}
	
	public void connectToMongoDB() throws UnknownHostException {
		//String uri = "mongodb://localhost:27017";
		//client = new MongoClient(new MongoClientURI(uri));
		//MongoDatabase db = client.getDatabase("users");
		//collection = db.getCollection("users");
                com.mongodb.client.MongoClient client = MongoClients.create("mongodb+srv://Aron:3l3v3n308@cluster0.tzc415o.mongodb.net/?retryWrites=true&w=majority");
               MongoDatabase db= client.getDatabase("UserManagement");
		
		// Creating the collection
		 collection = db.getCollection("Users");
	}
}