package tutor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class assignTask extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					assignTask frame = new assignTask();
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
	public assignTask() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 616, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Assign a task below:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(29, 20, 184, 22);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(29, 118, 577, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("1.");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 126, 16, 13);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Assign");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=textField.getText();
				 // Replace the connection details with your database connection parameters
		        String url = "jdbc:mysql://localhost:3307/student";
		        String user = "root";
		        String password = "";
		        
		        if(text.isEmpty()) {
		        	JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
		        }
		        	        
		        try (Connection connection = DriverManager.getConnection(url, user, password)) {
		            String query = "INSERT INTO tasks (task_description) VALUES (?)";
		            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		                preparedStatement.setString(1, text);
		                preparedStatement.executeUpdate();
		                System.out.println("Task assigned successfully!");
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            System.err.println("Error assigning task to the database.");
		        }
		    }
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(261, 198, 151, 41);
		panel.add(btnNewButton);
		
		JLabel lblNoteYouCan = new JLabel("Note: You can assign one task at a time.");
		lblNoteYouCan.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNoteYouCan.setBounds(29, 53, 265, 22);
		panel.add(lblNoteYouCan);
	}
	
}
