package tutor;

import Database.databaseOperation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Database.databaseOperation;
import login.login;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.BorderFactory;
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
import javax.swing.border.MatteBorder;

public class tutorDashboard extends JFrame {

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
					tutorDashboard frame = new tutorDashboard(userEmail);
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
	public tutorDashboard(String userEmail) {
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
	        btnNewButton.setBounds(0, 167, 200, 40);
	        sidebarPanel.add(btnNewButton);
	        
	        JButton btnCourses = new JButton("Courses&Tutors");
	        btnCourses.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		coursesTutors abc =new coursesTutors(userEmail);
	        		abc.setVisible(true);
	        	}
	        });
	        btnCourses.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnCourses.setBackground(UIManager.getColor("Button.background"));
	        btnCourses.setBounds(0, 233, 200, 40);
	        sidebarPanel.add(btnCourses);
	        
	        JButton btnSettings = new JButton("Settings");
	        btnSettings.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		settings sett =new settings(userEmail);
	        		sett.setVisible(true);
	        	}
	        });
	        btnSettings.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnSettings.setBackground(UIManager.getColor("Button.background"));
	        btnSettings.setBounds(0, 360, 200, 40);
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
	        btnLogout.setBounds(0, 538, 200, 40);
	        sidebarPanel.add(btnLogout);
	        
	        JButton btnStudents = new JButton("Students");
	        btnStudents.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		student std =new student(userEmail);
	        		std.setVisible(true);
	        	}
	        });
	        btnStudents.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnStudents.setBackground(UIManager.getColor("Button.background"));
	        btnStudents.setBounds(0, 295, 200, 40);
	        sidebarPanel.add(btnStudents);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBackground(Color.LIGHT_GRAY);
	        panel_1.setBounds(0, 0, 200, 133);
	        sidebarPanel.add(panel_1);
	        panel_1.setLayout(null);
	        
	        JLabel lblNewLabel_6 = new JLabel("Welcome!");
	        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
	        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\97798\\Downloads\\icons8-learning-100.png"));
	        lblNewLabel_6.setBounds(32, 32, 147, 43);
	        panel_1.add(lblNewLabel_6);
	        
	        JLabel lblNewLabel_2 = new JLabel("Course Management System");
	        lblNewLabel_2.setBounds(0, 90, 200, 32);
	        panel_1.add(lblNewLabel_2);
	        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 986, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Mode:");
		lblNewLabel.setBounds(297, 28, 161, 22);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel lblNewLabel_5 = new JLabel("Tutor");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_5.setBounds(468, 25, 172, 28);
		panel.add(lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(200, 75, 776, 588);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel coursePanel = new JPanel();
		coursePanel.setBorder(new MatteBorder(15, 0, 0, 0, (Color) Color.RED));
		coursePanel.setBackground(new Color(192, 192, 192));
		coursePanel.setBounds(45, 45, 183, 117);
		panel_2.add(coursePanel);
		coursePanel.setLayout(null);
		
		JLabel coursenum = new JLabel("8");
		coursenum.setHorizontalAlignment(SwingConstants.CENTER);
		coursenum.setFont(new Font("Times New Roman", Font.BOLD, 63));
		coursenum.setBounds(37, 22, 90, 63);
		coursePanel.add(coursenum);
		coursenum.setBackground(new Color(255, 0, 255));
		
		int totalCourses = databaseOperation.getTotalCourses();
		coursenum.setText(String.valueOf(totalCourses));
		coursenum.setFont(new Font("Tahoma", Font.PLAIN, 50));
		
		JPanel tutorpanel = new JPanel();
		tutorpanel.setBorder(new MatteBorder(15, 0, 0, 0, (Color) Color.RED));
		tutorpanel.setBackground(new Color(192, 192, 192));
		tutorpanel.setBounds(306, 45, 183, 117);
		panel_2.add(tutorpanel);
		tutorpanel.setLayout(null);
		
		JLabel tutornum = new JLabel("");
		tutornum.setFont(new Font("Times New Roman", Font.BOLD, 63));
		tutornum.setHorizontalAlignment(SwingConstants.CENTER);
		tutornum.setBackground(Color.MAGENTA);
		tutornum.setBounds(45, 22, 90, 63);
		tutorpanel.add(tutornum);
		
		int totalTutors1 = databaseOperation.getTotalTutors();
		int totalTutors2 = databaseOperation.getTotalTutors1();
		int totalTutors = totalTutors1 + totalTutors2;
		tutornum.setText(String.valueOf(totalTutors));
		tutornum.setFont(new Font("Tahoma", Font.PLAIN, 50));
		
		JPanel studentpanel = new JPanel();
		studentpanel.setBorder(new MatteBorder(15, 0, 0, 0, (Color) Color.RED));
		studentpanel.setBackground(new Color(192, 192, 192));
		studentpanel.setBounds(559, 45, 183, 117);
		panel_2.add(studentpanel);
		studentpanel.setLayout(null);
		
		JLabel studentnum = new JLabel("");
		studentnum.setHorizontalAlignment(SwingConstants.CENTER);
		studentnum.setFont(new Font("Times New Roman", Font.BOLD, 63));
		studentnum.setBackground(Color.MAGENTA);
		studentnum.setBounds(45, 23, 90, 63);
		studentpanel.add(studentnum);
		
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
		JLabel lblNewLabel_3 = new JLabel("Assigned task:");
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
		
		JButton btnCreateStudentReport = new JButton("Assign task");
		btnCreateStudentReport.setBackground(new Color(192, 192, 192));
		btnCreateStudentReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignTask assign =new assignTask();
				 assign.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        
			        assign.addWindowListener(new WindowAdapter() {
			            public void windowClosing(WindowEvent e) {
			            	assign.dispose();				                
			            }
			        });

			        assign.setVisible(true);
			    }
		});
		btnCreateStudentReport.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCreateStudentReport.setBounds(80, 173, 183, 31);
		panel_2.add(btnCreateStudentReport);
		
		JButton btnCreateStudentReport_1 = new JButton("Create student report");
		btnCreateStudentReport_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentReport report = new studentReport();
				report.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        
		        report.addWindowListener(new WindowAdapter() {
		            public void windowClosing(WindowEvent e) {
		            	report.dispose();				                
		            }
		        });

		        report.setVisible(true);
		    }
		});
		btnCreateStudentReport_1.setBackground(new Color(192, 192, 192));
		btnCreateStudentReport_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCreateStudentReport_1.setBounds(390, 173, 216, 33);
		panel_2.add(btnCreateStudentReport_1);
		
		JLabel lblNewLabel_1 = new JLabel("Total Courses");
		lblNewLabel_1.setBounds(45, 11, 165, 23);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel("Total Tutors");
		lblNewLabel_1_1.setBounds(306, 11, 131, 23);
		panel_2.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_2 = new JLabel("Total Students");
		lblNewLabel_1_2.setBounds(559, 11, 151, 23);
		panel_2.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
	}
	private void showSuccessPopup() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Thank you for using the system !!",
                "See you soon!",
                JOptionPane.INFORMATION_MESSAGE);
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

                    tasksText.append(taskDescription).append("\n\n");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        taskTextField.setText(tasksText.toString());
    
    }
}
