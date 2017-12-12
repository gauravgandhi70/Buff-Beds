package buffbeds;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserCheckout extends JFrame {

	private JPanel contentPane;
	private final JTable tableCheckout = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnConfirm = new JButton("Confirm");
	private final JButton btnCancel = new JButton("Cancel");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCheckout frame = new UserCheckout("Gaurav");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String user_name;
	Connection connection = null;
	/**
	 * Create the frame.
	 */
	public UserCheckout(String name) {
		user_name=name;
		initGUI();
		
	}
	private void initGUI() {
		connection = SqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(10, 11, 533, 174);
		
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tableCheckout);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserView user_view = new UserView(user_name);
				dispose();
				user_view.setVisible(true);
			}
		});
		btnConfirm.setBounds(431, 211, 89, 23);
		
		contentPane.add(btnConfirm);
		btnCancel.setBounds(332, 211, 89, 23);
		
		contentPane.add(btnCancel);
		
		try {
			String sql_query = "Select * from BookingInfo";
			PreparedStatement prep_state = connection.prepareStatement(sql_query);
			ResultSet res_set = prep_state.executeQuery();
			tableCheckout.setModel(DbUtils.resultSetToTableModel(res_set));
			prep_state.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
