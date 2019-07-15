package jsoft.ads.account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Common.ConnectionPool;
import jsoft.ads.object.AccountObject;

public class AccountControl {
	AccountImpl us;

	public AccountControl(ConnectionPool cp) {
		super();
		this.us = new AccountImpl(cp);
	}
	public boolean addAccount(AccountObject item) {
		return this.us.addAccount(item);
	}

	public boolean editAccount(AccountObject item) {
		
		return this.us.editAccount(item);
	}

	public boolean delAccount(AccountObject item) {
		return this.us.delAccount(item);
	}

	public AccountObject getAccount(int id) {
		ResultSet rs = this.us.getAccount(id);
		AccountObject item = new AccountObject();
		if(rs!=null) {
			try {
				if(rs.next()) {
					item.setAccountname(rs.getString("account_name"));
					item.setAccountpass(rs.getString("password"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}

	public AccountObject getAccount(String Accountname, String Accountpass) {
		
		ResultSet rs = this.us.getAccount(Accountname, Accountpass);
		AccountObject item = new AccountObject();
		if(rs!=null) {
			try {
				if(rs.next()) {
					item.setAccountname(rs.getString("account_name"));
					item.setAccountpass(rs.getString("password"));
					item.setRole(rs.getInt("role"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}

	public ArrayList<AccountObject> getAccounts(AccountObject similar, int page, byte total) {
		int at = (page-1)*total;
		ResultSet rs = this.us.getAccounts(similar, at, total);
		ArrayList<AccountObject> items = new ArrayList<AccountObject>();
		if(rs!=null) {
			try {
				while(rs.next()) {
					AccountObject item = new AccountObject();
					item.setAccountname(rs.getString("account_name"));
					item.setAccountpass(rs.getString("password"));
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return items;
		
	}
	public ConnectionPool getCP() {	
		return this.us.getCP();
	}

	public void releaseConnection() {
		this.us.releaseConnection();
	}
}
