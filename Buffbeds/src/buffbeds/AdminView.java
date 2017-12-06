package buffbeds;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AdminView extends JFrame {

	private JPanel contentPane;
	private final JTextField UserList = new JTextField();
	private final JTextField HostList = new JTextField();
	private final JTextField RequestList = new JTextField();
	private final JButton BlockUserBtn = new JButton("Block User");
	private final JButton UnblockUserBtn = new JButton("Unblock User");
	private final JButton BlockHostBtn = new JButton("Block Host");
	private final JButton UnblockHostBtn = new JButton("Unblock Host");
	private final JButton ApproveBtn = new JButton("Approve");
	private final JButton DeclineBtn = new JButton("Decline");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView frame = new AdminView();
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
	public AdminView() {
		UserList.setHorizontalAlignment(SwingConstants.LEFT);
		UserList.setBounds(0, 11, 230, 191);
		UserList.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(UserList);
		HostList.setHorizontalAlignment(SwingConstants.LEFT);
		HostList.setColumns(10);
		HostList.setBounds(240, 11, 230, 191);
		
		contentPane.add(HostList);
		RequestList.setHorizontalAlignment(SwingConstants.LEFT);
		RequestList.setColumns(10);
		RequestList.setBounds(480, 11, 230, 191);
		
		contentPane.add(RequestList);
		BlockUserBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		BlockUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Block user
			}
		});
		BlockUserBtn.setBounds(0, 235, 89, 23);
		
		contentPane.add(BlockUserBtn);
		UnblockUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//unblock the user
			}
		});
		UnblockUserBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		UnblockUserBtn.setBounds(127, 235, 103, 23);
		
		contentPane.add(UnblockUserBtn);
		BlockHostBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//block host her
			}
			
		});
		BlockHostBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		BlockHostBtn.setBounds(240, 235, 89, 23);
		
		contentPane.add(BlockHostBtn);
		UnblockHostBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		UnblockHostBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//unblock the host
			}
		});
		UnblockHostBtn.setBounds(362, 235, 108, 23);
		
		contentPane.add(UnblockHostBtn);
		ApproveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//approve request
			}
		});
		ApproveBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		ApproveBtn.setBounds(480, 235, 89, 23);
		
		contentPane.add(ApproveBtn);
		DeclineBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Decline host
			}
		});
		DeclineBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		DeclineBtn.setBounds(621, 235, 89, 23);
		
		contentPane.add(DeclineBtn);
	}

}
