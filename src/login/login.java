package login;
import java.awt.EventQueue;
import admin.adminGui;
import tutor.tutorDashboard;
import student.studentDashboard;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class login extends JFrame {
	
	private JLabel enable; 
    private JLabel disable;


    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField emailTextField;
    private JTextField passwordTextField;
    private String useremail;
    String selectedMode;
    static final String DB_URL = "jdbc:mysql://localhost:3307/student";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login frame = new login();
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
    public login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 648, 806);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0,128,128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Login Page");
        lblNewLabel.setBounds(235, 11, 182, 43);
        contentPane.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

        JLabel lblNewLabel_1 = new JLabel("Welcome to login page !");
        lblNewLabel_1.setBounds(202, 92, 286, 25);
        contentPane.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
        JLabel countryLabel = new JLabel("User mode");
        String[] usermode = {"Admin", "Tutor", "Student"};
        JComboBox<String> userComboBox = new JComboBox<>(usermode);
        userComboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        userComboBox.setBounds(223, 188, 196, 25);
        contentPane.add(countryLabel);
        contentPane.add(userComboBox);

        JLabel lblNewLabel_2 = new JLabel("Email");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2.setBounds(99, 293, 65, 21);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("Password");
        lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2_1.setBounds(99, 392, 102, 21);
        contentPane.add(lblNewLabel_2_1);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        emailTextField.setBackground(new Color(0,128,128));
        emailTextField.setBounds(223, 271, 204, 33);
        contentPane.add(emailTextField);
        emailTextField.setColumns(10);
        emailTextField.setBorder(null);

        passwordTextField = new JPasswordField();
        passwordTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        passwordTextField.setBackground(new Color(0,128,128));
        passwordTextField.setColumns(10);
        passwordTextField.setBounds(223, 372, 204, 33);
        contentPane.add(passwordTextField);
        passwordTextField.setBorder(null);

        JButton btnCreateAnAccount = new JButton("Create an account");
        btnCreateAnAccount.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnCreateAnAccount.setBackground(new Color(46,139,87));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnCreateAnAccount.setBackground(Color.WHITE);
        	}
        });
        btnCreateAnAccount.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		signUp createButton = new signUp ();
        		createButton.setVisible(true);
        	}
        });
        btnCreateAnAccount.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnCreateAnAccount.setBounds(223, 632, 215, 33);
        contentPane.add(btnCreateAnAccount);
        JLabel result = new JLabel("");
        result.setForeground(new Color(255, 0, 0));
        result.setFont(new Font("Tahoma", Font.PLAIN, 18));
        result.setBounds(151, 696, 370, 43);
        contentPane.add(result);

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
     // ActionListener for the Login button
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailTextField.getText();
                String password = passwordTextField.getText();
                String selectedMode = (String) userComboBox.getSelectedItem();
                String userMode = validateLogin(email, password, selectedMode);
                useremail=email;
                
                if ( email.isEmpty() || password.isEmpty()) {
                    // Show an error message if any field is empty
                    JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (userMode != null) {
          
                	showSuccessPopup(userMode);
                    // Login successful, navigate to the respective dashboard
                    openDashboard(userMode);
                    
                } else {
                    // Login failed
                	showErrorPopup();
                    System.out.println("Invalid credentials. Please try again.");
                    result.setText("Invalid credentials. Please try again.");
                }
            }        
        });
        
        
    
        
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton.setBounds(223, 475, 215, 43);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_3 = new JLabel("Don't have an account?");
        lblNewLabel_3.setBackground(new Color(255, 0, 0));
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_3.setBounds(223, 570, 246, 25);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("User mode");
        lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2_1_1.setBounds(99, 191, 102, 19);
        contentPane.add(lblNewLabel_2_1_1);
        
        JLabel lblNewLabel_4 = new JLabel("____________________");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_4.setBounds(223, 390, 204, 25);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_4_1 = new JLabel("____________________");
        lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_4_1.setBounds(223, 291, 204, 25);
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
		    	((JPasswordField) passwordTextField).setEchoChar((char) 0);
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
        disable.setFont(new Font("Times New Roman", Font.BOLD, 20));
        disable.setBounds(453, 392, 36, 25);
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
            	((JPasswordField) passwordTextField).setEchoChar('\u25CF');
                disable.setVisible(true);
                disable.setEnabled(true);
                enable.setVisible(false);
                enable.setEnabled(false);
            }
        });
        enable.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\java\\icons\\icons8-eye-30.png"));
        enable.setFont(new Font("Times New Roman", Font.BOLD, 20));
        enable.setBounds(453, 392, 36, 25);
        contentPane.add(enable);
        
        JLabel lblNewLabel_5_2 = new JLabel("");
        lblNewLabel_5_2.setIcon(new ImageIcon("C:\\Users\\Lenov\\OneDrive\\Desktop\\3rd Sem\\java\\icons\\icons8-email-30.png"));
        lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_5_2.setBounds(452, 293, 36, 25);
        contentPane.add(lblNewLabel_5_2);
        
       
    }

    private String validateLogin(String email, String password, String mode) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT mode FROM userinfo WHERE email = ? AND password = ? AND mode = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, email);
                pstmt.setString(2, password);
                pstmt.setString(3, mode);

                try (ResultSet resultSet = pstmt.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("mode"); // Return the user mode if login is successful
                    }
                }
            }
        } catch (SQLException exc) {
            System.out.println("Something went wrong while connecting to the database.");
            System.out.println(exc);
        }
        return null; // Return null if login fails
    }
 
    private void openDashboard(String userMode) {
        // Close the current login frame
        dispose();

        // Open the respective dashboard based on the user mode
        JFrame dashboardFrame = null;

        switch (userMode) {
            case "Admin":
                dashboardFrame = new adminGui(useremail);
                break;
            case "Tutor":
                dashboardFrame = new tutorDashboard(useremail);
                break;
            case "Student":
                dashboardFrame = new studentDashboard(useremail);
                break;
            default:
                System.out.println("Invalid user mode.");
                return; // Exit the method if user mode is invalid
        }

        dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboardFrame.setVisible(true);
    }
 // Method to show successful login pop-up
    private void showSuccessPopup(String userMode) {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Welcome, " + userMode + "!\nLogin successful!",
                "Login Success",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to show unsuccessful login pop-up
    private void showErrorPopup() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Invalid credentials. Please try again.",
                "Login Failed",
                JOptionPane.ERROR_MESSAGE);
    }
}
