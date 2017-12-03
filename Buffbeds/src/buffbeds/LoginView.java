package buffbeds;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private final JTextField textUsername = new JTextField();
	private final JButton LoginBtn = new JButton("Login");
	private final JButton SignupBtn = new JButton("Signup");
	private final JLabel lblUsername = new JLabel("Username:");
	private final JLabel lblPassword = new JLabel("Password:");
	private final JPasswordField textPassword = new JPasswordField();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginView frame = new LoginView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		textUsername.setBounds(197, 67, 99, 20);
		textUsername.setColumns(10);
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
				AdminView admin_view = new AdminView();
				setVisible(false);
				admin_view.setVisible(true);
			}
		});
		LoginBtn.setBounds(93, 129, 89, 20);
		
		contentPane.add(LoginBtn);
		SignupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignupAsView sign_up_choice = new SignupAsView();
				setVisible(false);
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
	}
}
