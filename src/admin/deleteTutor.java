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
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class deleteTutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idfield;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteTutor frame = new deleteTutor();
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
	public deleteTutor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeats = new JLabel("Id");
		lblSeats.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSeats.setBounds(155, 140, 48, 26);
		contentPane.add(lblSeats);
		
		idfield = new JTextField();
		idfield.setBackground(Color.LIGHT_GRAY);
		idfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idfield.setColumns(10);
		idfield.setBounds(213, 121, 200, 33);
		contentPane.add(idfield);
		idfield.setBorder(null);
		
		JButton btnNewButton = new JButton("Delete Tutor");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-delete-30.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=idfield.getText();
				if(id.isEmpty()){
					JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}       
                
             // Call a method to send the data to the backend and add the course
                boolean success = updateCourseToBackend(id);

                // Display a success or error message based on the result
                if (success) {
                	 ((JFrame) SwingUtilities.getRoot((Component) e.getSource())).dispose();
                    System.out.println("Tutor deleted successfully");
                    
                } else {
                    System.err.println("Failed to delete the tutor");
                }
			}
			
			// Method to send course data to the backend
			// Method to send course data to the backend
			private boolean updateCourseToBackend(String id) {
			    final String DB_URL = "jdbc:mysql://localhost:3307/student";
			    final String USERNAME = "root";
			    final String PASSWORD = "";

			    try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
			    	String deleteQuery= "Delete from userinfo WHERE id=?";
			        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
			            preparedStatement.setString(1, id);

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
		btnNewButton.setBounds(155, 253, 200, 39);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Delete Tutor");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(168, 31, 152, 26);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("____________________");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(213, 141, 200, 26);
		contentPane.add(lblNewLabel_1);
	}
}
