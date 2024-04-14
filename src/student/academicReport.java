package student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextField;

public class academicReport extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					academicReport frame = new academicReport();
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
	public academicReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 830, 343);
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
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(160);
		table.getColumnModel().getColumn(2).setPreferredWidth(180);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		 setHeaderFont(new Font("Tahoma", Font.BOLD, 16));
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
