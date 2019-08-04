package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;
import Common.ConnectionPool;

public class ConnectionPoolImpl implements ConnectionPool {
	private String url;
	private String driver;
	private String username;
	private String userpass;
	private Stack<Connection> pool;
	
	
	
	public ConnectionPoolImpl() {
		this.driver = "com.mysql.jdbc.Driver";
		this.getDriver();
		
		this.url = "jdbc:mysql://103.104.117.157:2083/giaphavi_data";
		this.username = "giaphavi_user";
		this.userpass = "VgDUB9Oc+*EM";
		
		//this.url = "jdbc:mysql://localhost:3306/genealogy_management";
		//this.username = "root";
		//this.userpass = "123";
		//this.userpass = "1234";
		
		this.pool = new Stack<Connection>();
	}
	
	public void getDriver() {
		try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection(String objectName) throws SQLException {
		if(!pool.isEmpty()) {
			System.out.println(objectName+" has popped connection");
			return pool.pop();
		}else {
			System.out.println(objectName+" has created connection");
			return DriverManager.getConnection(url, username, userpass);
		}
	}

	public void releaseConnection(Connection con, String objectName) throws SQLException {
		if(con!=null) {
			System.out.println(objectName+" has pushed connection");
			pool.push(con);
		}
	}

	protected void finalize()throws Throwable{
		pool.clear();
		pool = null;
		System.gc();
		System.runFinalization();
		
		System.out.println("CP has stopped");
	}
}
