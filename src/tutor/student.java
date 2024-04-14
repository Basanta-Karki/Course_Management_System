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

public class student extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private static String userEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student frame = new student(userEmail);
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
	public student(String userEmail) {
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
	        btnNewButton.setBounds(0, 167, 200, 39);
	        sidebarPanel.add(btnNewButton);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBackground(Color.LIGHT_GRAY);
	        panel_1.setBounds(0, 0, 200, 146);
	        sidebarPanel.add(panel_1);
	        panel_1.setLayout(null);
	        
	        JLabel lblNewLabel_6 = new JLabel("Welcome!");
	        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
	        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\97798\\Downloads\\icons8-learning-100.png"));
	        lblNewLabel_6.setBounds(32, 27, 136, 46);
	        panel_1.add(lblNewLabel_6);
	        
	        JLabel lblNewLabel_2 = new JLabel("Course Management System");
	        lblNewLabel_2.setBounds(0, 90, 200, 32);
	        panel_1.add(lblNewLabel_2);
	        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
	        
	        JButton btnCourses = new JButton("Courses&Tutors");
	        btnCourses.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		coursesTutors tut =new coursesTutors(userEmail);
	        		tut.setVisible(true);
	        	}
	        });
	        btnCourses.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnCourses.setBackground(UIManager.getColor("Button.background"));
	        btnCourses.setBounds(0, 232, 200, 39);
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
	        btnSettings.setBounds(0, 366, 200, 39);
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
	        btnLogout.setBounds(0, 539, 200, 39);
	        sidebarPanel.add(btnLogout);
	        
	        JButton btnstudent = new JButton("Students");
	        btnstudent.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		student std = new student(userEmail);
	        		std.setVisible(true);
	        	}
	        });
	        btnstudent.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnstudent.setBackground(UIManager.getColor("Button.background"));
	        btnstudent.setBounds(0, 301, 200, 39);
	        sidebarPanel.add(btnstudent);
	        JPanel panel = new JPanel();
			panel.setBackground(new Color(128, 128, 128));
			panel.setBounds(0, 0, 986, 76);
			contentPane.add(panel);
			panel.setLayout(null);
	        JLabel lblNewLabel = new JLabel("User Mode:");
			lblNewLabel.setBounds(322, 25, 175, 22);
			panel.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
			
			JLabel lblNewLabel_5 = new JLabel("Tutor");
			lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 30));
			lblNewLabel_5.setBounds(496, 26, 93, 21);
			panel.add(lblNewLabel_5);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(201, 75, 775, 578);
			contentPane.add(panel_2);
			panel_2.setLayout(null);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(192, 192, 192));
			panel_3.setBounds(10, 26, 755, 55);
			panel_2.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Student Details");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
			lblNewLabel_1.setBounds(289, 23, 211, 22);
			panel_3.add(lblNewLabel_1);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBackground(new Color(192, 192, 192));
			panel_4.setBounds(20, 91, 745, 464);
			panel_2.add(panel_4);
			panel_4.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(23, 10, 710, 410);
			panel_4.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Student Name", "Email", "Phone", "Date"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(47);
			table.getColumnModel().getColumn(1).setPreferredWidth(150);
			table.getColumnModel().getColumn(2).setPreferredWidth(185);
			table.getColumnModel().getColumn(3).setPreferredWidth(116);
			table.getColumnModel().getColumn(4).setPreferredWidth(94);
			table.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			setHeaderFont(new Font("Tahoma", Font.BOLD, 16));
			scrollPane.setViewportView(table);
			EventQueue.invokeLater(new Runnable() {
			    public void run() {
			        displaystudents();
			    }
			});
	        
	        
	}
	
	private void setHeaderFont(Font font) {
        JTableHeader header = table.getTableHeader();
        header.setFont(font);
    }
	
	private void displaystudents() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear the existing table data

        final String DB_URL = "jdbc:mysql://localhost:3307/student";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String query = "SELECT id, student_name, email, phone_number, selected_course FROM students";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String studentName = resultSet.getString("student_name");
                    String email = resultSet.getString("email");
                    String phonenumber = resultSet.getString("phone_number");
                    String selected_course = resultSet.getString("selected_course");

                    model.addRow(new Object[]{id, studentName, email, phonenumber, selected_course});
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
