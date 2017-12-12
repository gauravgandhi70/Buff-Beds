package buffbeds;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.sql.*;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private final JTextField textUsername = new JTextField();
	private final JButton LoginBtn = new JButton("Login");
	private final JButton SignupBtn = new JButton("Signup");
	private final JLabel lblUsername = new JLabel("Username:");
	private final JLabel lblPassword = new JLabel("Password:");
	private final JPasswordField textPassword = new JPasswordField();
	private final JLabel imagelbl = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	Connection connection = null;

	public LoginView() {
		textUsername.setBounds(197, 67, 99, 20);
		textUsername.setColumns(10);
		connection = SqliteConnection.dbConnector();
		initGUI();
	}
	private void initGUI() {
		setTitle("Buffbeds-Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(textUsername);
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String sql_query = "Select * from UserInfo where username=? and password=?";
					PreparedStatement prep_state = connection.prepareStatement(sql_query);
					prep_state.setString(1, textUsername.getText());
					prep_state.setString(2, textPassword.getText());
					ResultSet res_set = prep_state.executeQuery();
					//prep_state.close();
					if(res_set.next()) {
						//JOptionPane.showMessageDialog(null, res_set.getString("AccessType"));
						if(res_set.getString("AccessType").equals("Admin")) {
						//see to open which view
							prep_state.close();
							try {
								connection.close();
							}catch(Exception ex) {
								ex.printStackTrace();
							}
							AdminView admin_view = new AdminView();
							dispose();
							admin_view.setVisible(true);
							
						}
						else if(res_set.getString("AccessType").equals("Customer")) {
							prep_state.close();
							try {
								connection.close();
							}catch(Exception ex) {
								ex.printStackTrace();
							}
							UserView user_view = new UserView(textUsername.getText());
							dispose();
							user_view.setVisible(true);
							
						}
						else if(res_set.getString("AccessType").equals("Host")) {
							prep_state.close();
							try {
								connection.close();
							}catch(Exception ex) {
								ex.printStackTrace();
							}
							HostView host_view = new HostView(textUsername.getText());
							dispose();
							host_view.setVisible(true);
							
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Wrong Password");
					}
				}catch(Exception ex) {
					ex.printStackTrace();
					//JOptionPane.showMessageDialog(null, "cant open");
				}
				
				
			}
		});
		LoginBtn.setBounds(93, 129, 89, 20);
		
		contentPane.add(LoginBtn);
		SignupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignupAsView sign_up_choice = new SignupAsView();
				setVisible(false);
//				try {
//					connection.close();
//				}catch(Exception ex) {
//					ex.printStackTrace();
//				}
				sign_up_choice.setVisible(true);
			}
		});
		SignupBtn.setBounds(207, 129, 89, 20);
		
		contentPane.add(SignupBtn);
		lblUsername.setBounds(125, 70, 63, 14);
		
		contentPane.add(lblUsername);
		lblPassword.setBounds(125, 101, 63, 14);
		
		contentPane.add(lblPassword);
		textPassword.setBounds(197, 98, 99, 20);
		
		contentPane.add(textPassword);
		imagelbl.setBounds(24, 11, 75, 60);
		
		contentPane.add(imagelbl);
		
		Image ralphie = new ImageIcon(this.getClass().getResource("/ralphie.png")).getImage();
		imagelbl.setIcon(new ImageIcon("C:\\Users\\Sarang\\eclipse-workspace\\Buffbeds\\bin\\ralphie.png"));
	}
}
