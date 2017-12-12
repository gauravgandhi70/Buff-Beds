package buffbeds;
import java.sql.*;
import javax.swing.*;

import javax.swing.JOptionPane;

public class SqliteConnection {
	
	Connection connection=null;
	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Sarang\\eclipse-workspace\\Buffbeds\\dbResources\\BuffBed.sqlite");
			return connection;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
