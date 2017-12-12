package buffbeds;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import javax.swing.*;

public class CustSignup extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("New UserName:");
	private final JLabel lblPhoneNumber = new JLabel("New Password:");
	private final JLabel lblNewLabel_1 = new JLabel("Email Address:");
	private final JTextField textUsername = new JTextField();
	private final JTextField textEmail = new JTextField();
	private final JButton btnSignup = new JButton("Signup");
	
	Connection connection=null;
	private final JPasswordField passwordField = new JPasswordField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustSignup frame = new CustSignup();
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
	public CustSignup() {
		textUsername.setBounds(154, 74, 146, 20);
		textUsername.setColumns(10);
		connection = SqliteConnection.dbConnector();
		initGUI();
	}
	private void initGUI() {
		setTitle("Buffbeds-Customer Signup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(45, 77, 99, 14);
		
		contentPane.add(lblNewLabel);
		lblPhoneNumber.setBounds(45, 111, 99, 14);
		
		contentPane.add(lblPhoneNumber);
		lblNewLabel_1.setBounds(45, 142, 99, 14);
		
		contentPane.add(lblNewLabel_1);
		
		contentPane.add(textUsername);
		textEmail.setColumns(10);
		textEmail.setBounds(152, 139, 148, 20);
		
		contentPane.add(textEmail);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//store to database
				try {
					String sql_query = "insert into UserInfo (Username,Email,Password,AccessType) values (?,?,?,?)";
					PreparedStatement prep_state = connection.prepareStatement(sql_query);
					prep_state.setString(1, textUsername.getText());
					prep_state.setString(3, passwordField.getText());
					prep_state.setString(2, textEmail.getText());
					prep_state.setString(4, "Customer");
					prep_state.execute();
					
					prep_state.close();
					
					JOptionPane.showMessageDialog(null, "Sucess:Please log in with new ID");
					
					LoginView new_login = new LoginView();
					dispose();
					try {
						connection.close();
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					new_login.setVisible(true);
					
				}catch(Exception ex) {
					//JOptionPane.showMessageDialog(null, "cannot set");
					ex.printStackTrace();
				}

			}
		});
		btnSignup.setBounds(176, 172, 89, 23);
		
		contentPane.add(btnSignup);
		passwordField.setBounds(154, 108, 146, 20);
		
		contentPane.add(passwordField);
	}
}
