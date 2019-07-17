package jsoft.ads.individual;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Common.ConnectionPool;
import jsoft.ads.basic.BasicImpl;
import jsoft.ads.library.ListParentageWeb;
import jsoft.ads.object.IndividualObject;

public class IndividualImpl extends BasicImpl implements Individual {

	public IndividualImpl(ConnectionPool cp) {
		super(cp, "Individual");
	}

	public boolean isExist(IndividualObject item) {
		boolean flag = false;

		String sql = "SELECT individual_id FROM individual WHERE branch='" + item.getBranch() + "'";
		ResultSet rs = this.get(sql);
		if (rs != null) {
			try {
				if (rs.next()) {
					flag = true;
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return flag;
	}

	public boolean addIndividual(IndividualObject item) {
		if(isExist(item)) {
			return false;
		}
		String sql = "insert into individual (fullname,gender,date_of_birth,date_of_death "
				+ ",father,branch,parentage_id,avatar) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getFullname());
			pre.setInt(2, item.getGender());
			pre.setString(3, item.getDate_of_birth());
			pre.setString(4, item.getDate_of_death());
			pre.setInt(5, item.getFather());
			pre.setString(6, item.getBranch());
			pre.setInt(7, item.getParentage_id());
			pre.setString(8, item.getAvatar());
			return this.add(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addIndividualWeb(int n, int id) {
		ListParentageWeb view = new ListParentageWeb();
		String sql = "insert into individual (branch,fullname,parentage_id) values";
		sql += view.ViewIndividuals(n,id);
		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			return this.add(pre);
		} catch (SQLException e) {			  
			e.printStackTrace();
		}
		return false;
	}
	

	public boolean editIndividual(IndividualObject item) {
		String sql = "update individual set fullname=?,gender=?,date_of_birth=?,date_of_death=? "
				+ ",father=?,branch=?,parentage_id=?, avatar=? where individual_id=?";
		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getFullname());
			pre.setInt(2, item.getGender());
			pre.setString(3, item.getDate_of_birth());
			pre.setString(4, item.getDate_of_death());
			pre.setInt(5, item.getFather());
			pre.setString(6, item.getBranch());
			pre.setInt(7, item.getParentage_id());
			pre.setString(8, item.getAvatar());
			pre.setInt(9, item.getIndividual_id());
			
			return this.add(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean isExistBranch(IndividualObject item) {
		boolean flag = false;

		String sql = "SELECT individual_id FROM individual WHERE father ='" + item.getIndividual_id() + "'";
		ResultSet rs = this.get(sql);
		if (rs != null) {
			try {
				if (rs.next()) {
					flag = true;
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return flag;
	}
	public boolean delIndividual(IndividualObject item) {
		if(isExistBranch(item)) {
			return false;
		}
		String sql = "delete from individual where individual_id=?";
		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getIndividual_id());

			return this.del(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ResultSet getIndividuals(int id) {
		String sql = "select * from individual ";
		sql += "where parentage_id = " + id;
		sql += " order by branch";
		return this.get(sql);
	}
	public ResultSet getIndividualWebs(int id) {
		String sql = "select * from individual ";
		sql += "where parentage_id = " + id;		
		return this.get(sql);
	}

	public ResultSet getIndividuals(IndividualObject similar, int at, byte total) {
		String sql = "select * from individual ";
		sql += "where father="+similar.getFather();
		sql += " and parentage_id="+similar.getParentage_id();
		sql += " order by branch";
		sql += " Limit " + at + "," + total;
		return this.get(sql);
	}

	public ResultSet getIndividual(int id) {
		String sql = "select * from individual where individual_id=?";
		return this.get(sql, id);
	}

	public ResultSet getAncestor(int id) {
		String sql = "select * from individual where father=0 and parentage_id=?";
		return this.get(sql, id);
	}
	public ResultSet getLife(int prid) {
		String sql = "SELECT * FROM individual where parentage_id=? order by father desc limit 1 ";
		return this.get(sql, prid);
	}
}
