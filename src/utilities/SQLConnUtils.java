package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnUtils {

	public static Connection getSQLConnection() throws ClassNotFoundException, SQLException {

		String server = "DAIENKAIENTEI";
		int port = 1433;
		String dbuser = "Grammateia";
		String dbpassword = "Pass";
		String database = "Grammateia";

		return getSQLConnection(server, port, dbuser, dbpassword, database);
	}

	public static Connection getSQLConnection(String server, int port, String dbuser, String dbpassword, String database)
			throws SQLException, ClassNotFoundException {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("# - Driver Loaded");

		String jdbcUrl = "jdbc:sqlserver://" + server + ":" + port + ";user=" + dbuser + ";password=" + dbpassword
				+ ";databaseName=" + database + "";

		Connection con = DriverManager.getConnection(jdbcUrl);
		System.out.println("# - Connection Obtained");

		return con;
	}
}
