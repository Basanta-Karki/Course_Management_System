package admin;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

public class courses extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private static String useremail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courses frame = new courses();
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
	public courses() {
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
	          
	      
	        JButton btnNewButton = new JButton(" Dashboard");
	        btnNewButton.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-dashboard-50.png"));
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		adminGui admin = new adminGui(useremail);
	        		admin.setVisible(true);
	        	}
	        });
	        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnNewButton.setBackground(new Color(240, 240, 240));
	        btnNewButton.setBounds(0, 167, 200, 41);
	        sidebarPanel.add(btnNewButton);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBackground(Color.LIGHT_GRAY);
	        panel_1.setBounds(0, 0, 200, 146);
	        sidebarPanel.add(panel_1);
	        panel_1.setLayout(null);
	        
	        JLabel lblNewLabel_6 = new JLabel("Welcome!");
	        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\97798\\Downloads\\icons8-learning-100.png"));
	        lblNewLabel_6.setBounds(38, 44, 100, 39);
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
	        btnCourses.setBounds(0, 236, 200, 33);
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
	        btnSettings.setBounds(0, 359, 200, 41);
	        sidebarPanel.add(btnSettings);
	        
	        JButton btnLogout = new JButton(" Logout");
	        btnLogout.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-logout-50.png"));
	        btnLogout.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		showSuccessPopup();
	        		dispose();
	        		login log = new login();
	        		log.setVisible(true);
	        	}
	        });
	        btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnLogout.setBackground(UIManager.getColor("Button.background"));
	        btnLogout.setBounds(0, 545, 200, 33);
	        sidebarPanel.add(btnLogout);
	        
	        JButton btnTutors = new JButton(" Tutors");
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
	        btnTutors.setBounds(0, 292, 200, 41);
	        sidebarPanel.add(btnTutors);
	        
	        JButton btnSettings_1 = new JButton("Settings");
	        btnSettings_1.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-setting-50.png"));
	        btnSettings_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		settings setting =new settings(useremail);
	        		setting.setVisible(true);
	        	}
	        });
	        btnSettings_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnSettings_1.setBackground(UIManager.getColor("Button.background"));
	        btnSettings_1.setBounds(0, 430, 200, 41);
	        sidebarPanel.add(btnSettings_1);
	        JPanel panel = new JPanel();
			panel.setBackground(new Color(128, 128, 128));
			panel.setBounds(0, 0, 986, 76);
			contentPane.add(panel);
			panel.setLayout(null);
	        JLabel lblNewLabel = new JLabel("User Mode:");
			lblNewLabel.setBounds(326, 29, 161, 28);
			panel.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
			
			JLabel lblNewLabel_5 = new JLabel("Admin");
			lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 30));
			lblNewLabel_5.setBounds(497, 26, 93, 34);
			panel.add(lblNewLabel_5);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(201, 75, 775, 578);
			contentPane.add(panel_2);
			panel_2.setLayout(null);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(192, 192, 192));
			panel_3.setBounds(10, 26, 755, 73);
			panel_2.add(panel_3);
			panel_3.setLayout(null);
			
			JButton btnNewButton_1 = new JButton("Add Course");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addCourse add =new addCourse();
					add.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        
			        add.addWindowListener(new WindowAdapter() {
			            public void windowClosing(WindowEvent e) {
			            	add.dispose();				                
			            }
			        });
					add.setVisible(true);
				}
			});
			btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnNewButton_1.setBounds(115, 27, 152, 25);
			panel_3.add(btnNewButton_1);
			
			JButton btnNewButton_1_1 = new JButton("Edit Course");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					editCourse edit =new editCourse();
					edit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        
			        edit.addWindowListener(new WindowAdapter() {
			            public void windowClosing(WindowEvent e) {
			            	edit.dispose();				                
			            }
			        });
					edit.setVisible(true);
				}
			});
			btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnNewButton_1_1.setBounds(349, 27, 152, 25);
			panel_3.add(btnNewButton_1_1);
			
			JButton btnNewButton_1_2 = new JButton("Delete Course");
			btnNewButton_1_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteCourse delete =new deleteCourse();
					delete.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        
			        delete.addWindowListener(new WindowAdapter() {
			            public void windowClosing(WindowEvent e) {
			            	delete.dispose();				                
			            }
			        });
					delete.setVisible(true);
				}
			});
			btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnNewButton_1_2.setBounds(559, 27, 152, 25);
			panel_3.add(btnNewButton_1_2);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBackground(new Color(192, 192, 192));
			panel_4.setBounds(10, 109, 755, 459);
			panel_2.add(panel_4);
			panel_4.setLayout(null);
			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 21, 725, 428);
			panel_4.add(scrollPane);
			
			table = new JTable();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.getTableHeader().setReorderingAllowed(false);
			// Create the model with column names
			DefaultTableModel model = new DefaultTableModel(
			    new Object[][] {},
			    new String[] { "Id", "Course Name", "No. of years", "Batch", "Seats" }
			);

			// Set the model for your table
			table.setModel(model);

			// Set preferred column widths
			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			table.getColumnModel().getColumn(1).setPreferredWidth(200);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			
			setHeaderFont(new Font("Tahoma",Font.BOLD,16));
			scrollPane.setViewportView(table);
			EventQueue.invokeLater(new Runnable() {
			    public void run() {
			        displayCourses();
			    }
			}
			);      
	}
	
	private void setHeaderFont(Font font) {
        JTableHeader header = table.getTableHeader();
        header.setFont(font);
    }
	
	private void displayCourses() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear the existing table data

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
	
	private void showSuccessPopup() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Thank you for using the system !!",
                "See you soon!",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
