package jsoft.ads.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Common.ConnectionPool;
import Common.ConnectionPoolImpl;

public class BasicImpl implements Basic {
	private ConnectionPool cp;
	protected Connection con;
	private String objectName;

	public BasicImpl(ConnectionPool cp, String objectName) {
		if (cp == null) {
			
			this.cp = new ConnectionPoolImpl();
		} else {
			
			this.cp = cp;
		}
		this.objectName = objectName;

		try {
			this.con = this.cp.getConnection(objectName);

			if (con.getAutoCommit()) {
				con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private synchronized boolean exe(PreparedStatement pre) {
		if (pre != null) {
			try {
				int value = pre.executeUpdate();
				if (value == 0) {
					con.rollback();
					return false;
				}
				con.commit();
				return true;

			} catch (SQLException e) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean add(PreparedStatement pre) {
		return exe(pre);
	}

	public boolean edit(PreparedStatement pre) {
		return exe(pre);
	}

	public boolean del(PreparedStatement pre) {
		return exe(pre);
	}

	public ResultSet get(String sql, int value) {
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			if(value>0) {
				pre.setInt(1, value);
			}
			return pre.executeQuery();
		} catch (SQLException e) {
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}
	public ResultSet get(String sql, String value) {
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, value);
			return pre.executeQuery();
		} catch (SQLException e) {
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet get(String sql, String username, String userpass) {
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			
			pre.setString(1, username);
			pre.setString(2, userpass);
			
			return pre.executeQuery();
		} catch (SQLException e) {
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet[] gets(String[] sql) {
		ResultSet[] temp = new ResultSet[sql.length];
		for(int  i = 0; i < sql.length; i++) {
			temp[i] = this.get(sql[i], 0);
		}
		return temp;
	}

	public ConnectionPool getCP() {	
		return this.cp;
	}

	public void releaseConnection() {
		try {
			this.cp.releaseConnection(con, objectName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet get(String sql) {
		return this.get(sql, 0);
	}

}
