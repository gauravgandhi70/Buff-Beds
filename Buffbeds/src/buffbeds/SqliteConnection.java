package buffbeds;
import java.sql.*;
import java.swing.*;

import javax.swing.JOptionPane;

public class SqliteConnection {
	
	Connection connection=null;
	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\akshi\\Desktop\\Buff-Beds\\BuffBed.sqlite");
			JOptionPane.showMessageDialog(null, "Connection Successful");
			return connection;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
