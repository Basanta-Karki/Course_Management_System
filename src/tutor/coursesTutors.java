package tutor;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import login.login;

import javax.swing.JScrollPane;

public class coursesTutors extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private static String userEmail;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					coursesTutors frame = new coursesTutors(userEmail);
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
	public coursesTutors(String userEmail) {
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
	        		tutorDashboard dash =new tutorDashboard(userEmail);
	        		dash.setVisible(true);
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
	        lblNewLabel_6.setBounds(27, 11, 150, 68);
	        panel_1.add(lblNewLabel_6);
	        
	        JLabel lblNewLabel_2 = new JLabel("Course Management System");
	        lblNewLabel_2.setBounds(0, 90, 200, 32);
	        panel_1.add(lblNewLabel_2);
	        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
	        
	        JButton btncoursesTutors = new JButton("Courses&Tutors");
	        btncoursesTutors.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		coursesTutors tutt =new coursesTutors(userEmail);
	        		tutt.setVisible(true);
	        	}
	        });
	        btncoursesTutors.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btncoursesTutors.setBackground(UIManager.getColor("Button.background"));
	        btncoursesTutors.setBounds(0, 211, 200, 49);
	        sidebarPanel.add(btncoursesTutors);
	        
	        JButton btnSettings = new JButton("Students");
	        btnSettings.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		student std = new student(userEmail);
	        		std.setVisible(true);
	        	}
	        });
	        btnSettings.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnSettings.setBackground(UIManager.getColor("Button.background"));
	        btnSettings.setBounds(0, 282, 200, 49);
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
	        btnLogout.setBounds(0, 535, 200, 43);
	        sidebarPanel.add(btnLogout);
	        
	        JButton btnSettings_1 = new JButton("Settings");
	        btnSettings_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		settings sett = new settings(userEmail);
	        		sett.setVisible(true);
	        	}
	        });
	        btnSettings_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnSettings_1.setBackground(UIManager.getColor("Button.background"));
	        btnSettings_1.setBounds(0, 351, 200, 43);
	        sidebarPanel.add(btnSettings_1);
	        
	        JPanel panel = new JPanel();
			panel.setBackground(new Color(128, 128, 128));
			panel.setBounds(0, 0, 986, 76);
			contentPane.add(panel);
			panel.setLayout(null);
	        JLabel lblNewLabel = new JLabel("User Mode:");
			lblNewLabel.setBounds(304, 25, 161, 34);
			panel.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
			
			JLabel lblTutor = new JLabel("Tutor");
			lblTutor.setFont(new Font("Times New Roman", Font.BOLD, 30));
			lblTutor.setBounds(475, 25, 100, 34);
			panel.add(lblTutor);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(201, 75, 775, 578);
			contentPane.add(panel_2);
			panel_2.setLayout(null);
			
			JPanel panel_4 = new JPanel();
	        panel_4.setBackground(new Color(192, 192, 192));
	        panel_4.setBounds(10, 10, 755, 558);
	        panel_2.add(panel_4);
	        panel_4.setLayout(null);

	        JLabel lblCoursesDetails = new JLabel("Courses details:");
	        lblCoursesDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        lblCoursesDetails.setBounds(29, 12, 216, 22);
	        panel_4.add(lblCoursesDetails);

	        JScrollPane courseTable = new JScrollPane();
	        courseTable.setBounds(20, 44, 725, 186);
	        panel_4.add(courseTable);

	        table = new JTable();
	        courseTable.setViewportView(table);
	        table.setModel(new DefaultTableModel(
	                new Object[][] {},
	                new String[] {
	                        "Id", "Course Name", "No. of years", "Batch", "Seats"
	                }
	        ));
	        table.getColumnModel().getColumn(0).setPreferredWidth(54);
	        table.getColumnModel().getColumn(1).setPreferredWidth(160);
	        table.getColumnModel().getColumn(2).setPreferredWidth(67);
	        table.getColumnModel().getColumn(3).setPreferredWidth(64);
	        table.getColumnModel().getColumn(4).setPreferredWidth(66);
	        
	        setHeaderFont(new Font("Tahoma", Font.BOLD, 16));

	        // Fetch and display the data
	        EventQueue.invokeLater(this::displayCourses);

	        // JLabel for tutors details
	        JLabel lblCoursesDetails_1 = new JLabel("Tutors details:");
	        lblCoursesDetails_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        lblCoursesDetails_1.setBounds(20, 256, 216, 22);
	        panel_4.add(lblCoursesDetails_1);

	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(20, 288, 725, 246);
	        panel_4.add(scrollPane);

	        table_1 = new JTable();
	        scrollPane.setViewportView(table_1);
	        table_1.setModel(new DefaultTableModel(
	                new Object[][] {},
	                new String[] {
	                        "Id", "Tutor Name", "Email", "Phone", "Date"
	                }
	        ));
	        table_1.getColumnModel().getColumn(0).setPreferredWidth(66);
	        table_1.getColumnModel().getColumn(1).setPreferredWidth(153);
	        table_1.getColumnModel().getColumn(2).setPreferredWidth(155);
	        table_1.getColumnModel().getColumn(3).setPreferredWidth(128);
	        table_1.getColumnModel().getColumn(4).setPreferredWidth(120);
	        table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        setHeaderFont1(new Font("Tahoma", Font.BOLD, 16));

	        // Fetch and display the tutor data
	        EventQueue.invokeLater(this::displayTutors);

	        // Your other GUI setup code
	    }
	
	private void setHeaderFont(Font font) {
        JTableHeader header = table.getTableHeader();
        header.setFont(font);
    }
	
	private void setHeaderFont1(Font font) {
   	 JTableHeader header = table_1.getTableHeader();
        header.setFont(font);
   
}

	    private void displayCourses() {
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0);

	        final String DB_URL = "jdbc:mysql://localhost:3307/student";
	        final String USERNAME = "root";
	        final String PASSWORD = "";

	        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
	            String query = "SELECT id, course_name, no_of_years, batch, seats FROM courses";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
	                 ResultSet resultSet = preparedStatement.executeQuery()) {

	                while (resultSet.next()) {
	                    int id = resultSet.getInt("id");
	                    String courseName = resultSet.getString("course_name");
	                    String numberOfYears = resultSet.getString("no_of_years");
	                    String batch = resultSet.getString("batch");
	                    String seats = resultSet.getString("seats");

	                    model.addRow(new Object[]{id, courseName, numberOfYears, batch, seats});
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }

	    private void displayTutors() {
	        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	        model.setRowCount(0);

	        final String DB_URL = "jdbc:mysql://localhost:3307/student";
	        final String USERNAME = "root";
	        final String PASSWORD = "";

	        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
	            String query = "SELECT id, tutorname, email, phonenumber, date FROM tutors";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
	                 ResultSet resultSet = preparedStatement.executeQuery()) {

	                while (resultSet.next()) {
	                    int id = resultSet.getInt("id");
	                    String tutorName = resultSet.getString("tutorname");
	                    String email = resultSet.getString("email");
	                    String phonenumber = resultSet.getString("phonenumber");
	                    String date = resultSet.getString("date");

	                    model.addRow(new Object[]{id, tutorName, email, phonenumber, date});
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
