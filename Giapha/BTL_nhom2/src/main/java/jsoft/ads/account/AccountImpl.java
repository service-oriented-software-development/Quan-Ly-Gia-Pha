package jsoft.ads.account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Common.ConnectionPool;
import jsoft.ads.basic.BasicImpl;
import jsoft.ads.object.AccountObject;

public class AccountImpl extends BasicImpl implements Account {

	public AccountImpl(ConnectionPool cp) {
		super(cp, "Account");
		// TODO Auto-generated constructor stub
	}

	public boolean addAccount(AccountObject item) {
		String sql = "insert into account values(?,?,?)";
		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getAccountname());
			pre.setString(2, item.getAccountpass());
			pre.setInt(3, item.getRole());
			return this.add(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean editAccount(AccountObject item) {
		String sql = "update account set password = md5(?) where account_name = ?";
		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getAccountpassn());
			pre.setString(2, item.getAccountname());
			
			return this.edit(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delAccount(AccountObject item) {
		String sql = "delete account where account_name=?";
		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getAccountname());
			
			return this.del(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public ResultSet getAccount(int id) {
		String sql = "select * from account";
		return this.get(sql);
	}

	public ResultSet getAccount(String Accountname, String Accountpass) {
		String sql = "select * from account where ";
		sql += "account_name = ? and password=?";
		
		return this.get(sql, Accountname, Accountpass);
	}

	public ResultSet getAccounts(AccountObject similar, int at, byte total) {
		String sql = "select * from account ";
		sql+=" where account_name='"+similar.getAccountname()+"'";
		sql+=" Limit " + at +"," + total;
		return this.get(sql);
	}

}
