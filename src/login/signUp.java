package login;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import student.studentDashboard;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class signUp extends JFrame {
	
	private JLabel enable; 
    private JLabel disable;

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    static final String DB_URL = "jdbc:mysql://localhost:3307/student";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
    static final String TABLE_NAME = "userinfo"; // Change this to your desired table name

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    signUp frame = new signUp();
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
    public signUp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 708, 891);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0,128,128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel lblNewLabel = new JLabel("SignUp Page");
        lblNewLabel.setBounds(235, 0, 221, 43);
        contentPane.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));

        JLabel lblNewLabel_1 = new JLabel("Welcome to signUp page!");
        lblNewLabel_1.setBounds(204, 72, 286, 25);
        contentPane.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));

        textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField.setBackground(new Color(0,128,128));
        textField.setBounds(270, 134, 211, 37);
        contentPane.add(textField);
        textField.setColumns(10);
        textField.setBorder(null);

        JLabel lblNewLabel_2 = new JLabel("UserName");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2.setBounds(109, 159, 120, 20);
        contentPane.add(lblNewLabel_2);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField_1.setBackground(new Color(0,128,128));
        textField_1.setColumns(10);
        textField_1.setBounds(270, 222, 211, 37);
        contentPane.add(textField_1);
        textField_1.setBorder(null);

        JLabel lblNewLabel_2_1 = new JLabel("Email");
        lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2_1.setBounds(109, 248, 100, 20);
        contentPane.add(lblNewLabel_2_1);

        JLabel lblNewLabel_2_2 = new JLabel("Password");
        lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2_2.setBounds(109, 340, 120, 20);
        contentPane.add(lblNewLabel_2_2);

        textField_2 = new JPasswordField();
        textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField_2.setBackground(new Color(0,128,128));
        textField_2.setColumns(10);
        textField_2.setBounds(270, 315, 211, 37);
        contentPane.add(textField_2);
        textField_2.setBorder(null);

        JLabel lblNewLabel_2_2_1 = new JLabel("Phone Number");
        lblNewLabel_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2_2_1.setBounds(109, 424, 138, 20);
        contentPane.add(lblNewLabel_2_2_1);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        textField_3.setBackground(new Color(0,128,128));
        textField_3.setColumns(10);
        textField_3.setBounds(270, 395, 211, 37);
        contentPane.add(textField_3);
        textField_3.setBorder(null);

        JLabel lblNewLabel_2_2_1_1 = new JLabel("Select mode");
        lblNewLabel_2_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2_2_1_1.setBounds(109, 499, 120, 20);
        contentPane.add(lblNewLabel_2_2_1_1);

        JLabel lblNewLabel_2_2_1_2 = new JLabel("Select course");
        lblNewLabel_2_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2_2_1_2.setBounds(109, 566, 127, 20);
        contentPane.add(lblNewLabel_2_2_1_2);

        JLabel countryLabel = new JLabel("Mode:");
        String[] countries = {"Student", "Tutor", "Admin"};
        JComboBox<String> countryComboBox = new JComboBox<>(countries);
        countryComboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        countryComboBox.setBounds(270, 497, 211, 25);
        contentPane.add(countryLabel);
        contentPane.add(countryComboBox);

        JLabel courseLabel = new JLabel("Select Course:");
        String[] courses = {"BIT", "BIBM", "MBA"};
        JComboBox<String> courseComboBox = new JComboBox<>(courses);
        courseComboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        courseComboBox.setBounds(270, 564, 211, 25);
        contentPane.add(courseLabel);
        contentPane.add(courseComboBox);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnNewButton.setBackground(new Color(46,139,87));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnNewButton.setBackground(Color.WHITE);
        	}
        });
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	login abc = new login ();
            	abc.setVisible(true);
               
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton.setBounds(270, 768, 211, 37);
        contentPane.add(btnNewButton);
        
        JLabel createResult = new JLabel("");
        createResult.setForeground(Color.GREEN);
        createResult.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        createResult.setBounds(10, 642, 250, 30);
        contentPane.add(createResult);

        JButton btnCreate = new JButton("Create");
        btnCreate.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnCreate.setBackground(new Color(46,139,87));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnCreate.setBackground(Color.WHITE);
        	}
        });
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 //get input from users
                // Retrieve data from the textField
                String username = textField.getText();
                String email = textField_1.getText();
                String password = textField_2.getText();
                String phoneNumber = textField_3.getText();
                String mode = (String) countryComboBox.getSelectedItem();
                String selectedCourse = (String) courseComboBox.getSelectedItem();
                
                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()) {
                    // Show an error message if any field is empty
                    JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (phoneNumber.isEmpty() || phoneNumber.length() != 10 || !phoneNumber.startsWith("98")) {
				    JOptionPane.showMessageDialog(null, "Please enter a valid phone number starting with 98 and having 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}

                // Print the entered values for demonstration
                System.out.println("Username: " + username);
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
                System.out.println("Phone Number: " + phoneNumber);
                System.out.println("Mode: " + mode);
                System.out.println("Selected Course: " + selectedCourse);

                // Store the data in the database
                try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
                    System.out.println("Connecting to database....");
                    String sql = "INSERT INTO " + "userinfo" + " (username, email, password, phoneNumber, mode, selectedCourse) VALUES (?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                        pstmt.setString(1, username);
                        pstmt.setString(2, email);
                        pstmt.setString(3, password);
                        pstmt.setString(4, phoneNumber);
                        pstmt.setString(5, mode);
                        pstmt.setString(6, selectedCourse);

                        int affectedRows = pstmt.executeUpdate();
                        if (affectedRows > 0) {
                            System.out.println("Data inserted successfully!");
                            createResult.setText("Account created successfully");
                        } else {
                        	createResult.setText("Failed to create account.Try again!");
                            System.out.println("Data insertion failed!");
                        }
                    }
                } catch (SQLException exc) {
                    System.out.println("Something went wrong while connecting to the database.");
                    System.out.println(exc);
                }
            }
        });
        btnCreate.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnCreate.setBounds(270, 635, 211, 37);
        contentPane.add(btnCreate);
        
        JLabel lblNewLabel_2_2_1_2_1 = new JLabel("Already have an account?");
        lblNewLabel_2_2_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2_2_1_2_1.setBounds(264, 710, 254, 20);
        contentPane.add(lblNewLabel_2_2_1_2_1);
        
        JLabel lblNewLabel_3 = new JLabel("_____________________");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_3.setBounds(270, 420, 210, 25);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_3_1 = new JLabel("_____________________");
        lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_3_1.setBounds(270, 338, 210, 25);
        contentPane.add(lblNewLabel_3_1);
        
        JLabel lblNewLabel_3_2 = new JLabel("_____________________");
        lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_3_2.setBounds(270, 246, 210, 25);
        contentPane.add(lblNewLabel_3_2);
        
        JLabel lblNewLabel_3_3 = new JLabel("_____________________");
        lblNewLabel_3_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_3_3.setBounds(270, 157, 210, 25);
        contentPane.add(lblNewLabel_3_3);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\java\\icons\\icons8-username-24.png"));
        lblNewLabel_4.setBounds(505, 159, 40, 19);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_4_1 = new JLabel("");
        lblNewLabel_4_1.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\java\\icons\\icons8-email-30.png"));
        lblNewLabel_4_1.setBounds(505, 248, 40, 19);
        contentPane.add(lblNewLabel_4_1);
        
        disable = new JLabel("");
		disable.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        setCursor(new Cursor(Cursor.HAND_CURSOR));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    }

		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	((JPasswordField) textField_2).setEchoChar((char) 0);
		        disable.setVisible(false);
		        disable.setEnabled(false);
		        enable.setVisible(true);
		        enable.setEnabled(true);
		    }
		});

		// Set the initial state for the disable icon
		disable.setVisible(true); // Initially visible
		disable.setEnabled(true);
        disable.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\java\\icons\\icons8-invisible-30.png"));
        disable.setBounds(505, 340, 40, 24);
        contentPane.add(disable);
        
        enable = new JLabel("");
        enable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            	((JPasswordField) textField_2).setEchoChar('\u25CF');
                disable.setVisible(true);
                disable.setEnabled(true);
                enable.setVisible(false);
                enable.setEnabled(false);
            }
        });
        enable.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\java\\icons\\icons8-eye-30.png"));
        enable.setBounds(505, 340, 40, 24);
        contentPane.add(enable);
        
        JLabel lblNewLabel_4_1_2 = new JLabel("");
        lblNewLabel_4_1_2.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\java\\icons\\icons8-phonecall-30.png"));
        lblNewLabel_4_1_2.setBounds(505, 419, 40, 25);
        contentPane.add(lblNewLabel_4_1_2);
        
        
       
    }
}

