package admin;

import java.awt.EventQueue;
import Database.databaseOperation;
import login.login;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class adminGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static String useremail;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminGui frame = new adminGui(useremail);
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
	public adminGui(String email) {
		this.useremail=useremail;
		
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 1100, 700);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        
	        JPanel sidebarPanel = new JPanel();
	        sidebarPanel.setBackground(Color.LIGHT_GRAY); // Dark blue-gray color
	        sidebarPanel.setBounds(0, 75, 200, 588);
	        contentPane.add(sidebarPanel);
	        sidebarPanel.setLayout(null);
	         
	         
	        JButton btnNewButton = new JButton(" Dashboard");
	        btnNewButton.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-dashboard-50.png"));
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		adminGui admin = new adminGui(email);
	        		admin.setVisible(true);
	        	}	
	        });
	        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 19));
	        btnNewButton.setBackground(new Color(240, 240, 240));
	        btnNewButton.setBounds(0, 167, 200, 45);
	        sidebarPanel.add(btnNewButton);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBackground(Color.LIGHT_GRAY);
	        panel_1.setBounds(0, 0, 200, 146);
	        sidebarPanel.add(panel_1);
	        panel_1.setLayout(null);
	        
	        JLabel lblNewLabel_6 = new JLabel("Welcome!");
	        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
	        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\97798\\Downloads\\icons8-learning-100.png"));
	        lblNewLabel_6.setBounds(35, 24, 124, 55);
	        panel_1.add(lblNewLabel_6);
	        
	        JLabel lblNewLabel_2 = new JLabel("Course Management System");
	        lblNewLabel_2.setBounds(0, 90, 200, 32);
	        panel_1.add(lblNewLabel_2);
	        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
	        
	        
	        JButton btnCourses = new JButton(" Courses");
	        btnCourses.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-course-50.png"));
	        btnCourses.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		courses course =new courses();
	        		course.setVisible(true);
	        	}
	        });
	        btnCourses.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnCourses.setBackground(UIManager.getColor("Button.background"));
	        btnCourses.setBounds(0, 244, 200, 40);
	        sidebarPanel.add(btnCourses);
	        
	        JButton btnSettings = new JButton(" Students");
	        btnSettings.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-student-50.png"));
	        btnSettings.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		dispose();
	        		students std =new students(useremail);
	        		std.setVisible(true);
	        	}
	        });
	        btnSettings.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnSettings.setBackground(UIManager.getColor("Button.background"));
	        btnSettings.setBounds(0, 381, 200, 45);
	        sidebarPanel.add(btnSettings);
	        
	        JButton btnLogout = new JButton(" Logout");
	        btnLogout.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-logout-50.png"));
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
	        btnLogout.setBounds(0, 538, 200, 40);
	        sidebarPanel.add(btnLogout);
	        
	        JButton btnTutors = new JButton("Tutors");
	        btnTutors.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-tutor-48.png"));
	        btnTutors.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		tutors tutor =new tutors(useremail);
	        		tutor.setVisible(true);
	        	}
	        });
	        btnTutors.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnTutors.setBackground(UIManager.getColor("Button.background"));
	        btnTutors.setBounds(0, 314, 200, 45);
	        sidebarPanel.add(btnTutors);
	        
	        JButton btnSettings_1 = new JButton(" Settings");
	        btnSettings_1.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-setting-50.png"));
	        btnSettings_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		settings setting =new settings(email);
	        		setting.setVisible(true);
	        	}
	        });
	        btnSettings_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnSettings_1.setBackground(UIManager.getColor("Button.background"));
	        btnSettings_1.setBounds(0, 448, 200, 45);
	        sidebarPanel.add(btnSettings_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 1100, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Mode:");
		lblNewLabel.setBounds(397, 25, 135, 22);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNewLabel_5 = new JLabel("Admin");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_5.setBounds(548, 25, 93, 21);
		panel.add(lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(200, 75, 885, 588);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(15, 0, 0, 0, (Color) Color.RED));
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(28, 46, 183, 117);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel coursenum = new JLabel("");
		coursenum.setHorizontalAlignment(SwingConstants.CENTER);
		coursenum.setBounds(46, 29, 73, 63);
		panel_3.add(coursenum);
		coursenum.setBackground(new Color(255, 0, 255));
		
		int totalCourses = databaseOperation.getTotalCourses();
		int totaltutor = databaseOperation.getTotalUser("Tutor");
		int totalstudent = databaseOperation.getTotalUser("Student");
	
		coursenum.setText(String.valueOf(totalCourses));
		coursenum.setFont(new Font("Times New Roman", Font.BOLD, 63));
	      	
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBorder(new MatteBorder(15, 0, 0, 0, (Color) Color.RED));
		panel_3_1.setBackground(new Color(192, 192, 192));
		panel_3_1.setBounds(305, 46, 183, 117);
		panel_2.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JLabel tutornum = new JLabel("");
		tutornum.setHorizontalAlignment(SwingConstants.CENTER);
		tutornum.setBackground(Color.MAGENTA);
		tutornum.setBounds(39, 26, 90, 63);
		tutornum.setText(String.valueOf(totaltutor));
		panel_3_1.add(tutornum);
		
		
		int totalTutors1 = databaseOperation.getTotalTutors();
		int totalTutors2 = databaseOperation.getTotalTutors1();
		int totalTutors = totalTutors1 + totalTutors2;
		tutornum.setText(String.valueOf(totaltutor));
		tutornum.setFont(new Font("Times New Roman", Font.BOLD, 63));
		System.out.println("totaltutor");
		System.out.println(totaltutor);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBorder(new MatteBorder(15, 0, 0, 0, (Color) Color.RED));
		panel_3_2.setBackground(new Color(192, 192, 192));
		panel_3_2.setBounds(582, 46, 183, 117);
		panel_2.add(panel_3_2);
		panel_3_2.setLayout(null);
		
		JLabel studentnum = new JLabel("");
		studentnum.setHorizontalAlignment(SwingConstants.CENTER);
		studentnum.setBackground(Color.MAGENTA);
		studentnum.setBounds(57, 25, 76, 63);
		panel_3_2.add(studentnum);
		int totalStudents1 = databaseOperation.getTotalStudents();
		System.out.println(totalStudents1);
		int totalStudents2 = databaseOperation.getTotalStudents1();
		System.out.println(totalStudents2);
		int totalStudents = totalStudents1 + totalStudents2;
		System.out.println(totalStudents);
		studentnum.setText(String.valueOf(totalstudent));
		studentnum.setFont(new Font("Times New Roman", Font.BOLD, 63));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		panel_4.setBounds(28, 176, 850, 402);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 830, 400);
		panel_4.add(scrollPane_1);

		JTable table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
		        new Object[][] {},
		        new String[] { "Id", "User Name", "Email", "Password", "Phone", "Mode", "Course" }
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(190);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(94);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);

		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		setHeaderFont(new Font("Tahoma",Font.BOLD,14), table);

		EventQueue.invokeLater(new Runnable() {
		    public void run() {
		        displayusers(table);
		        
		        JLabel lblNewLabel_1 = new JLabel("Total Courses");
		        lblNewLabel_1.setBounds(28, 11, 171, 24);
		        panel_2.add(lblNewLabel_1);
		        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		        
		        JLabel lblNewLabel_1_1 = new JLabel("Total Tutors");
		        lblNewLabel_1_1.setBounds(305, 11, 147, 24);
		        panel_2.add(lblNewLabel_1_1);
		        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		        
		        JLabel lblNewLabel_1_2 = new JLabel("Total Students");
		        lblNewLabel_1_2.setBounds(581, 16, 162, 19);
		        panel_2.add(lblNewLabel_1_2);
		        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		    }
		});		
	}
	
	private void setHeaderFont(Font font,JTable table) {
        JTableHeader header = table.getTableHeader();
        header.setFont(font);
    }
	
		private void displayusers(JTable table) {
		    DefaultTableModel model = (DefaultTableModel) table.getModel();
		    model.setRowCount(0); // Clear the existing table data

		    final String DB_URL = "jdbc:mysql://localhost:3307/student";
		    final String USERNAME = "root";
		    final String PASSWORD = "";

		    try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
		        String query = "SELECT id, username, email, password, phoneNumber, mode, selectedCourse FROM userinfo";
		        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
		             ResultSet resultSet = preparedStatement.executeQuery()) {

		            while (resultSet.next()) {
		                int id = resultSet.getInt("id");
		                String userName = resultSet.getString("username");
		                String email = resultSet.getString("email");
		                String password=resultSet.getString("password");
		                String phonenumber = resultSet.getString("phoneNumber");
		                String mode = resultSet.getString("mode");
		                String selected_course = resultSet.getString("selectedCourse");

		                model.addRow(new Object[]{id, userName, email,password, phonenumber, mode, selected_course});
		            }
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		}

	
	private void showSuccessPopup() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Thank you for using the system !!",
                "See you soon!",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
