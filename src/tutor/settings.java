package tutor;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Database.databaseConnection;
import login.login;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class settings extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_4;
	private static String userEmail;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					settings frame = new settings(userEmail);
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
	public settings(String userEmail) {
		this.userEmail = userEmail;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setBackground(Color.LIGHT_GRAY); // Dark blue-gray color
        sidebarPanel.setBounds(0, 75, 200, 588);
        contentPane.add(sidebarPanel);
        sidebarPanel.setLayout(null);
        
        
        
        
        JButton btnNewButton = new JButton("Dashboard");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		tutorDashboard tut =new tutorDashboard(userEmail);
        		tut.setVisible(true);
        	}
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton.setBackground(new Color(240, 240, 240));
        btnNewButton.setBounds(0, 157, 200, 43);
        sidebarPanel.add(btnNewButton);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.LIGHT_GRAY);
        panel_1.setBounds(0, 0, 200, 146);
        sidebarPanel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_6 = new JLabel("Welcome!");
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\97798\\Downloads\\icons8-learning-100.png"));
        lblNewLabel_6.setBounds(42, 40, 119, 45);
        panel_1.add(lblNewLabel_6);
        
        JLabel lblNewLabel_2 = new JLabel("Course Management System");
        lblNewLabel_2.setBounds(0, 90, 200, 32);
        panel_1.add(lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        
        JButton btnCourses = new JButton("Courses/Tutors");
        btnCourses.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		coursesTutors tut =new coursesTutors(userEmail);
        		tut.setVisible(true);
        	}
        });
        btnCourses.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnCourses.setBackground(UIManager.getColor("Button.background"));
        btnCourses.setBounds(0, 221, 200, 43);
        sidebarPanel.add(btnCourses);
        
        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		showSuccessPopup();
        		login log =new login();
        		log.setVisible(true);
        	}
        });
        btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnLogout.setBackground(UIManager.getColor("Button.background"));
        btnLogout.setBounds(0, 535, 200, 43);
        sidebarPanel.add(btnLogout);
        
        JButton btnTutors = new JButton("Students");
        btnTutors.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		student std =new student(userEmail);
        		std.setVisible(true);
        	}
        });
        btnTutors.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnTutors.setBackground(UIManager.getColor("Button.background"));
        btnTutors.setBounds(0, 290, 200, 43);
        sidebarPanel.add(btnTutors);
        
        JButton btnStudents = new JButton("Settings");
        btnStudents.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		settings sett = new settings(userEmail);
        		sett.setVisible(true);
        	}
        });
        btnStudents.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnStudents.setBackground(UIManager.getColor("Button.background"));
        btnStudents.setBounds(0, 364, 200, 43);
        sidebarPanel.add(btnStudents);
        
        JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 986, 76);
		contentPane.add(panel);
		panel.setLayout(null);
        JLabel lblNewLabel = new JLabel("User Mode:");
		lblNewLabel.setBounds(304, 25, 180, 41);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel lblTutor = new JLabel("Tutor");
		lblTutor.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTutor.setBounds(494, 25, 180, 41);
		panel.add(lblTutor);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(202, 75, 784, 588);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Settings");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, 0, 129, 34);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Security & Login");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(10, 73, 205, 34);
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Help & Services");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBounds(10, 443, 187, 34);
		panel_2.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Old password");
		lblNewLabel_3_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3_3.setBounds(10, 173, 129, 26);
		panel_2.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("New password");
		lblNewLabel_3_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3_4.setBounds(10, 272, 129, 20);
		panel_2.add(lblNewLabel_3_4);
		
		textField_3 = new JTextField();
		textField_3.setBackground(Color.LIGHT_GRAY);
		textField_3.setColumns(10);
		textField_3.setBounds(178, 147, 230, 40);
		panel_2.add(textField_3);
		textField_3.setBorder(null);
		
		textField_4 = new JTextField();
		textField_4.setBackground(Color.LIGHT_GRAY);
		textField_4.setColumns(10);
		textField_4.setBounds(178, 249, 230, 34);
		panel_2.add(textField_4);
		textField_4.setBorder(null);
		
		JButton btnNewButton_1_1 = new JButton("Change password");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldPassword = textField_3.getText(); // Get the old password from the text field
		        String newPassword = textField_4.getText(); // Get the new password from the text field

		        // Logic to update password in the database
		        try {
		            // Establish database connection (replace "jdbc:mysql://localhost:3306/db_name" with your database URL)
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");

		            // SQL query to update the password
		            String updateQuery = "UPDATE userinfo SET password = ? WHERE email = ? AND password = ?";
		            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
		            pstmt.setString(1, newPassword);
		            pstmt.setString(2, userEmail); // Assuming useremail is the email of the user
		            pstmt.setString(3, oldPassword);
		            System.out.println(pstmt);

		            // Execute the update query
		            int rowsAffected = pstmt.executeUpdate();

		            // Check if the password was updated successfully
		            if (rowsAffected > 0) {
		                // Password updated successfully
		                JOptionPane.showMessageDialog(null, "Password updated successfully!");
		            } else {
		                // No rows affected, old password might be incorrect
		                JOptionPane.showMessageDialog(null, "Failed to update password. Please check your old password.", "Error", JOptionPane.ERROR_MESSAGE);
		            }

		            // Close the database connection
		            pstmt.close();
		            conn.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1_1.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1_1.setBackground(Color.WHITE);
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(178, 350, 230, 40);
		panel_2.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Email  : heraldcollege@edu.np");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(12, 499, 294, 34);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("_______________________");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(178, 269, 230, 26);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("_______________________");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(178, 173, 230, 26);
		panel_2.add(lblNewLabel_3_1);
	}

	private void showSuccessPopup() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Thank you for using the system !!",
                "See you soon!",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
