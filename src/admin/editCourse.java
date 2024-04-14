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

public class editCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField years;
	private JTextField batchfield;
	private JTextField seatfield;
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
					editCourse frame = new editCourse();
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
	public editCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 671);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel coursenamepanel = new JLabel("Course Name");
		coursenamepanel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		coursenamepanel.setBounds(107, 187, 136, 26);
		contentPane.add(coursenamepanel);
		
		name = new JTextField();
		name.setBackground(Color.LIGHT_GRAY);
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setBounds(265, 169, 225, 33);
		contentPane.add(name);
		name.setColumns(10);
		name.setBorder(null);
		
		JLabel yearspanel = new JLabel("No. of years");
		yearspanel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		yearspanel.setBounds(124, 273, 119, 26);
		contentPane.add(yearspanel);
		
		JLabel batchpanel = new JLabel("Batch");
		batchpanel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		batchpanel.setBounds(160, 368, 75, 26);
		contentPane.add(batchpanel);
		
		JLabel seatspanel = new JLabel("Seats");
		seatspanel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		seatspanel.setBounds(160, 456, 75, 26);
		contentPane.add(seatspanel);
		
		years = new JTextField();
		years.setBackground(Color.LIGHT_GRAY);
		years.setFont(new Font("Tahoma", Font.PLAIN, 14));
		years.setColumns(10);
		years.setBounds(265, 254, 225, 33);
		contentPane.add(years);
		years.setBorder(null);
		
		batchfield = new JTextField();
		batchfield.setBackground(Color.LIGHT_GRAY);
		batchfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
		batchfield.setColumns(10);
		batchfield.setBounds(265, 347, 225, 33);
		contentPane.add(batchfield);
		batchfield.setBorder(null);
		
		seatfield = new JTextField();
		seatfield.setBackground(Color.LIGHT_GRAY);
		seatfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
		seatfield.setColumns(10);
		seatfield.setBounds(265, 436, 225, 33);
		contentPane.add(seatfield);
		seatfield.setBorder(null);
		
		JButton btnNewButton = new JButton(" Edit Course");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-edit-30.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idnum=idfield.getText();	
				String courseName = name.getText();
				String numberOfYears=years.getText();
				String batch= batchfield.getText();
				String seats=seatfield.getText();
				
				if(idnum.isEmpty()|| courseName.isEmpty() || numberOfYears.isEmpty() || batch.isEmpty() || seats.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}
				
				// Create a HashMap to store the course data
                HashMap<String, String> courseData = new HashMap<>();
                courseData.put("id", idnum);
                courseData.put("name", courseName);
                courseData.put("numberOfYears", numberOfYears);
                courseData.put("batch", batch);
                courseData.put("seats", seats);
                
             // Call a method to send the data to the backend and add the course
                boolean success = updateCourseToBackend(courseData);

                // Display a success or error message based on the result
                if (success) {
                	 ((JFrame) SwingUtilities.getRoot((Component) e.getSource())).dispose();
                    System.out.println("Course updated successfully");
                    // Optionally, you can close the addCourse frame or reset the form
                } else {
                    System.err.println("Failed to update the course");
                }
			}
			
			// Method to send course data to the backend
			// Method to send course data to the backend
			private boolean updateCourseToBackend(HashMap<String, String> courseData) {
			    final String DB_URL = "jdbc:mysql://localhost:3307/student";
			    final String USERNAME = "root";
			    final String PASSWORD = "";

			    try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
			    String updateQuery = "UPDATE courses SET course_name = ?, no_of_years = ?, batch = ?, seats = ? WHERE id = ?";
			        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
			            preparedStatement.setString(1, courseData.get("name")); // Assuming 'name' is the course name
			            preparedStatement.setString(2, courseData.get("numberOfYears"));
			            preparedStatement.setString(3, courseData.get("batch"));
			            preparedStatement.setString(4, courseData.get("seats"));
			            preparedStatement.setString(5, courseData.get("id"));

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
		btnNewButton.setBounds(274, 545, 181, 33);
		contentPane.add(btnNewButton);
		
		idpanel = new JLabel("Id");
		idpanel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		idpanel.setBounds(148, 115, 75, 26);
		contentPane.add(idpanel);
		
		idfield = new JTextField();
		idfield.setBackground(Color.LIGHT_GRAY);
		idfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idfield.setColumns(10);
		idfield.setBounds(265, 92, 225, 39);
		contentPane.add(idfield);
		idfield.setBorder(null);
		
		lblNewLabel_1 = new JLabel("Edit Course");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(291, 23, 136, 26);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("_______________________");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(265, 456, 230, 26);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("_______________________");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(265, 368, 230, 26);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("_______________________");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(265, 274, 230, 26);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("_______________________");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(265, 187, 230, 26);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("_______________________");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(265, 116, 230, 26);
		contentPane.add(lblNewLabel_5);
	}
}
