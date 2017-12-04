package buffbeds;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustSignup extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Name:");
	private final JLabel lblPhoneNumber = new JLabel("Phone Number:");
	private final JLabel lblNewLabel_1 = new JLabel("Mailing Address:");
	private final JTextField textField = new JTextField();
	private final JTextField textField_1 = new JTextField();
	private final JLabel lblLine = new JLabel("Line1:");
	private final JLabel lblLine_1 = new JLabel("Line2:");
	private final JTextField textField_2 = new JTextField();
	private final JTextField textField_3 = new JTextField();
	private final JLabel lblZipCode = new JLabel("Zip Code:");
	private final JTextField textField_4 = new JTextField();
	private final JButton btnSignup = new JButton("Signup");

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
		textField_1.setBounds(152, 74, 146, 20);
		textField_1.setColumns(10);
		textField.setBounds(152, 49, 146, 20);
		textField.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setTitle("Buffbeds-Customer Signup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(67, 52, 46, 14);
		
		contentPane.add(lblNewLabel);
		lblPhoneNumber.setBounds(67, 77, 77, 14);
		
		contentPane.add(lblPhoneNumber);
		lblNewLabel_1.setBounds(67, 102, 86, 14);
		
		contentPane.add(lblNewLabel_1);
		
		contentPane.add(textField);
		
		contentPane.add(textField_1);
		lblLine.setBounds(98, 127, 46, 14);
		
		contentPane.add(lblLine);
		lblLine_1.setBounds(98, 157, 46, 14);
		
		contentPane.add(lblLine_1);
		textField_2.setColumns(10);
		textField_2.setBounds(152, 127, 146, 20);
		
		contentPane.add(textField_2);
		textField_3.setColumns(10);
		textField_3.setBounds(152, 160, 146, 20);
		
		contentPane.add(textField_3);
		lblZipCode.setBounds(98, 191, 52, 14);
		
		contentPane.add(lblZipCode);
		textField_4.setColumns(10);
		textField_4.setBounds(152, 191, 146, 20);
		
		contentPane.add(textField_4);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//store to database
			}
		});
		btnSignup.setBounds(172, 222, 89, 23);
		
		contentPane.add(btnSignup);
	}
}
