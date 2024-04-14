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
import javax.swing.ImageIcon;

public class addCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField years;
	private JTextField Bat;
	private JTextField seat;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addCourse frame = new addCourse();
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
	public addCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 685);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(94, 241, 136, 26);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBackground(Color.LIGHT_GRAY);
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setBounds(244, 223, 236, 33);
		contentPane.add(name);
		name.setColumns(10);
		name.setBorder(null);
		
		JLabel lblNoOfYears = new JLabel("No. of years");
		lblNoOfYears.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNoOfYears.setBounds(94, 314, 123, 26);
		contentPane.add(lblNoOfYears);
		
		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBatch.setBounds(142, 380, 75, 26);
		contentPane.add(lblBatch);
		
		JLabel lblSeats = new JLabel("Seats");
		lblSeats.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSeats.setBounds(142, 450, 75, 26);
		contentPane.add(lblSeats);
		
		years = new JTextField();
		years.setBackground(Color.LIGHT_GRAY);
		years.setFont(new Font("Tahoma", Font.PLAIN, 14));
		years.setColumns(10);
		years.setBounds(244, 293, 236, 33);
		contentPane.add(years);
		years.setBorder(null);
		
		Bat = new JTextField();
		Bat.setBackground(Color.LIGHT_GRAY);
		Bat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Bat.setColumns(10);
		Bat.setBounds(244, 362, 225, 33);
		contentPane.add(Bat);
		Bat.setBorder(null);
		
		seat = new JTextField();
		seat.setBackground(Color.LIGHT_GRAY);
		seat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		seat.setColumns(10);
		seat.setBounds(249, 430, 231, 33);
		contentPane.add(seat);
		seat.setBorder(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblId.setBounds(142, 173, 75, 26);
		contentPane.add(lblId);
		
		id = new JTextField();
		id.setBackground(Color.LIGHT_GRAY);
		id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		id.setColumns(10);
		id.setBounds(231, 151, 225, 33);
		contentPane.add(id);
		id.setBorder(null);
		
		JButton btnNewButton = new JButton(" Add Course");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\java\\DashboardIcons\\icons8-add-30.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseName = name.getText();
				String numberOfYears=years.getText();
				String batch= Bat.getText();
				String seats=seat.getText();
				String student_id=id.getText();
				
				// Display an error message to the user if any field is empty
				if (courseName.isEmpty() || numberOfYears.isEmpty() || batch.isEmpty() || seats.isEmpty() || student_id.isEmpty()) {
				    JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}
		
				// Create a HashMap to store the course data
                HashMap<String, String> courseData = new HashMap<>();
                courseData.put("id", student_id);
                courseData.put("name", courseName);
                courseData.put("numberOfYears", numberOfYears);
                courseData.put("batch", batch);
                courseData.put("seats", seats);
                
             // Call a method to send the data to the backend and add the course
                boolean success = addCourseToBackend(courseData);

                // Display a success or error message based on the result
                if (success) {
                	 ((JFrame) SwingUtilities.getRoot((Component) e.getSource())).dispose();
                    System.out.println("Course added successfully");
                    // Optionally, you can close the addCourse frame or reset the form
                } else {
                    System.err.println("Failed to add the course");
                }
			}
			
			// Method to send course data to the backend
			// Method to send course data to the backend
			private boolean addCourseToBackend(HashMap<String, String> courseData) {
			    

			    try (Connection connection = databaseConnection.getConnection()) {
			        String query = "INSERT INTO courses (id,course_name, no_of_years, batch, seats) VALUES (?,?, ?, ?, ?)";
			        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			        	preparedStatement.setString(1, courseData.get("id"));
			            preparedStatement.setString(2, courseData.get("name")); // Assuming 'name' is the course name
			            preparedStatement.setString(3, courseData.get("numberOfYears"));
			            preparedStatement.setString(4, courseData.get("batch"));
			            preparedStatement.setString(5, courseData.get("seats"));

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
		btnNewButton.setBounds(249, 548, 180, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ADD COURSE");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(231, 30, 225, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("_______________________");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(249, 451, 246, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("_______________________");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(244, 380, 246, 26);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("_______________________");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(249, 314, 246, 26);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("_______________________");
		lblNewLabel_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_2_1.setBounds(244, 241, 246, 26);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("_______________________");
		lblNewLabel_2_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_2_1_1.setBounds(234, 173, 246, 26);
		contentPane.add(lblNewLabel_2_2_1_1);
		
		
	}
}
