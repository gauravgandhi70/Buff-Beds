package buffbeds;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;

public class UserView extends JFrame {

	private JPanel contentPane;
	private final JTextField textCapacity = new JTextField();
	private final JTextField textMinPrice = new JTextField();
	private final JTextField textField_2 = new JTextField();
	private final JTextField textMaxPrice = new JTextField();
	private final JButton btnSearch = new JButton("Book");
	private final JButton btnNewButton = new JButton("Search");
	private final JLabel lblPriceRange = new JLabel("Price Range:");
	private final JLabel lblTo = new JLabel("to");
	private final JLabel lblPeople = new JLabel("People:");
	private final JLabel lblRating = new JLabel("Rating:");
	private final JTable table = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table_search = new JTable();
	private final JScrollPane scrollPane_1 = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserView frame = new UserView("Sarang");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private final JLabel lblCurrentBooking = new JLabel("Current Booking:");
	private final JLabel lblSearchResults = new JLabel("Search Results:");
	private final JButton btnCancelBooking = new JButton("Cancel Booking");
	String user_name;
	private final JButton btnLogout = new JButton("Logout");

	/**
	 * Create the frame.
	 */
	public UserView(String name) {
		user_name = name;
		textMaxPrice.setBounds(284, 52, 86, 20);
		textMaxPrice.setColumns(10);
		textField_2.setBounds(165, 114, 86, 20);
		textField_2.setColumns(10);
		textMinPrice.setBounds(165, 52, 86, 20);
		textMinPrice.setColumns(10);
		textCapacity.setBounds(165, 83, 86, 20);
		textCapacity.setColumns(10);
		connection = SqliteConnection.dbConnector();
		initGUI();
	}
	private void initGUI() {
		
		try {
			String sql_query = "Select * from BookingInfo";
			PreparedStatement prep_state = connection.prepareStatement(sql_query);
			ResultSet res_set = prep_state.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(res_set));
			prep_state.close();
			res_set.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		try {
			String sql_query = "Select * from userInfo where username='"+user_name+"'";
			PreparedStatement prep_state = connection.prepareStatement(sql_query);
			ResultSet res_set = prep_state.executeQuery();
			if(res_set.getString("Blocked").equals("1")) {
				JOptionPane.showMessageDialog(null, "you are blocked please contact admin");
				LoginView login = new LoginView();
				dispose();
				setVisible(false);
				prep_state.close();
				login.setVisible(true);
				return;
			}
			
			prep_state.close();
			res_set.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		setTitle("Buffbeds-Customer View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(textCapacity);
		
		contentPane.add(textMinPrice);
		
		contentPane.add(textField_2);
		
		contentPane.add(textMaxPrice);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//do something to book
				TableModel table_model = table_search.getModel();
				int selectedrow_index = table_search.getSelectedRow();
				
				String Hostname,Email,Address,Capacity,Price;
				
				Hostname = table_model.getValueAt(selectedrow_index, 0).toString();
				Email = table_model.getValueAt(selectedrow_index, 1).toString();
				Address = table_model.getValueAt(selectedrow_index, 2).toString();
				Capacity = table_model.getValueAt(selectedrow_index, 3).toString();
				Price = table_model.getValueAt(selectedrow_index, 4).toString();
				
				//JOptionPane.showMessageDialog(null, Hostname);
				
				try {
					String sql_query = "insert into BookingInfo (Hostname,Email,Address,Capacity,Price) values(?,?,?,?,?) " ;
					PreparedStatement prep_state = connection.prepareStatement(sql_query);
					prep_state.setString(1, Hostname);
					prep_state.setString(2, Email);
					prep_state.setString(3, Address);
					prep_state.setString(4, Capacity);
					prep_state.setString(5, Price);
					prep_state.execute();
					
					prep_state.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				UserCheckout cb = new UserCheckout(user_name);
				dispose();
				try {
				connection.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				cb.setVisible(true);
			}
		});
		btnSearch.setBounds(445, 134, 89, 23);
		
		contentPane.add(btnSearch);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//do something for search
				String max_price = textMaxPrice.getText();
				String min_price = textMinPrice.getText();
				
				try {
					String sql_query = "Select * from HotelInfo where price between '"+min_price+"' and '"+max_price+"' ";
					PreparedStatement prep_state = connection.prepareStatement(sql_query);
					ResultSet res_set = prep_state.executeQuery();
					table_search.setModel(DbUtils.resultSetToTableModel(res_set));
					prep_state.close();
					res_set.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
	
				
			}
		});
		btnNewButton.setBounds(329, 134, 89, 23);
		
		contentPane.add(btnNewButton);
		lblPriceRange.setBounds(81, 55, 74, 14);
		
		contentPane.add(lblPriceRange);
		lblTo.setBounds(261, 55, 21, 14);
		
		contentPane.add(lblTo);
		lblPeople.setBounds(109, 86, 46, 14);
		
		contentPane.add(lblPeople);
		lblRating.setBounds(109, 117, 46, 14);
		
		contentPane.add(lblRating);
		scrollPane.setBounds(20, 192, 350, 96);
		
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		scrollPane_1.setBounds(381, 192, 336, 96);
		
		contentPane.add(scrollPane_1);
		scrollPane_1.setViewportView(table_search);
		lblCurrentBooking.setBounds(21, 167, 102, 14);
		
		contentPane.add(lblCurrentBooking);
		lblSearchResults.setBounds(384, 167, 102, 14);
		
		contentPane.add(lblSearchResults);
		btnCancelBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(new DefaultTableModel());
				try {
					String sql_query = "delete from bookingInfo";
					PreparedStatement prep_state = connection.prepareStatement(sql_query);
					prep_state.execute();
					prep_state.close();
				}catch(Exception ex) {
					
				}
			}
		});
		btnCancelBooking.setBounds(544, 134, 129, 23);
		
		contentPane.add(btnCancelBooking);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView login_view = new LoginView();
				dispose();
				login_view.setVisible(true);
			}
		});
		btnLogout.setBounds(584, 11, 89, 23);
		
		contentPane.add(btnLogout);
	}
}
