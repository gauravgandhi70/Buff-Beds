package buffbeds;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class HostView extends JFrame {

	private JPanel contentPane;
	private final JTextField textEmail = new JTextField();
	private final JLabel lblEmail = new JLabel("Email:");
	private final JLabel lblHostName = new JLabel("Host Name:");
	private final JTextField textHostName = new JTextField();
	private final JLabel lblAddress = new JLabel("Address:");
	private final JTextField textAddress = new JTextField();
	private final JTextField textCapacity = new JTextField();
	private final JLabel lblCapacity = new JLabel("Capacity:");
	private final JTextField textPrice = new JTextField();
	private final JLabel lblNewLabel = new JLabel("Price:");
	private final JTable current_info_table = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblEditData = new JLabel("Edit Data:");
	private final JButton btnUpdate = new JButton("Update");
	private final JButton btnLogout = new JButton("Logout");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HostView frame = new HostView("David");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String username;
	Connection connection = null;
	String old_Hostname="",old_Address="", old_Email="", old_capacity="",old_price="",pending="";
	/**
	 * Create the frame.
	 */
	public HostView(String name) {
		username = name;
		textEmail.setBounds(235, 89, 188, 20);
		textEmail.setColumns(10);
		
		initGUI();
	}
	private void initGUI() {
		connection = SqliteConnection.dbConnector();
		try {
			String sql_query_5 = "Select * from requestInfo";
			PreparedStatement prep_state_5 = connection.prepareStatement(sql_query_5);
			ResultSet res_set_5 = prep_state_5.executeQuery();
			
			if(res_set_5 != null) {
			String request_pending = res_set_5.getString("Pending");
			String hostname=res_set_5.getString("Username");
			String Change = res_set_5.getString("Change");
			if(request_pending.equals("0")) {
				JOptionPane.showMessageDialog(null, "Request Approved");
				
				try {
					String sql_query_3 = "update hotelinfo set Address=? where hostname='"+hostname+"' " ;
					PreparedStatement prep_state_3 = connection.prepareStatement(sql_query_3);
					prep_state_3.setString(1, Change);
					prep_state_3.execute();
					prep_state_3.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				try {
					String sql_query_1 = "update requestinfo set pending ='1' where username='"+hostname+"' " ;
					PreparedStatement prep_state_1 = connection.prepareStatement(sql_query_1);
					prep_state_1.execute();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				try {
					String sql_query_2 = "update hotelinfo set pendingchange ='0' where hostname='"+hostname+"' " ;
					PreparedStatement prep_state_2 = connection.prepareStatement(sql_query_2);
					prep_state_2.execute();
					prep_state_2.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				prep_state_5.close();
			}
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		try {
			connection.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		connection = SqliteConnection.dbConnector();
		try{
			String sql_query = "Select * from HotelInfo where Hostname='"+username+"' ";
			PreparedStatement prep_state = connection.prepareStatement(sql_query);
			ResultSet res_set = prep_state.executeQuery();
			old_Hostname = res_set.getString("Hostname");
			old_Address = res_set.getString("Address");
			old_Email = res_set.getString("Email");
			old_capacity = res_set.getString("Capacity");
			old_price = res_set.getString("Price");
			pending = res_set.getString("PendingChange");
			textHostName.setText(res_set.getString("Hostname"));
			textAddress.setText(res_set.getString("Address"));
			textEmail.setText(res_set.getString("Email"));
			textCapacity.setText(res_set.getString("Capacity"));
			textPrice.setText(res_set.getString("Price"));
			current_info_table.setModel(DbUtils.resultSetToTableModel(res_set));
			prep_state.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		try {
			connection.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		setTitle("Buffbeds-Host View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(textEmail);
		lblEmail.setBounds(170, 92, 46, 14);
		
		contentPane.add(lblEmail);
		lblHostName.setBounds(170, 67, 70, 14);
		
		contentPane.add(lblHostName);
		textHostName.setColumns(10);
		textHostName.setBounds(235, 64, 188, 20);
		
		contentPane.add(textHostName);
		lblAddress.setBounds(170, 123, 46, 14);
		
		contentPane.add(lblAddress);
		textAddress.setColumns(10);
		textAddress.setBounds(235, 120, 188, 20);
		
		contentPane.add(textAddress);
		textCapacity.setColumns(10);
		textCapacity.setBounds(235, 151, 188, 20);
		
		contentPane.add(textCapacity);
		lblCapacity.setBounds(170, 154, 46, 14);
		
		contentPane.add(lblCapacity);
		textPrice.setColumns(10);
		textPrice.setBounds(235, 182, 188, 20);
		
		contentPane.add(textPrice);
		lblNewLabel.setBounds(170, 185, 46, 14);
		
		contentPane.add(lblNewLabel);
		scrollPane.setBounds(10, 220, 658, 122);
		
		contentPane.add(scrollPane);
		scrollPane.setViewportView(current_info_table);
		lblEditData.setBounds(114, 52, 58, 14);
		
		contentPane.add(lblEditData);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, old_Hostname);
				connection = SqliteConnection.dbConnector();
					if((textHostName.getText().equals(old_Hostname) == false)) {
						try {
							String sql_query = "insert into RequestInfo (Change,Pending,username) values (?,?,?)";
							PreparedStatement prep_state = connection.prepareStatement(sql_query);
							prep_state.setString(1, textHostName.getText());
							prep_state.setString(2, "1");
							prep_state.setString(3, old_Hostname);
							prep_state.execute();
							
							String sql_query_1 = "update hotelinfo set pendingchange ='1' where hostname='"+old_Hostname+"' " ;
							PreparedStatement prep_state_1 = connection.prepareStatement(sql_query_1);
							prep_state_1.execute();
						}catch(Exception ex) {
							ex.printStackTrace();
						}
					}
					else if((textAddress.getText().equals(old_Address))== false) {
						try {
							String sql_query = "insert into RequestInfo (Change,Pending,username) values (?,?,?)";
							PreparedStatement prep_state = connection.prepareStatement(sql_query);
							prep_state.setString(1, textAddress.getText());
							prep_state.setString(2, "1");
							prep_state.setString(3, old_Hostname);
							prep_state.execute();
							
							String sql_query_1 = "update hotelinfo set pendingchange ='1' where hostname='"+old_Hostname+"' " ;
							PreparedStatement prep_state_1 = connection.prepareStatement(sql_query_1);
							prep_state_1.execute();
						}catch(Exception ex) {
							ex.printStackTrace();
						}
					}
					else if((textEmail.getText().equals(old_Email))==false) {
						try {
							String sql_query = "insert into RequestInfo (Change,Pending,username) values (?,?,?)";
							PreparedStatement prep_state = connection.prepareStatement(sql_query);
							prep_state.setString(1, textEmail.getText());
							prep_state.setString(2, "1");
							prep_state.setString(3, old_Hostname);
							prep_state.execute();
							
							String sql_query_1 = "update hotelinfo set pendingchange ='1' where hostname='"+old_Hostname+"' " ;
							PreparedStatement prep_state_1 = connection.prepareStatement(sql_query_1);
							prep_state_1.execute();
						}catch(Exception ex) {
							ex.printStackTrace();
						}
					}
					try {
						connection.close();
					}catch(Exception ex) {
						ex.printStackTrace();
					}
			}
			
		});

		btnUpdate.setBounds(495, 181, 89, 23);
		
		contentPane.add(btnUpdate);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginView login_view = new LoginView();
				dispose();
				try {
					connection.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				login_view.setVisible(true);				
			}
		});
		btnLogout.setBounds(567, 11, 89, 23);
		
		contentPane.add(btnLogout);
	}

}
