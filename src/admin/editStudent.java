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
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class editStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField number;
	private JTextField pass;
	private JLabel idpanel;
	private JTextField idfield;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editStudent frame = new editStudent();
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
	public editStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel studentNamepanel = new JLabel("Student Name");
		studentNamepanel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		studentNamepanel.setBounds(103, 192, 136, 26);
		contentPane.add(studentNamepanel);
		
		name = new JTextField();
		name.setBackground(Color.LIGHT_GRAY);
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setBounds(265, 167, 225, 38);
		contentPane.add(name);
		name.setColumns(10);
		name.setBorder(null);
		
		JLabel yearspanel = new JLabel("Email");
		yearspanel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		yearspanel.setBounds(141, 282, 81, 26);
		contentPane.add(yearspanel);
		
		JLabel phonenumberpanel = new JLabel("Phone Number");
		phonenumberpanel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		phonenumberpanel.setBounds(91, 365, 131, 26);
		contentPane.add(phonenumberpanel);
		
		JLabel Passwordpanel = new JLabel("Password");
		Passwordpanel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Passwordpanel.setBounds(125, 453, 97, 26);
		contentPane.add(Passwordpanel);
		
		email = new JTextField();
		email.setBackground(Color.LIGHT_GRAY);
		email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		email.setColumns(10);
		email.setBounds(265, 264, 225, 33);
		contentPane.add(email);
		email.setBorder(null);
		
		number = new JTextField();
		number.setBackground(Color.LIGHT_GRAY);
		number.setFont(new Font("Tahoma", Font.PLAIN, 14));
		number.setColumns(10);
		number.setBounds(265, 348, 225, 33);
		contentPane.add(number);
		number.setBorder(null);
		
		pass = new JTextField();
		pass.setBackground(Color.LIGHT_GRAY);
		pass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pass.setColumns(10);
		pass.setBounds(265, 434, 225, 33);
		contentPane.add(pass);
		pass.setBorder(null);
		
		JButton btnNewButton = new JButton(" Edit Student");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-edit-30.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idnum=idfield.getText();	
				String studentName = name.getText();
				String Email=email.getText();
				String phonenumber= number.getText();
				String Password=pass.getText();
				
				if(idnum.isEmpty()|| studentName.isEmpty() || Email.isEmpty() || phonenumber.isEmpty() || Password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}
				
				if (phonenumber.isEmpty() || phonenumber.length() != 10 || !phonenumber.startsWith("98")) {
				    JOptionPane.showMessageDialog(null, "Please enter a valid phone number starting with 98 and having 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}
				
				// Create a HashMap to store the course data
                HashMap<String, String> studentData = new HashMap<>();
                studentData.put("id", idnum);
                studentData.put("name", studentName);
                studentData.put("Email", Email);
                studentData.put("phonenumber", phonenumber);
                studentData.put("Password", Password);
                
             // Call a method to send the data to the backend and add the course
                boolean success = updateCourseToBackend(studentData);

                // Display a success or error message based on the result
                if (success) {
                	 ((JFrame) SwingUtilities.getRoot((Component) e.getSource())).dispose();
                    System.out.println("Student updated successfully");
                    // Optionally, you can close the addCourse frame or reset the form
                } else {
                    System.err.println("Failed to update the student");
                }
			}
			
			// Method to send course data to the backend
			// Method to send course data to the backend
			private boolean updateCourseToBackend(HashMap<String, String> studentData) {
			    final String DB_URL = "jdbc:mysql://localhost:3307/student";
			    final String USERNAME = "root";
			    final String PASSWORD = "";

			    try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
			    String updateQuery = "UPDATE userinfo SET username = ?, email = ?, phoneNumber = ?, password = ? WHERE id = ?";
			        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
			            preparedStatement.setString(1, studentData.get("name")); 
			            preparedStatement.setString(2, studentData.get("Email"));
			            preparedStatement.setString(3, studentData.get("phonenumber"));
			            preparedStatement.setString(4, studentData.get("Password"));
			            preparedStatement.setString(5, studentData.get("id"));

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
		btnNewButton.setBounds(276, 546, 185, 39);
		contentPane.add(btnNewButton);
		
		idpanel = new JLabel("Id");
		idpanel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		idpanel.setBounds(160, 86, 75, 26);
		contentPane.add(idpanel);
		
		idfield = new JTextField();
		idfield.setBackground(Color.LIGHT_GRAY);
		idfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idfield.setColumns(10);
		idfield.setBounds(265, 86, 225, 38);
		contentPane.add(idfield);
		idfield.setBorder(null);
		
		lblNewLabel_1 = new JLabel("Edit Student");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(276, 21, 156, 26);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("_______________________");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(265, 454, 237, 26);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("_______________________");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(265, 366, 237, 26);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("_______________________");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(265, 282, 237, 26);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("_______________________");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(265, 192, 237, 26);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("_______________________");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(265, 111, 237, 26);
		contentPane.add(lblNewLabel_5);
	}
}
