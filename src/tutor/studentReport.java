package tutor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class studentReport extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField student_id;
	private JTable table;
	private JTextField moduleName;
	private JTextField level;
	private JTextField studentName;
	private JTextField per;
	private JTextField grade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentReport frame = new studentReport();
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
	public studentReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 10, 814, 312);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Progress Report");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(24, 10, 241, 22);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(24, 37, 726, 265);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Student Name");
		lblNewLabel_1_1.setBounds(101, 54, 139, 22);
		panel_2.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_4 = new JLabel("Module Name");
		lblNewLabel_1_4.setBounds(101, 86, 139, 22);
		panel_2.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_3 = new JLabel("Enter student Id");
		lblNewLabel_1_3.setBounds(101, 22, 159, 22);
		panel_2.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Level");
		lblNewLabel_1.setBounds(101, 112, 112, 22);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_2 = new JLabel("Percentage");
		lblNewLabel_1_2.setBounds(101, 144, 125, 22);
		panel_2.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		student_id = new JTextField();
		student_id.setBounds(296, 24, 147, 22);
		panel_2.add(student_id);
		student_id.setColumns(10);
		
		moduleName = new JTextField();
		moduleName.setColumns(10);
		moduleName.setBounds(296, 88, 147, 22);
		panel_2.add(moduleName);
		
		level = new JTextField();
		level.setColumns(10);
		level.setBounds(296, 114, 147, 22);
		panel_2.add(level);
		
		studentName = new JTextField();
		studentName.setColumns(10);
		studentName.setBounds(296, 56, 147, 22);
		panel_2.add(studentName);
		
		per = new JTextField();
		per.setColumns(10);
		per.setBounds(296, 146, 147, 22);
		panel_2.add(per);
		
		JButton btnNewButton = new JButton("Create Student Report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentId=student_id.getText();
				String name=studentName.getText();
				String module=moduleName.getText();
				String levelnum=level.getText();
				String percentage=per.getText();
				String Grade=grade.getText();
			
			
				if(studentId.isEmpty()|| name.isEmpty() || module.isEmpty() || levelnum.isEmpty() || percentage.isEmpty()|| Grade.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
				    return;
				}
				
				// Create a HashMap to store the course data
                HashMap<String, String> studentData = new HashMap<>();
                studentData.put("student_id", studentId);
                studentData.put("studentName", name);
                studentData.put("moduleName", module);
                studentData.put("level", levelnum);
                studentData.put("percentage", percentage);
                studentData.put("grade", Grade);
                
             // Call a method to send the data to the backend and add the course
                boolean success = updateStudentReport(studentData);

                // Display a success or error message based on the result
                if (success) {
                	((JFrame) SwingUtilities.getRoot((Component) e.getSource())).dispose();
                    System.out.println("Student report updated successfully");
                    // Optionally, you can close the addCourse frame or reset the form
                } else {
                    System.err.println("Failed to update the student report");
                }
			}
			
			// Method to send course data to the backend
			// Method to send course data to the backend
			private boolean updateStudentReport(HashMap<String, String> studentData) {
			    final String DB_URL = "jdbc:mysql://localhost:3307/student";
			    final String USERNAME = "root";
			    final String PASSWORD = "";

			    try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
			    String updateQuery = "INSERT INTO studentReport(student_id,student_name,level,Module,percentage,grade)VALUES( ?,?, ?, ?, ?, ?) ";
			        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
			        	preparedStatement.setInt(1, Integer.parseInt(studentData.get("student_id")));
			            preparedStatement.setString(2, studentData.get("studentName")); 
			            preparedStatement.setInt(3, Integer.parseInt(studentData.get("level")));
			            preparedStatement.setString(4, studentData.get("moduleName"));
			            preparedStatement.setInt(5, Integer.parseInt(studentData.get("percentage")));
			            preparedStatement.setString(6, studentData.get("grade"));
			            

			            int rowsAffected = preparedStatement.executeUpdate();

			            return rowsAffected > 0;
			        }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			        return false;
			    }
			}
				
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton.setBounds(204, 226, 258, 29);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_1_5 = new JLabel("Grade");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_5.setBounds(101, 179, 112, 22);
		panel_2.add(lblNewLabel_1_5);
		
		grade = new JTextField();
		grade.setColumns(10);
		grade.setBounds(296, 179, 147, 22);
		panel_2.add(grade);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 332, 814, 321);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblModuleWiseProgression = new JLabel("Module Wise Progression");
		lblModuleWiseProgression.setBounds(10, 10, 241, 22);
		panel_1.add(lblModuleWiseProgression);
		lblModuleWiseProgression.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 51, 790, 260);
		panel_1.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S.N","Student Id", "Student Name","Level", "Module", "Percentage(%)", "Grade"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		
		scrollPane.setViewportView(table);
		
		 setHeaderFont(new Font("Tahoma", Font.BOLD, 16));
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

        final String DB_URL = "jdbc:mysql://localhost/STUDENT";
        final String USERNAME = "root";
        final String PASSWORD = "Neymessi1110";

        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String query = "SELECT serial_num,student_id, student_name, level, Module, percentage, grade FROM studentReport";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int Sn = resultSet.getInt("serial_num");
                    int studentId=resultSet.getInt("student_id");
                    String studentName = resultSet.getString("student_name");
                    int level = resultSet.getInt("level");
                    String module = resultSet.getString("Module");
                    String percentage = resultSet.getString("percentage");
                    String grade = resultSet.getString("grade");

                    model.addRow(new Object[]{Sn,studentId, studentName, level, module, percentage,grade});
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
