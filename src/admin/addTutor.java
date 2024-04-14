package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class addTutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField num;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addTutor frame = new addTutor();
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
	public addTutor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 765);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tutor Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(129, 211, 114, 26);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBackground(Color.LIGHT_GRAY);
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setBounds(265, 193, 225, 33);
		contentPane.add(name);
		name.setColumns(10);
		name.setBorder(null);
		
		JLabel lblNoOfYears = new JLabel("Email");
		lblNoOfYears.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNoOfYears.setBounds(160, 312, 67, 26);
		contentPane.add(lblNoOfYears);
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblphone.setBounds(160, 407, 75, 26);
		contentPane.add(lblphone);
		
		JLabel date = new JLabel("Password");
		date.setFont(new Font("Times New Roman", Font.BOLD, 20));
		date.setBounds(129, 495, 114, 26);
		contentPane.add(date);
		
		email = new JTextField();
		email.setBackground(Color.LIGHT_GRAY);
		email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		email.setColumns(10);
		email.setBounds(265, 293, 225, 33);
		contentPane.add(email);
		email.setBorder(null);
		
		num = new JTextField();
		num.setBackground(Color.LIGHT_GRAY);
		num.setFont(new Font("Tahoma", Font.PLAIN, 14));
		num.setColumns(10);
		num.setBounds(265, 387, 225, 33);
		contentPane.add(num);
		num.setBorder(null);
		
		JLabel courseLabel = new JLabel("Select Course:");
        String[] courses = {"BIT", "BIBM", "MBA"};
        JComboBox<String> courseComboBox = new JComboBox<>(courses);
        courseComboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        courseComboBox.setBounds(270, 564, 211, 25);
        contentPane.add(courseLabel);
        contentPane.add(courseComboBox);
        
        JLabel lblNewLabel_3 = new JLabel("Select Course");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_3.setBounds(119, 566, 141, 21);
        contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Add Tutor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tutorName = name.getText();
				String Email=email.getText();
				String phone= num.getText();
				String Password=passwordField.getText();
				String selectedCourse = (String) courseComboBox.getSelectedItem();
				String tutor_id="o";
				
				// Display an error message to the user if any field is empty
				if (tutorName.isEmpty() || Email.isEmpty() || phone.isEmpty() || Password.isEmpty() || tutor_id.isEmpty()) {
				    JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}
				
				if (phone.isEmpty() || phone.length() != 10 || !phone.startsWith("98")) {
				    JOptionPane.showMessageDialog(null, "Please enter a valid phone number starting with 98 and having 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}
		
				// Create a HashMap to store the course data
                HashMap<String, String> tutorData = new HashMap<>();
                tutorData.put("name", tutorName);
                tutorData.put("Email", Email);
                tutorData.put("phone", phone);
                tutorData.put("password", Password);
                tutorData.put("id", tutor_id);
                tutorData.put("selectedCourse", selectedCourse);
                
             // Call a method to send the data to the backend and add the course
                boolean success = addTutorToBackend(tutorData);

                // Display a success or error message based on the result
                if (success) {
                	 ((JFrame) SwingUtilities.getRoot((Component) e.getSource())).dispose();
                    System.out.println("tuor added successfully");
                    // Optionally, you can close the addTutor frame or reset the form
                } else {
                    System.err.println("Failed to add the tutor");
                }
			}
			
			
			// Method to send course data to the backend
			private boolean addTutorToBackend(HashMap<String, String> tutorData) {
			    final String DB_URL = "jdbc:mysql://localhost:3307/student";
			    final String USERNAME = "root";
			    final String PASSWORD = "";

			    try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
			        String query = "INSERT INTO userinfo (username, email, phoneNumber, password, selectedCourse, mode) VALUES (?,?, ?, ?, ?, ?)";
			        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			     
			            preparedStatement.setString(1, tutorData.get("name")); 
			            preparedStatement.setString(2, tutorData.get("Email"));
			            preparedStatement.setString(3, tutorData.get("phone"));
			            preparedStatement.setString(4, tutorData.get("password"));
			            preparedStatement.setString(5, tutorData.get("selectedCourse"));
			            preparedStatement.setString(6, "Tutor");

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
		btnNewButton.setBounds(250, 641, 161, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Add Tutor");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(250, 81, 161, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("______________________");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(265, 497, 234, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("______________________");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(265, 407, 234, 26);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("______________________");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(265, 312, 234, 26);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("______________________");
		lblNewLabel_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1_1_1.setBounds(265, 211, 234, 26);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setBounds(265, 476, 225, 33);
		contentPane.add(passwordField);
		passwordField.setBorder(null);
		
		
	}
}
