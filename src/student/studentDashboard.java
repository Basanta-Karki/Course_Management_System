package student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.databaseOperation;
import login.login;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.border.MatteBorder;

public class studentDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static String userEmail;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentDashboard frame = new studentDashboard(userEmail);
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
	public studentDashboard(String useremail) {
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
	        sidebarPanel.setLayout(null);
	        
	        
	        
	        
	        JButton btnNewButton =  new JButton("Dashboard");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		studentDashboard abc= new studentDashboard(useremail);
	        		abc.setVisible(true);
	        	}
	        });
	        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnNewButton.setBackground(new Color(240, 240, 240));
	        btnNewButton.setBounds(0, 167, 200, 41);
	        sidebarPanel.add(btnNewButton);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBackground(Color.LIGHT_GRAY);
	        panel_1.setBounds(0, 0, 200, 133);
	        sidebarPanel.add(panel_1);
	        panel_1.setLayout(null);
	        
	        JLabel lblNewLabel_6 = new JLabel("Welcome!");
	        lblNewLabel_6.setBackground(Color.LIGHT_GRAY);
	        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
	        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\97798\\Downloads\\icons8-learning-100.png"));
	        lblNewLabel_6.setBounds(25, 31, 147, 48);
	        panel_1.add(lblNewLabel_6);
	        
	        JLabel lblNewLabel_2 = new JLabel("Course Management System");
	        lblNewLabel_2.setBounds(0, 90, 200, 32);
	        panel_1.add(lblNewLabel_2);
	        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
	        
	        JButton btnCourses = new JButton("Courses&Tutors");
	        btnCourses.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		CoursesTutors xyz =new CoursesTutors(useremail);
	        		xyz.setVisible(true);
	        	}
	        });
	        btnCourses.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnCourses.setBackground(UIManager.getColor("Button.background"));
	        btnCourses.setBounds(0, 240, 200, 41);
	        sidebarPanel.add(btnCourses);
	        
	        JButton btnSettings = new JButton("Settings");
	        btnSettings.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		settings set =new settings(useremail);
	        		set.setVisible(true);
	        	}
	        });
	        btnSettings.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnSettings.setBackground(UIManager.getColor("Button.background"));
	        btnSettings.setBounds(0, 311, 200, 41);
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
	        btnLogout.setBounds(0, 545, 200, 33);
	        sidebarPanel.add(btnLogout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 986, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Mode:");
		lblNewLabel.setBounds(388, 25, 161, 34);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel lblStudent = new JLabel("Student");
		lblStudent.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblStudent.setBounds(556, 25, 161, 34);
		panel.add(lblStudent);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(200, 75, 786, 588);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(15, 0, 0, 0, (Color) Color.RED));
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(30, 48, 183, 117);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel coursenum = new JLabel("8");
		coursenum.setHorizontalAlignment(SwingConstants.CENTER);
		coursenum.setFont(new Font("Times New Roman", Font.BOLD, 63));
		coursenum.setBounds(39, 26, 90, 63);
		panel_3.add(coursenum);
		coursenum.setBackground(new Color(255, 0, 255));
		
		int totalCourses = databaseOperation.getTotalCourses();
		coursenum.setText(String.valueOf(totalCourses));
		coursenum.setFont(new Font("Tahoma", Font.PLAIN, 50));
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBorder(new MatteBorder(15, 0, 0, 0, (Color) Color.RED));
		panel_3_1.setBackground(new Color(192, 192, 192));
		panel_3_1.setBounds(297, 48, 183, 117);
		panel_2.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JLabel tutornum = new JLabel("");
		tutornum.setFont(new Font("Times New Roman", Font.BOLD, 63));
		tutornum.setHorizontalAlignment(SwingConstants.CENTER);
		tutornum.setBackground(Color.MAGENTA);
		tutornum.setBounds(39, 23, 90, 63);
		panel_3_1.add(tutornum);
		
		int totalTutors1 = databaseOperation.getTotalTutors();
		int totalTutors2 = databaseOperation.getTotalTutors1();
		int totalTutors = totalTutors1 + totalTutors2;
		tutornum.setText(String.valueOf(totalTutors));
		tutornum.setFont(new Font("Tahoma", Font.PLAIN, 50));
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBorder(new MatteBorder(15, 0, 0, 0, (Color) Color.RED));
		panel_3_2.setBackground(new Color(192, 192, 192));
		panel_3_2.setBounds(559, 48, 183, 117);
		panel_2.add(panel_3_2);
		panel_3_2.setLayout(null);
		
		JLabel studentnum = new JLabel("");
		studentnum.setHorizontalAlignment(SwingConstants.CENTER);
		studentnum.setFont(new Font("Times New Roman", Font.BOLD, 63));
		studentnum.setBackground(Color.MAGENTA);
		studentnum.setBounds(44, 22, 90, 63);
		panel_3_2.add(studentnum);
		int totalStudents1 = databaseOperation.getTotalStudents();
		int totalStudents2 = databaseOperation.getTotalStudents1();
		int totalStudents = totalStudents1 + totalStudents2;
		studentnum.setText(String.valueOf(totalStudents));
		studentnum.setFont(new Font("Tahoma", Font.PLAIN,50));
		
		JPanel tasksPanel = new JPanel();
		tasksPanel.setBackground(new Color(192, 192, 192));
		tasksPanel.setBounds(30, 216, 762, 362);
		panel_2.add(tasksPanel);
		tasksPanel.setLayout(new BorderLayout());

		// Add "To do list:" label
		JLabel lblNewLabel_3 = new JLabel("To do list:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tasksPanel.add(lblNewLabel_3, BorderLayout.NORTH);

		// Add the text field for tasks within a scroll pane
		JTextField taskTextField = new JTextField();
		taskTextField.setHorizontalAlignment(SwingConstants.LEFT);
		taskTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		taskTextField.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(taskTextField);
		tasksPanel.add(scrollPane, BorderLayout.CENTER);

		EventQueue.invokeLater(() -> displaytasks(taskTextField));
		
		JLabel lblNewLabel_6_1 = new JLabel("Find your academic report here!");
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6_1.setBounds(30, 176, 228, 22);
		panel_2.add(lblNewLabel_6_1);
		
		JButton btnNewButton_1 = new JButton("Academic report");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				academicReport report =new academicReport();
				report.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        
		        report.addWindowListener(new WindowAdapter() {
		            public void windowClosing(WindowEvent e) {
		            	report.dispose();				                
		            }
		        });
				report.setVisible(true);
			}
		});
				
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(268, 175, 197, 30);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Total Courses");
		lblNewLabel_1.setBounds(30, 11, 161, 26);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel("Total Tutors");
		lblNewLabel_1_1.setBounds(297, 11, 120, 26);
		panel_2.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_2 = new JLabel("Total Students");
		lblNewLabel_1_2.setBounds(553, 14, 138, 21);
		panel_2.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
	}
	
	private void displaytasks(JTextField taskTextField) {
	    StringBuilder tasksText = new StringBuilder();

        final String DB_URL = "jdbc:mysql://localhost:3307/student";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String query = "SELECT task_description FROM tasks";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String taskDescription = resultSet.getString("task_description");

                    tasksText.append(taskDescription).append("\n");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        taskTextField.setText(tasksText.toString());
    
    }
	
	private void showSuccessPopup() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Thank you for using the system !!",
                "See you soon!",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
