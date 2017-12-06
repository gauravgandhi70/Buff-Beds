package buffbeds;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class SignupAsView extends JFrame {

	private JPanel contentPane;
	private final JRadioButton NewHostRadButton = new JRadioButton("New Host");
	private final JRadioButton NewCustRadButton = new JRadioButton("New Customer");
	private final JButton btnNewButton = new JButton("OK");
	private int choice=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupAsView frame = new SignupAsView();
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
	public SignupAsView() {
		initGUI();
	}
	private void initGUI() {
		setTitle("BuffBeds-AccountType");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 115);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		NewHostRadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCustRadButton.setSelected(false);
				choice = 1;
				
			}
		});
		NewHostRadButton.setBounds(28, 7, 109, 23);
		
		contentPane.add(NewHostRadButton);
		NewCustRadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewHostRadButton.setSelected(false);
				choice = 2;
			}
		});
		NewCustRadButton.setBounds(175, 7, 109, 23);
		
		contentPane.add(NewCustRadButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choice ==1) {
					CustSignup customer_form = new CustSignup();
					setVisible(false);
					customer_form.setVisible(true);				
				}
				else if(choice == 2) {
					HostSignup host_form = new HostSignup();
					setVisible(false);
					host_form.setVisible(true);
				}
				else {/*do something if nothing is done*/}
			}
		});
		btnNewButton.setBounds(102, 43, 89, 23);
		
		contentPane.add(btnNewButton);
	}

}
