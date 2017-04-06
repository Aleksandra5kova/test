package musala.schoolapp.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class LoadData {

	private static BufferedReader br = null;
	private static StringBuffer sb = new StringBuffer();
	private static String str = null;
	private static String[] commands = null;
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private static Connection connection = null;
	private static Statement statement = null;

	public static void loadData() {

		// read the queries from queries.sql
		try {
			br = new BufferedReader(new FileReader(new File("src\\main\\resources\\queries.sql")));
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			commands = sb.toString().split(";");
		} catch (FileNotFoundException e) {
			System.out.println("The file queries.sql is not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error while reading queries.sql");
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("BufferedReader is not initialized.");
					e.printStackTrace();
				}
			}
		}

		// read required properties from hibernate.properties to connect the database
		try {
			InputStream is = ClassLoader.getSystemResourceAsStream("hibernate.properties");
			Properties p = new Properties();
			p.load(is);
			driver = p.getProperty("hibernate.connection.driver");
			url = p.getProperty("hibernate.connection.url");
			user = p.getProperty("hibernate.connection.user");
			password = p.getProperty("hibernate.connection.password");
		} catch (Exception e) {
			System.out.println("Unable to read hibernate.properties.");
			e.printStackTrace();
		}

		// execute queries
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			for (int i = 0; i < commands.length; i++) {
				statement.executeUpdate(commands[i]);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Invalid driver name or class cannot be found.");
			e.printStackTrace();
		} catch (SQLException ex) {
			System.out.println("Unable to connect to the database.");
			System.out.println(ex.getErrorCode() + ":" + ex.getSQLState() + ":" + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("Connection can not be closed.");
				e.printStackTrace();
			}
		}

	}

}
