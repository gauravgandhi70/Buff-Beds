package buffbeds;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AdminView extends JFrame {

	private JPanel contentPane;
	private final JButton BlockUserBtn = new JButton("Block User");
	private final JButton UnblockUserBtn = new JButton("Unblock User");
	private final JButton ApproveBtn = new JButton("Approve");
	private final JButton DeclineBtn = new JButton("Decline");
	private final JTable table_user = new JTable();
	private final JScrollPane UserTable = new JScrollPane();

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
	Connection connection = null;
	private final JTable request_table = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnLogout = new JButton("Logout");
	/**
	 * Create the frame.
	 */
	public AdminView() {
		
		initGUI();
	}
	private void initGUI() {
		connection = SqliteConnection.dbConnector();
		try{
			String sql_query = "Select * from UserInfo";
			PreparedStatement prep_state = connection.prepareStatement(sql_query);
			ResultSet res_set = prep_state.executeQuery();
			table_user.setModel(DbUtils.resultSetToTableModel(res_set));
			prep_state.close();
			res_set.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		try{
			String sql_query = "Select * from RequestInfo";
			PreparedStatement prep_state = connection.prepareStatement(sql_query);
			ResultSet res_set = prep_state.executeQuery();
			request_table.setModel(DbUtils.resultSetToTableModel(res_set));
			prep_state.close();
			res_set.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		try {
			connection.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		BlockUserBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		
		BlockUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Block user
				TableModel table_model = table_user.getModel();
				int selectedrow_index = table_user.getSelectedRow();
				
				String user_to_block;
				
				user_to_block = table_model.getValueAt(selectedrow_index, 0).toString();
				connection = SqliteConnection.dbConnector();
				//JOptionPane.showMessageDialog(null, user_to_block);
				try {
					String sql_query = "update userinfo set blocked ='1' where username='"+user_to_block+"' " ;
					PreparedStatement prep_state = connection.prepareStatement(sql_query);
					prep_state.execute();
					
					prep_state.close();
					
					String sql_query_1 = "Select * from UserInfo";
					PreparedStatement prep_state_1 = connection.prepareStatement(sql_query_1);
					ResultSet res_set = prep_state_1.executeQuery();
					table_user.setModel(DbUtils.resultSetToTableModel(res_set));
					
					prep_state_1.close();
					res_set.close();
				}catch(Exception ex) {
					//JOptionPane.showMessageDialog(null, "cannot set");
					ex.printStackTrace();
				}
				
				try {
					connection.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		

		BlockUserBtn.setBounds(79, 235, 89, 23);
		
		contentPane.add(BlockUserBtn);
		
		
		UnblockUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//unblock the user
				
				TableModel table_model = table_user.getModel();
				int selectedrow_index = table_user.getSelectedRow();
				
				String user_to_block;
				
				user_to_block = table_model.getValueAt(selectedrow_index, 0).toString();
				connection=SqliteConnection.dbConnector();
				//JOptionPane.showMessageDialog(null, user_to_block);
				try {
					String sql_query = "update userinfo set blocked ='0' where username='"+user_to_block+"' " ;
					PreparedStatement prep_state = connection.prepareStatement(sql_query);
					prep_state.execute();
					
					prep_state.close();
					
					String sql_query_1 = "Select * from UserInfo";
					PreparedStatement prep_state_1 = connection.prepareStatement(sql_query_1);
					ResultSet res_set = prep_state_1.executeQuery();
					table_user.setModel(DbUtils.resultSetToTableModel(res_set));
					
					prep_state_1.close();
					res_set.close();
				}catch(Exception ex) {
					//JOptionPane.showMessageDialog(null, "cannot set");
					ex.printStackTrace();
				}
				
				try {
					connection.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});

		UnblockUserBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		UnblockUserBtn.setBounds(210, 235, 103, 23);
		
		contentPane.add(UnblockUserBtn);
		
		
		ApproveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//approve request
				TableModel table_model = request_table.getModel();
				int selectedrow_index = request_table.getSelectedRow();
				
				String Request_to_Approve;
				
				Request_to_Approve = table_model.getValueAt(selectedrow_index, 2).toString();
				connection = SqliteConnection.dbConnector();
				//JOptionPane.showMessageDialog(null, Request_to_Approve);
				
				try {
					String sql_query = "update requestinfo set pending ='0' where username='"+Request_to_Approve+"' " ;
					PreparedStatement prep_state = connection.prepareStatement(sql_query);
					prep_state.execute();
					prep_state.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				try {
					connection.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		ApproveBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		ApproveBtn.setBounds(491, 235, 89, 23);
		try {
			connection.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		contentPane.add(ApproveBtn);
		DeclineBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Decline host
			}
		});
		DeclineBtn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		DeclineBtn.setBounds(621, 235, 89, 23);
		
		contentPane.add(DeclineBtn);
		UserTable.setBounds(10, 11, 460, 191);
		
		contentPane.add(UserTable);
		UserTable.setViewportView(table_user);
		scrollPane.setBounds(481, 11, 256, 191);
		
		contentPane.add(scrollPane);
		scrollPane.setViewportView(request_table);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView login_view = new LoginView();
				dispose();
				login_view.setVisible(true);	
			}
		});
		btnLogout.setBounds(381, 235, 89, 23);
		
		contentPane.add(btnLogout);
	}
}
