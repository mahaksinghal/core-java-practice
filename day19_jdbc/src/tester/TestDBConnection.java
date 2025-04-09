package tester;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDBConnection {

	public static void main(String[] args) {
		try {
			// open db connection
			String dBURL = "jdbc:mysql://localhost:3306/dac2025";
			Connection cn = DriverManager.getConnection(dBURL, "root", "Mahak@2809");
			System.out.println("cn established.......");
			cn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
