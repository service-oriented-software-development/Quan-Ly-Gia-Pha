package jsoft.ads.parentage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Common.ConnectionPool;
import jsoft.ads.basic.BasicImpl;
import jsoft.ads.object.ParentageObject;

public class ParentageImpl extends BasicImpl implements Parentage {

	public ParentageImpl(ConnectionPool cp) {
		super(cp, "Parentage");
		// TODO Auto-generated constructor stub
	}

	public boolean addParentage(ParentageObject item) {
		String sql = "insert into parentage(parentage_name,head_of_parentage_name,address\r\n" + 
				",cultural_spring_day, cultural_autumn_day, head_of_parentage_number,\r\n" + 
				"head_of_parentage_email, head_of_parentage_address, ancestor,\r\n" + 
				"history_of_parentage, convention_of_parentage, cult_portion_land,\r\n" + 
				"account_name) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getParentage_name());
			pre.setString(2, item.getHead_of_parentage_name());
			pre.setString(3, item.getAddress());
			pre.setString(4, item.getCultural_spring_day());
			pre.setString(5, item.getCultural_autumn_day());
			pre.setString(6, item.getHead_of_parentage_number());
			pre.setString(7, item.getHead_of_parentage_email());
			pre.setString(8, item.getHead_of_parentage_address());
			pre.setString(9, item.getAncestor());
			pre.setString(10, item.getHistory_of_parentage());
			pre.setString(11, item.getConvention_of_parentage());
			pre.setString(12, item.getCult_portion_land());
			pre.setString(13, item.getAccount_name());
			return this.add(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean editParentage(ParentageObject item) {
		String sql = "update parentage set parentage_name=?,head_of_parentage_name=?,address=?\r\n" + 
				",cultural_spring_day=?, cultural_autumn_day=?, head_of_parentage_number=?,\r\n" + 
				"head_of_parentage_email=?, head_of_parentage_address=?, ancestor=?,\r\n" + 
				"history_of_parentage=?, convention_of_parentage=?, cult_portion_land=?,\r\n" + 
				"account_name=? where parentage_id=?";
		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getParentage_name());
			pre.setString(2, item.getHead_of_parentage_name());
			pre.setString(3, item.getAddress());
			pre.setString(4, item.getCultural_spring_day());
			pre.setString(5, item.getCultural_autumn_day());
			pre.setString(6, item.getHead_of_parentage_number());
			pre.setString(7, item.getHead_of_parentage_email());
			pre.setString(8, item.getHead_of_parentage_address());
			pre.setString(9, item.getAncestor());
			pre.setString(10, item.getHistory_of_parentage());
			pre.setString(11, item.getConvention_of_parentage());
			pre.setString(12, item.getCult_portion_land());
			pre.setString(13, item.getAccount_name());
			
			pre.setInt(14, item.getParentage_id());
			return this.edit(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean delParentage(ParentageObject item) {
		String sql = "delete parentage where Parentage_id=?";
		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getParentage_id());

			return this.del(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	public ResultSet getParentage(int id) {
		String sql = "select * from parentage where parentage_id=?";
		return this.get(sql, id);
	}
	public ResultSet getParentage(String value) {
		String sql = "select * from parentage where account_name=?";
		return this.get(sql, value);
	}

	public ResultSet getParentages() {
		String sql = "select * from parentage ";
		return this.get(sql);
	}

	public ResultSet getParentages(ParentageObject similar, int at, byte total) {
		String sql = "select * from parentage ";
		if(similar!=null) {
			String s = similar.getParentage_name();
			sql += "where parentage_name like '%"+s+"%' or address like '%"+s+"%'";
		}
		sql += " Limit " + at + "," + total;
		return this.get(sql);
	}

}
