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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class HostSignup extends JFrame {

	private JPanel contentPane;
	private final JLabel lblHostNamr = new JLabel("New Host Name:");
	private final JLabel lblHotelAddress = new JLabel("Hotel Address:");
	private final JLabel lblZipCode = new JLabel("New Password:");
	private final JTextField textHostName = new JTextField();
	private final JTextField textAddress = new JTextField();
	private final JLabel lblPhoneNumber = new JLabel("Capacity:");
	private final JTextField textCapacity = new JTextField();
	private final JButton btnSignup = new JButton("Signup");
	private final JTextField textPrice = new JTextField();
	private final JLabel lblPrice = new JLabel("Price:");
	private final JPasswordField passwordField = new JPasswordField();
	private final JTextField textEmail = new JTextField();
	private final JLabel lblEmail = new JLabel("Email:");
	Connection connection=null;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HostSignup frame = new HostSignup();
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
	public HostSignup() {
		textHostName.setBounds(180, 46, 142, 20);
		textHostName.setColumns(10);
		connection = SqliteConnection.dbConnector();
		initGUI();
	}
	private void initGUI() {
		setTitle("BuffBeds-Host Signup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblHostNamr.setBounds(89, 49, 89, 14);
		
		contentPane.add(lblHostNamr);
		lblHotelAddress.setBounds(81, 144, 97, 14);
		
		contentPane.add(lblHotelAddress);
		lblZipCode.setBounds(89, 77, 89, 14);
		
		contentPane.add(lblZipCode);
		
		contentPane.add(textHostName);
		textAddress.setColumns(10);
		textAddress.setBounds(180, 141, 142, 20);
		
		contentPane.add(textAddress);
		lblPhoneNumber.setBounds(104, 175, 58, 14);
		
		contentPane.add(lblPhoneNumber);
		textCapacity.setColumns(10);
		textCapacity.setBounds(180, 172, 142, 20);
		
		contentPane.add(textCapacity);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//write something after host signup
				try {
					String sql_query = "insert into HotelInfo (Hostname,Email,Address,Capacity,Price) values (?,?,?,?,?)";
					PreparedStatement prep_state = connection.prepareStatement(sql_query);
					prep_state.setString(1, textHostName.getText());
					prep_state.setString(3, textAddress.getText());
					prep_state.setString(2, textEmail.getText());
					prep_state.setString(4, textCapacity.getText());
					prep_state.setString(5, textPrice.getText());
					prep_state.execute();
					
					prep_state.close();
					
					String sql_query_1 = "insert into UserInfo (Username,Email,Password,AccessType) values (?,?,?,?)";
					PreparedStatement prep_state_1 = connection.prepareStatement(sql_query_1);
					prep_state_1.setString(1, textHostName.getText());
					prep_state_1.setString(3, passwordField.getText());
					prep_state_1.setString(2, textEmail.getText());
					prep_state_1.setString(4, "Host");
					prep_state_1.execute();
					
					prep_state_1.close();
					
					JOptionPane.showMessageDialog(null, "Sucess:Please log in with new ID");
					
					LoginView new_login = new LoginView();
					dispose();
					new_login.setVisible(true);
					
				}catch(Exception ex) {
					//JOptionPane.showMessageDialog(null, "cannot set");
					ex.printStackTrace();
				}
			}
		});
		btnSignup.setBounds(207, 234, 89, 23);
		
		contentPane.add(btnSignup);
		textPrice.setColumns(10);
		textPrice.setBounds(180, 203, 142, 20);
		
		contentPane.add(textPrice);
		lblPrice.setBounds(132, 206, 38, 14);
		
		contentPane.add(lblPrice);
		passwordField.setBounds(180, 74, 142, 20);
		
		contentPane.add(passwordField);
		textEmail.setColumns(10);
		textEmail.setBounds(180, 105, 142, 20);
		
		contentPane.add(textEmail);
		lblEmail.setBounds(116, 102, 46, 14);
		
		contentPane.add(lblEmail);
	}

}
