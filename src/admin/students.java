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

public class students extends JFrame {

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
					students frame = new students(useremail);
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
	public students(String useremail) {
		this.useremail=useremail;
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
	        btnNewButton.setBounds(0, 157, 200, 43);
	        sidebarPanel.add(btnNewButton);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBackground(Color.LIGHT_GRAY);
	        panel_1.setBounds(0, 0, 200, 146);
	        sidebarPanel.add(panel_1);
	        panel_1.setLayout(null);
	        
	        JLabel lblNewLabel_6 = new JLabel("Welcome!");
	        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\97798\\Downloads\\icons8-learning-100.png"));
	        lblNewLabel_6.setBounds(43, 49, 100, 45);
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
	        btnCourses.setBounds(0, 227, 200, 43);
	        sidebarPanel.add(btnCourses);
	        
	        JButton btnSettings = new JButton(" Students");
	        btnSettings.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-student-50.png"));
	        btnSettings.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		students std= new students(useremail);
	        		std.setVisible(true);
	        	}
	        });
	        btnSettings.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnSettings.setBackground(UIManager.getColor("Button.background"));
	        btnSettings.setBounds(0, 367, 200, 43);
	        sidebarPanel.add(btnSettings);
	        
	        JButton btnLogout = new JButton(" Logout");
	        btnLogout.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-logout-50.png"));
	        btnLogout.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		showSuccessPopup();
	        		dispose();
	        		login frame =new login();
	        		frame.setVisible(true);
	        	}
	        });
	        btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnLogout.setBackground(UIManager.getColor("Button.background"));
	        btnLogout.setBounds(0, 535, 200, 43);
	        sidebarPanel.add(btnLogout);
	        
	        JButton btnstudents = new JButton(" Tutors");
	        btnstudents.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-tutor-48.png"));
	        btnstudents.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		students tutor =new students(useremail);
	        		tutor.setVisible(true);
	        	}
	        });
	        btnstudents.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnstudents.setBackground(UIManager.getColor("Button.background"));
	        btnstudents.setBounds(0, 296, 200, 49);
	        sidebarPanel.add(btnstudents);
	        
	        JButton btnSettings_1 = new JButton(" Settings");
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
	        btnSettings_1.setBounds(0, 436, 200, 43);
	        sidebarPanel.add(btnSettings_1);
	        JPanel panel = new JPanel();
			panel.setBackground(new Color(128, 128, 128));
			panel.setBounds(0, 0, 986, 76);
			contentPane.add(panel);
			panel.setLayout(null);
	        JLabel lblNewLabel = new JLabel("User Mode:");
			lblNewLabel.setBounds(304, 25, 175, 34);
			panel.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
			
			JLabel lblAdmin = new JLabel("Admin");
			lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 30));
			lblAdmin.setBounds(469, 25, 175, 34);
			panel.add(lblAdmin);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(201, 75, 785, 578);
			contentPane.add(panel_2);
			panel_2.setLayout(null);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(192, 192, 192));
			panel_3.setBounds(10, 26, 765, 55);
			panel_2.add(panel_3);
			panel_3.setLayout(null);
			
			JButton deletebutton = new JButton("Delete Student");
			deletebutton.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
				        deleteStudent delete = new deleteStudent();
				        delete.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				        
				        delete.addWindowListener(new WindowAdapter() {
				            public void windowClosing(WindowEvent e) {
				            	delete.dispose();				                
				            }
				        });

				        delete.setVisible(true);
				    }
			});
			deletebutton.setFont(new Font("Times New Roman", Font.BOLD, 20));
			deletebutton.setBounds(478, 9, 180, 25);
			panel_3.add(deletebutton);
			
			JButton editbutton = new JButton("Edit Student");
			editbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					editStudent edit =new editStudent();
					edit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        
			        edit.addWindowListener(new WindowAdapter() {
			            public void windowClosing(WindowEvent e) {
			            	edit.dispose();				                
			            }
			        });
					edit.setVisible(true);
					
				}
			});
			editbutton.setFont(new Font("Times New Roman", Font.BOLD, 20));
			editbutton.setBounds(247, 9, 180, 25);
			panel_3.add(editbutton);
			
			JButton btnAddStudent = new JButton("Add Student");
			btnAddStudent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addStudent add =new addStudent();
					add.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        
			        add.addWindowListener(new WindowAdapter() {
			            public void windowClosing(WindowEvent e) {
			            	add.dispose();				                
			            }
			        });
					add.setVisible(true);
				}
			
			});
			btnAddStudent.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnAddStudent.setBounds(34, 9, 180, 25);
			panel_3.add(btnAddStudent);
			
			JPanel tablePanel = new JPanel();
			tablePanel.setBackground(new Color(192, 192, 192));
			tablePanel.setBounds(20, 91, 760, 464);
			panel_2.add(tablePanel);
			tablePanel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 10, 750, 444);
			tablePanel.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Student Name", "Email", "Phone"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(1).setPreferredWidth(150);
			table.getColumnModel().getColumn(2).setPreferredWidth(185);
			table.getColumnModel().getColumn(3).setPreferredWidth(116);
			//table.getColumnModel().getColumn(4).setPreferredWidth(120);
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
            String query = "SELECT id, username, email, phoneNumber FROM userinfo WHERE mode = 'Student'";
//            String query = "SELECT id, student_name, email, phone_number, selected_course FROM students";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String studentName = resultSet.getString("username");
                    String email = resultSet.getString("email");
                    String phonenumber = resultSet.getString("phoneNumber");
                    //String selected_course = resultSet.getString("selected_course");

                    model.addRow(new Object[]{id, studentName, email, phonenumber});
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
