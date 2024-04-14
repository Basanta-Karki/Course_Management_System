package student;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import login.login;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class settings extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userName;
	private JTextField oldpassword;
	private JTextField newPassword;
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
	public settings(String useremail) {
		this.userEmail = useremail;
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

        ImageIcon logoIcon = new ImageIcon("path/to/your/logo.png"); 
        sidebarPanel.setLayout(null);
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(0, 0, -1, -1);
        logoLabel.setAlignmentX(CENTER_ALIGNMENT);
        sidebarPanel.add(logoLabel);
        
        JButton btnNewButton = new JButton("Dashboard");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		studentDashboard xyz=new studentDashboard(userEmail);
        		xyz.setVisible(true);
        	}
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton.setBackground(new Color(240, 240, 240));
        btnNewButton.setBounds(0, 158, 200, 42);
        sidebarPanel.add(btnNewButton);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.LIGHT_GRAY);
        panel_1.setBounds(0, 0, 200, 133);
        sidebarPanel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_6 = new JLabel("Welcome!");
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\97798\\Downloads\\icons8-learning-100.png"));
        lblNewLabel_6.setBounds(21, 29, 146, 48);
        panel_1.add(lblNewLabel_6);
        
        JLabel lblNewLabel_2 = new JLabel("Course Management System");
        lblNewLabel_2.setBounds(0, 90, 200, 32);
        panel_1.add(lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        
        JButton btnCourses = new JButton("Courses&Tutors");
        btnCourses.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		CoursesTutors xyz =new CoursesTutors(userEmail);
        		xyz.setVisible(true);
        	}
        });
        btnCourses.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnCourses.setBackground(UIManager.getColor("Button.background"));
        btnCourses.setBounds(0, 236, 200, 42);
        sidebarPanel.add(btnCourses);
        
        JButton btnSettings = new JButton("Settings");
        btnSettings.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		settings abc =new settings(userEmail);
        		abc.setVisible(true);
        	}
        });
        btnSettings.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnSettings.setBackground(UIManager.getColor("Button.background"));
        btnSettings.setBounds(0, 312, 200, 42);
        sidebarPanel.add(btnSettings);
        
        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		showSuccessPopup();
        		dispose();
        		login log =new login();
        		log.setVisible(true);
        	}
        });
        btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnLogout.setBackground(UIManager.getColor("Button.background"));
        btnLogout.setBounds(0, 536, 200, 42);
        sidebarPanel.add(btnLogout);
        
        JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 986, 76);
		contentPane.add(panel);
		panel.setLayout(null);
        JLabel lblNewLabel = new JLabel("User Mode:");
		lblNewLabel.setBounds(304, 25, 168, 34);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel lblStudent = new JLabel("Student");
		lblStudent.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblStudent.setBounds(467, 25, 168, 34);
		panel.add(lblStudent);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(202, 75, 784, 588);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Settings");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, 0, 145, 34);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Security & Login");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(10, 63, 205, 34);
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Help & Services");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_1_2.setBounds(10, 428, 187, 34);
		panel_2.add(lblNewLabel_1_1_2);
		
//		JLabel lblNewLabel_3_3 = new JLabel("Username");
//		lblNewLabel_3_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
//		lblNewLabel_3_3.setBounds(24, 151, 112, 26);
//		panel_2.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Old Password");
		lblNewLabel_3_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3_4.setBounds(20, 242, 134, 20);
		panel_2.add(lblNewLabel_3_4);
		
//		userName = new JTextField();
//		userName.setBackground(Color.LIGHT_GRAY);
//		userName.setColumns(10);
//		userName.setBounds(194, 131, 230, 34);
//		panel_2.add(userName);
//		userName.setBorder(null);
		
		oldpassword = new JTextField();
		oldpassword.setBackground(Color.LIGHT_GRAY);
		oldpassword.setColumns(10);
		oldpassword.setBounds(194, 219, 230, 34);
		panel_2.add(oldpassword);
		oldpassword.setBorder(null);
		
		newPassword = new JTextField();
		newPassword.setBackground(Color.LIGHT_GRAY);
		newPassword.setColumns(10);
		newPassword.setBounds(194, 294, 230, 34);
		panel_2.add(newPassword);
		newPassword.setBorder(null);
		
		JButton btnNewButton_1_1 = new JButton("Change password");
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
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String oldPassword_ = oldpassword.getText(); // Get the old password from the text field
		        String newPassword_ = newPassword.getText(); // Get the new password from the text field

		        // Logic to update password in the database
		        try {
		            // Establish database connection (replace "jdbc:mysql://localhost:3306/db_name" with your database URL)
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");

		            // SQL query to update the password
		            String updateQuery = "UPDATE userinfo SET password = ? WHERE email = ? AND password = ?";
		            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
		            pstmt.setString(1, newPassword_);
		            pstmt.setString(2, userEmail); // Assuming useremail is the email of the user
		            pstmt.setString(3, oldPassword_);
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
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(208, 365, 216, 34);
		panel_2.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Email  : heraldcollege@edu.np");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblNewLabel_4.setBounds(10, 487, 294, 34);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("New password");
		lblNewLabel_3_4_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3_4_1.setBounds(20, 319, 134, 20);
		panel_2.add(lblNewLabel_3_4_1);
		
		JLabel lblNewLabel_3 = new JLabel("_______________________");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(194, 313, 230, 26);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("_______________________");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(194, 239, 230, 26);
		panel_2.add(lblNewLabel_3_1);
		
//		JLabel lblNewLabel_3_1_1 = new JLabel("_______________________");
//		lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
//		lblNewLabel_3_1_1.setBounds(194, 151, 230, 26);
//		panel_2.add(lblNewLabel_3_1_1);
		
		
	}
	
	private void showSuccessPopup() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Thank you for using the system !!",
                "See you soon!",
                JOptionPane.INFORMATION_MESSAGE);
    }
	
	
}
