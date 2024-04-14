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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class editTutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField number;
	private JLabel lblNewLabel_1;
	private JTextField idfield;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editTutor frame = new editTutor();
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
	public editTutor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel coursenamepanel = new JLabel("Tutor Name");
		coursenamepanel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		coursenamepanel.setBounds(120, 166, 136, 26);
		contentPane.add(coursenamepanel);
		
		name = new JTextField();
		name.setBackground(Color.LIGHT_GRAY);
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setBounds(277, 144, 225, 37);
		contentPane.add(name);
		name.setColumns(10);
		name.setBorder(null);
		
		JLabel yearspanel = new JLabel("Email");
		yearspanel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		yearspanel.setBounds(142, 254, 76, 26);
		contentPane.add(yearspanel);
		
		JLabel numberpanel = new JLabel("Phone Number");
		numberpanel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		numberpanel.setBounds(107, 334, 147, 26);
		contentPane.add(numberpanel);
		
		email = new JTextField();
		email.setBackground(Color.LIGHT_GRAY);
		email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		email.setColumns(10);
		email.setBounds(277, 231, 225, 37);
		contentPane.add(email);
		email.setBorder(null);
		
		number = new JTextField();
		number.setBackground(Color.LIGHT_GRAY);
		number.setFont(new Font("Tahoma", Font.PLAIN, 14));
		number.setColumns(10);
		number.setBounds(277, 315, 225, 33);
		contentPane.add(number);
		number.setBorder(null);
		
		JButton btnNewButton = new JButton(" Edit Tutor");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(Color.WHITE);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-edit-30.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idnum=idfield.getText();	
				String tutorName = name.getText();
				String Email=email.getText();
				String phonenumber= number.getText();
				
				
				if(idnum.isEmpty()|| tutorName.isEmpty() || Email.isEmpty() || phonenumber.isEmpty()  ) {
					JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}
				
				if (phonenumber.isEmpty() || phonenumber.length() != 10 || !phonenumber.startsWith("98")) {
				    JOptionPane.showMessageDialog(null, "Please enter a valid phone number starting with 98 and having 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}
				
				// Create a HashMap to store the course data
                HashMap<String, String> courseData = new HashMap<>();
                courseData.put("id", idnum);
                courseData.put("tutorname", tutorName);
                courseData.put("Email", Email);
                courseData.put("phonenumber", phonenumber);
                
                
             // Call a method to send the data to the backend and add the course
                boolean success = updateCourseToBackend(courseData);

                // Display a success or error message based on the result
                if (success) {
                	 ((JFrame) SwingUtilities.getRoot((Component) e.getSource())).dispose();
                    System.out.println("Tutor updated successfully");
                    // Optionally, you can close the addCourse frame or reset the form
                } else {
                    System.err.println("Failed to update the tutor");
                }
			}
			
			// Method to send course data to the backend
			// Method to send course data to the backend
			private boolean updateCourseToBackend(HashMap<String, String> courseData) {
			    final String DB_URL = "jdbc:mysql://localhost:3307/student";
			    final String USERNAME = "root";
			    final String PASSWORD = "";

			    try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
			    String updateQuery = "UPDATE userinfo SET username = ?, email = ?, phoneNumber = ?  WHERE id = ?";
			        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
			            preparedStatement.setString(1, courseData.get("tutorname")); 
			            preparedStatement.setString(2, courseData.get("Email"));
			            preparedStatement.setString(3, courseData.get("phonenumber"));
			            preparedStatement.setString(4, courseData.get("id"));

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
		btnNewButton.setBounds(277, 426, 225, 48);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Edit Tutor");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(305, 11, 136, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblId.setBounds(165, 77, 40, 26);
		contentPane.add(lblId);
		
		idfield = new JTextField();
		idfield.setBackground(Color.LIGHT_GRAY);
		idfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idfield.setColumns(10);
		idfield.setBounds(277, 64, 225, 39);
		contentPane.add(idfield);
		idfield.setBorder(null);
		
		lblNewLabel = new JLabel("_______________________");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(276, 334, 240, 26);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("_______________________");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(276, 254, 240, 26);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("_______________________");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(275, 166, 240, 26);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("_______________________");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(275, 86, 240, 26);
		contentPane.add(lblNewLabel_4);
	}
}
