package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
//	public static Connection con=null;
//	private String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLiThuoc";
//	private String userName = "sa";
//	private String password = "123456";
//	public static ConnectDB instance = new ConnectDB();
//	
//	public static Connection getConnection() {
//		return con;
//	}
//
//	public static ConnectDB getInstance() {
//		return instance;
//	}
//	
//	public ConnectDB() {
//		// TODO Auto-generated constructor stub
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			try {
//				con = (Connection) DriverManager.getConnection(url, userName, password);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("ket noi that bai 2");
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("ket noi that bai!");
//		}
//		
//	}
//}

	public static Connection con =null;
	public static ConnectDB instance = new ConnectDB();
	
	
	public static Connection getConnection() {
		return con;
	}

	public static ConnectDB getInstance() {
		return instance;
	}

	public void connect() throws SQLException{
			String url = "jdbc:sqlserver://localhost:1434;databasename=QuanLiLuong";
			String user = "sa";
			String pwd = "sa";
			con = DriverManager.getConnection(url,user,pwd);
	}
	
	public void disconnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	
}
