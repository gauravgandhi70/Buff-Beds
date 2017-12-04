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

public class HostSignup extends JFrame {

	private JPanel contentPane;
	private final JLabel lblHostNamr = new JLabel("Host Name:");
	private final JLabel lblHotelAddress = new JLabel("Hotel Address:");
	private final JLabel lblLine = new JLabel("Line1:");
	private final JLabel lblLine_1 = new JLabel("Line2:");
	private final JLabel lblZipCode = new JLabel("Zip Code:");
	private final JTextField textField = new JTextField();
	private final JTextField textField_1 = new JTextField();
	private final JTextField textField_2 = new JTextField();
	private final JTextField textField_3 = new JTextField();
	private final JLabel lblPhoneNumber = new JLabel("Phone Number:");
	private final JTextField textField_4 = new JTextField();
	private final JButton btnSignup = new JButton("Signup");

	/**
	 * Create the frame.
	 */
	public HostSignup() {
		textField_2.setBounds(180, 135, 142, 20);
		textField_2.setColumns(10);
		textField_1.setBounds(181, 104, 141, 20);
		textField_1.setColumns(10);
		textField.setBounds(180, 54, 142, 20);
		textField.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setTitle("BuffBeds-Host Signup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblHostNamr.setBounds(103, 57, 67, 14);
		
		contentPane.add(lblHostNamr);
		lblHotelAddress.setBounds(103, 82, 97, 14);
		
		contentPane.add(lblHotelAddress);
		lblLine.setBounds(134, 107, 37, 14);
		
		contentPane.add(lblLine);
		lblLine_1.setBounds(134, 138, 37, 14);
		
		contentPane.add(lblLine_1);
		lblZipCode.setBounds(103, 169, 67, 14);
		
		contentPane.add(lblZipCode);
		
		contentPane.add(textField);
		
		contentPane.add(textField_1);
		
		contentPane.add(textField_2);
		textField_3.setColumns(10);
		textField_3.setBounds(180, 166, 142, 20);
		
		contentPane.add(textField_3);
		lblPhoneNumber.setBounds(73, 200, 97, 14);
		
		contentPane.add(lblPhoneNumber);
		textField_4.setColumns(10);
		textField_4.setBounds(180, 197, 142, 20);
		
		contentPane.add(textField_4);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//write something after host signup
			}
		});
		btnSignup.setBounds(212, 240, 89, 23);
		
		contentPane.add(btnSignup);
	}

}
