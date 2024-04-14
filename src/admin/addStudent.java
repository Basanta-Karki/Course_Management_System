package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.databaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class addStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField number;
	//private JTextField id;
	 private JComboBox<String> courseComboBox;
	 private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addStudent frame = new addStudent();
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
	public addStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(118, 179, 136, 26);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBackground(Color.LIGHT_GRAY);
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setBounds(314, 146, 225, 33);
		contentPane.add(name);
		name.setColumns(10);
		name.setBorder(null);
		
		JLabel lblNoOfYears = new JLabel("Email");
		lblNoOfYears.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNoOfYears.setBounds(123, 261, 131, 26);
		contentPane.add(lblNoOfYears);
		
		JLabel lblBatch = new JLabel("Phone number");
		lblBatch.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBatch.setBounds(123, 420, 133, 26);
		contentPane.add(lblBatch);
		
		JLabel courseLabel = new JLabel("Select Course:");
        String[] courses = {"BIT", "BIBM", "MBA"};
        courseComboBox = new JComboBox<>(courses);
        courseComboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        courseComboBox.setBounds(314, 489, 230, 30);
        contentPane.add(courseComboBox);
		
		JLabel lblSeats = new JLabel("Selected Course");
		lblSeats.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSeats.setBounds(123, 493, 136, 26);
		contentPane.add(lblSeats);
		
		email = new JTextField();
		email.setBackground(Color.LIGHT_GRAY);
		email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		email.setColumns(10);
		email.setBounds(314, 227, 225, 33);
		contentPane.add(email);
		email.setBorder(null);
		
		number = new JTextField();
		number.setBackground(Color.LIGHT_GRAY);
		number.setFont(new Font("Tahoma", Font.PLAIN, 14));
		number.setColumns(10);
		number.setBounds(314, 389, 225, 33);
		contentPane.add(number);
		number.setBorder(null);
		
//		course = new JTextField();
//		course.setBackground(Color.LIGHT_GRAY);
//		course.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		course.setColumns(10);
//		course.setBounds(314, 472, 225, 33);
//		contentPane.add(course);
//		course.setBorder(null);
		
		JButton btnNewButton = new JButton("Add Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentName = name.getText();
				String Email=email.getText();
				String phone_number= number.getText();
				String selectedCourse=(String) courseComboBox.getSelectedItem();
				String pass=passwordField.getText();
				String student_id="o";
				
				// Display an error message to the user if any field is empty
				if (studentName.isEmpty() ||pass.isEmpty() || Email.isEmpty() || phone_number.isEmpty() || selectedCourse.isEmpty() || student_id.isEmpty()) {
				    JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}
				
				if (phone_number.isEmpty() || phone_number.length() != 10 || !phone_number.startsWith("98")) {
				    JOptionPane.showMessageDialog(null, "Please enter a valid phone number starting with 98 and having 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}
		
				// Create a HashMap to store the course data
                HashMap<String, String> studentData = new HashMap<>();
                studentData.put("name", studentName);
                studentData.put("email", Email);
                studentData.put("number", phone_number);
                studentData.put("course", selectedCourse);
                studentData.put("password", pass);
                studentData.put("id", student_id);
                
                
                
             // Call a method to send the data to the backend and add the course
                boolean success = addStudentToBackend(studentData);

                // Display a success or error message based on the result
                if (success) {
                	 ((JFrame) SwingUtilities.getRoot((Component) e.getSource())).dispose();
                    System.out.println("Student added successfully");
                    // Optionally, you can close the addStudent frame or reset the form
                } else {
                    System.err.println("Failed to add the student");
                }
			}
			// Method to send course data to the backend
			private boolean addStudentToBackend(HashMap<String, String> studentData) {
			    

			    try (Connection connection = databaseConnection.getConnection()) {
			        String query = "INSERT INTO userinfo (username, email, phoneNumber, password, selectedCourse, mode) VALUES (?,?, ?, ?, ?,?)";
			        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			        	//preparedStatement.setString(1, studentData.get("id"));
			            preparedStatement.setString(1, studentData.get("name")); 
			            preparedStatement.setString(2, studentData.get("email"));
			            preparedStatement.setString(3, studentData.get("number"));
			            preparedStatement.setString(4, studentData.get("password"));
			            preparedStatement.setString(5, studentData.get("selectedCourse"));
			            preparedStatement.setString(6, "Student");
			            
			            

			            int rowsAffected = preparedStatement.executeUpdate();

			            return rowsAffected > 0;
			        }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			        return false;
			    }
			}

		});
		
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(265, 601, 202, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Add Student");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(265, 52, 178, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setBounds(123, 340, 133, 26);
		contentPane.add(lblPassword);
		
//		JLabel lblId = new JLabel("Id");
//		lblId.setFont(new Font("Times New Roman", Font.BOLD, 20));
//		lblId.setBounds(154, 90, 69, 26);
//		contentPane.add(lblId);
		
//		id = new JTextField();
//		id.setBackground(Color.LIGHT_GRAY);
//		id.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		id.setColumns(10);
//		id.setBounds(314, 75, 225, 33);
//		contentPane.add(id);
//		id.setBorder(null);
		
//		JLabel lblNewLabel_2 = new JLabel("_______________________");
//		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
//		lblNewLabel_2.setBounds(314, 493, 250, 26);
//		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("_______________________");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(314, 408, 250, 26);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("_______________________");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(314, 328, 250, 26);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("_______________________");
		lblNewLabel_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1_1_1.setBounds(314, 246, 250, 26);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("_______________________");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1_1_1_1.setBounds(314, 166, 250, 26);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
//		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("_______________________");
//		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
//		lblNewLabel_2_1_1_1_1_1.setBounds(314, 90, 250, 26);
//		contentPane.add(lblNewLabel_2_1_1_1_1_1);
        
        passwordField = new JPasswordField();
        passwordField.setBackground(Color.LIGHT_GRAY);
        passwordField.setBounds(314, 298, 230, 40);
        contentPane.add(passwordField);
        passwordField.setBorder(null);
	}
}
