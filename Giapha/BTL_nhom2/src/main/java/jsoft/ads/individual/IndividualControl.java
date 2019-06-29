package jsoft.ads.individual;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Common.ConnectionPool;
import Common.ConnectionPoolImpl;
import jsoft.ads.object.IndividualObject;

public class IndividualControl {
	IndividualImpl us;

	public IndividualControl(ConnectionPool cp) {
		super();
		this.us = new IndividualImpl(cp);
	}

	public boolean addIndividual(IndividualObject item) {
		return this.us.addIndividual(item);
	}

	public boolean editIndividual(IndividualObject item) {

		return this.us.editIndividual(item);
	}

	public boolean delIndividual(IndividualObject item) {
		return this.us.delIndividual(item);
	}

	public IndividualObject getIndividual(int id) {
		ResultSet rs = this.us.getIndividual(id);
		IndividualObject item = new IndividualObject();
		if (rs != null) {
			try {
				if (rs.next()) {
					item.setIndividual_id(rs.getInt("Individual_id"));
					item.setParentage_id(rs.getInt("parentage_id"));
					item.setGender(rs.getInt("gender"));
					item.setFullname(rs.getString("fullname"));
					item.setFather(rs.getInt("father"));
					item.setDate_of_death(rs.getString("date_of_death"));
					item.setDate_of_birth(rs.getString("date_of_birth"));
					item.setBranch(rs.getString("branch"));
					item.setAvatar(rs.getString("avatar"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}

	public IndividualObject getAncestor(int prid) {
		ResultSet rs = this.us.getAncestor(prid);
		IndividualObject item = new IndividualObject();
		if (rs != null) {
			try {
				if (rs.next()) {
					
					item.setIndividual_id(rs.getInt("Individual_id"));
					item.setParentage_id(rs.getInt("parentage_id"));
					item.setGender(rs.getInt("gender"));
					item.setFullname(rs.getString("fullname"));
					item.setFather(rs.getInt("father"));
					item.setDate_of_death(rs.getString("date_of_death"));
					item.setDate_of_birth(rs.getString("date_of_birth"));
					item.setBranch(rs.getString("branch"));
					item.setAvatar(rs.getString("avatar"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}

	public ArrayList<IndividualObject> getIndividuals(int prid) {
		ResultSet rs = this.us.getIndividuals(prid);
		ArrayList<IndividualObject> items = new ArrayList<IndividualObject>();
		if (rs != null) {
			try {
				while (rs.next()) {
					IndividualObject item = new IndividualObject();
					item.setIndividual_id(rs.getInt("Individual_id"));
					item.setParentage_id(rs.getInt("parentage_id"));
					item.setGender(rs.getInt("gender"));
					item.setFullname(rs.getString("fullname"));
					item.setFather(rs.getInt("father"));
					item.setDate_of_death(rs.getString("date_of_death"));
					item.setDate_of_birth(rs.getString("date_of_birth"));
					item.setBranch(rs.getString("branch"));
					item.setAvatar(rs.getString("avatar"));
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return items;
	}

	public ArrayList<IndividualObject> getIndividuals(IndividualObject similar, int page, byte total) {
		int at = (page - 1) * total;
		ResultSet rs = this.us.getIndividuals(similar, at, total);
		ArrayList<IndividualObject> items = new ArrayList<IndividualObject>();
		if (rs != null) {
			try {
				while (rs.next()) {
					IndividualObject item = new IndividualObject();
					item.setIndividual_id(rs.getInt("Individual_id"));
					item.setParentage_id(rs.getInt("parentage_id"));
					item.setGender(rs.getInt("gender"));
					item.setFullname(rs.getString("fullname"));
					item.setFather(rs.getInt("father"));
					item.setDate_of_death(rs.getString("date_of_death"));
					item.setDate_of_birth(rs.getString("date_of_birth"));
					item.setBranch(rs.getString("branch"));
					item.setAvatar(rs.getString("avatar"));
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

	public String viewIndividual(ArrayList<IndividualObject> items) {
		int doi;		
		String tmp = "";
		tmp +="<div class=\"rcontent-item item3\" >";

		for (IndividualObject item : items) {
			doi = item.getBranch().split("\\.").length + 1;
									
			for(int i = 0; i < doi; i++) {
				tmp +="&nbsp;&nbsp;&nbsp;&nbsp;";
			}
			
		
			tmp +="<img align=\"absmiddle\" src=\"/adv/adimgs/plus4.gif\" style=\"padding: 0px; margin: 0px; width: 18px; height: 18px;\" id=\"img0\" onclick=\"img1()\">";
			tmp +="<img src=\"/adv/adimgs/m.jpg\" align=\"absmiddle\" style=\"width: 18px; height: 18px;\" id=\"img1\">";
			tmp +="<button class=\"tree\">"+ item.getFullname() +"</button>";
			tmp +="<button class=\"tree tree1\" onclick=\"openedit("+item.getIndividual_id()+")\"><img src=\"/adv/adimgs/pencil.png\" width=\"14px\" heigh=\"14px\"></button>";
			tmp +="<button class=\"tree tree1\" onclick=\"del("+item.getIndividual_id()+")\"><img src=\"/adv/adimgs/delete.png\" width=\"14px\" heigh=\"14px\"></button>";
			tmp +="</br>";
		}

		tmp +="</div>";
		return tmp;
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		IndividualControl id = new IndividualControl(cp);
		
		IndividualObject list = id.getIndividual(6);
		
		System.out.println(list.getBranch().split("\\.")[1]);
	}
}
