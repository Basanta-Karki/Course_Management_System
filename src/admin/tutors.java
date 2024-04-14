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

public class tutors extends JFrame {

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
					tutors frame = new tutors(useremail);
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
	public tutors(String useremail) {
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
	        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
	        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\97798\\Downloads\\icons8-learning-100.png"));
	        lblNewLabel_6.setBounds(41, 32, 132, 48);
	        panel_1.add(lblNewLabel_6);
	        
	        JLabel lblNewLabel_2 = new JLabel("Course Management System");
	        lblNewLabel_2.setBounds(0, 90, 200, 32);
	        panel_1.add(lblNewLabel_2);
	        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
	        
	        
	        JButton btntutors = new JButton(" Courses");
	        btntutors.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\DashboardIcons\\icons8-course-50.png"));
	        btntutors.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		tutors course =new tutors(useremail);
	        		course.setVisible(true);
	        	}
	        });
	        btntutors.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btntutors.setBackground(UIManager.getColor("Button.background"));
	        btntutors.setBounds(0, 220, 200, 43);
	        sidebarPanel.add(btntutors);
	        
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
	        btnSettings.setBounds(0, 353, 200, 43);
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
	        btnLogout.setBounds(0, 535, 200, 43);
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
	        btnTutors.setBounds(0, 287, 200, 43);
	        sidebarPanel.add(btnTutors);
	        
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
	        btnSettings_1.setBounds(0, 419, 200, 43);
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
			lblAdmin.setBounds(470, 25, 175, 34);
			panel.add(lblAdmin);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(255, 255, 255));
			panel_2.setBounds(201, 75, 775, 578);
			contentPane.add(panel_2);
			panel_2.setLayout(null);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(192, 192, 192));
			panel_3.setBounds(10, 26, 755, 73);
			panel_2.add(panel_3);
			panel_3.setLayout(null);
			
			JButton btnNewButton_1 = new JButton("Add Tutor");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addTutor add =new addTutor();
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
			btnNewButton_1.setBounds(71, 27, 140, 25);
			panel_3.add(btnNewButton_1);
			
			JButton btnNewButton_1_1 = new JButton("Edit Tutor");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					editTutor edit = new editTutor();
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
			btnNewButton_1_1.setBounds(307, 27, 140, 25);
			panel_3.add(btnNewButton_1_1);
			
			JButton btnNewButton_1_2 = new JButton("Delete Tutor");
			btnNewButton_1_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteTutor delete = new deleteTutor();
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
			btnNewButton_1_2.setBounds(517, 26, 161, 25);
			panel_3.add(btnNewButton_1_2);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBackground(new Color(192, 192, 192));
			panel_4.setBounds(20, 112, 745, 443);
			panel_2.add(panel_4);
			panel_4.setLayout(null);
			
			JPanel panel_5 = new JPanel();
			panel_5.setBounds(23, 10, 710, 410);
			panel_4.add(panel_5);
			panel_5.setLayout(null);
			
			JPanel panel_6 = new JPanel();
			panel_6.setBounds(0, 0, 710, 410);
			panel_5.add(panel_6);
			panel_6.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 710, 410);
			panel_6.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Tutor Name", "Email", "Phone"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(47);
			table.getColumnModel().getColumn(1).setPreferredWidth(150);
			table.getColumnModel().getColumn(2).setPreferredWidth(185);
			table.getColumnModel().getColumn(3).setPreferredWidth(116);
			//table.getColumnModel().getColumn(4).setPreferredWidth(94);
			table.setFont(new Font("Tahoma", Font.PLAIN, 14));   
			
			setHeaderFont(new Font("Tahoma", Font.BOLD, 16));
			
			scrollPane.setViewportView(table);
			EventQueue.invokeLater(new Runnable() {
			    public void run() {
			        displaytutors();
			    }
			});
	        
	}
	
	private void setHeaderFont(Font font) {
        JTableHeader header = table.getTableHeader();
        header.setFont(font);
    }
	
	private void displaytutors() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear the existing table data

        final String DB_URL = "jdbc:mysql://localhost:3307/student";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String query = "SELECT id, username, email, phoneNumber FROM userinfo WHERE mode = 'Tutor'";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String tutorName = resultSet.getString("username");
                    String email = resultSet.getString("email");
                    String phonenumber = resultSet.getString("phoneNumber");
                    //String date = resultSet.getString("date");

                    model.addRow(new Object[]{id, tutorName, email, phonenumber});
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
