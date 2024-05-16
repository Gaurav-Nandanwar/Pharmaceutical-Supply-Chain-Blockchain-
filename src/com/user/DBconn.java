package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconn {

	public static String filepath = "C:\\Users\\ASUS\\Downloads\\Medicine_Product_Application_BL\\QR_Code";
	//public static String newfilepath = "G:/ME2023-2024/AmitSir/Product_Blockchain/QR_Code";
//	public static String outputfilepath = "G:/ME2023-2024/AmitSir/Product_Blockchain/QR_Code/output/";

	public static Connection conn() throws ClassNotFoundException, SQLException {
		Connection con;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/fake_product_bl", "root",
				"1234");

		return con;
	}

	public static int productcheck(String productno) {
		int msg = 0;
		Connection con;
		try {
			con = DBconn.conn();

			Statement st = (Statement) con.createStatement();
			ResultSet rs;
			String str = "select * from product_info where Product_No='"
					+ productno + "'";
			rs = ((java.sql.Statement) st).executeQuery(str);
			if (rs.next()) {
				msg=2;
			} else {
				msg=1;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	public static void main(String args[]) {

	}
}
