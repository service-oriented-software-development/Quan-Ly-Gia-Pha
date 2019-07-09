package jsoft.ads.parentage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Common.ConnectionPool;
import jsoft.ads.individual.IndividualControl;
import jsoft.ads.object.IndividualObject;
import jsoft.ads.object.ParentageObject;

public class ParentageControl {
	ParentageImpl us;
	IndividualControl indc;
	public ParentageControl(ConnectionPool cp) {
		super();
		this.us = new ParentageImpl(cp);
		this.indc = new IndividualControl(cp);
	}

	public boolean addParentage(ParentageObject item) {
		return this.us.addParentage(item);
	}

	public boolean editParentage(ParentageObject item) {

		return this.us.editParentage(item);
	}

	public boolean delParentage(ParentageObject item) {
		return this.us.delParentage(item);
	}

	public ParentageObject getParentage(int id) {
		ResultSet rs = this.us.getParentage(id);
		ParentageObject item = new ParentageObject();
		if (rs != null) {
			try {
				if (rs.next()) {
					item.setParentage_id(rs.getInt("parentage_id"));
					item.setParentage_name(rs.getString("Parentage_name"));
					item.setHead_of_parentage_name(rs.getString("Head_of_parentage_name"));
					item.setAddress(rs.getString("Address"));
					item.setCultural_spring_day(rs.getString("Cultural_spring_day"));
					item.setCultural_autumn_day(rs.getString("Cultural_autumn_day"));
					item.setHead_of_parentage_number(rs.getString("Head_of_parentage_number"));
					item.setHead_of_parentage_email(rs.getString("Head_of_parentage_email"));
					item.setHead_of_parentage_address(rs.getString("Head_of_parentage_address"));
					item.setAncestor(rs.getString("Ancestor"));
					item.setHistory_of_parentage(rs.getString("History_of_parentage"));
					item.setConvention_of_parentage(rs.getString("Convention_of_parentage"));
					item.setCult_portion_land(rs.getString("Cult_portion_land"));
					item.setAccount_name(rs.getString("Account_name"));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}

	public ParentageObject getParentage(String acName) {
		ResultSet rs = this.us.getParentage(acName);
		ParentageObject item = new ParentageObject();
		if (rs != null) {
			try {
				if (rs.next()) {
					item.setParentage_id(rs.getInt("parentage_id"));
					item.setParentage_name(rs.getString("Parentage_name"));
					item.setHead_of_parentage_name(rs.getString("Head_of_parentage_name"));
					item.setAddress(rs.getString("Address"));
					item.setCultural_spring_day(rs.getString("Cultural_spring_day"));
					item.setCultural_autumn_day(rs.getString("Cultural_autumn_day"));
					item.setHead_of_parentage_number(rs.getString("Head_of_parentage_number"));
					item.setHead_of_parentage_email(rs.getString("Head_of_parentage_email"));
					item.setHead_of_parentage_address(rs.getString("Head_of_parentage_address"));
					item.setAncestor(rs.getString("Ancestor"));
					item.setHistory_of_parentage(rs.getString("History_of_parentage"));
					item.setConvention_of_parentage(rs.getString("Convention_of_parentage"));
					item.setCult_portion_land(rs.getString("Cult_portion_land"));
					item.setAccount_name(rs.getString("Account_name"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return item;
	}

	public ArrayList<ParentageObject> getParentages() {
		ResultSet rs = this.us.getParentages();
		ArrayList<ParentageObject> items = new ArrayList<ParentageObject>();
		if (rs != null) {
			try {
				while (rs.next()) {
					ParentageObject item = new ParentageObject();
					item.setParentage_id(rs.getInt("parentage_id"));
					item.setParentage_name(rs.getString("Parentage_name"));
					item.setHead_of_parentage_name(rs.getString("Head_of_parentage_name"));
					item.setAddress(rs.getString("Address"));
					item.setCultural_spring_day(rs.getString("Cultural_spring_day"));
					item.setCultural_autumn_day(rs.getString("Cultural_autumn_day"));
					item.setHead_of_parentage_number(rs.getString("Head_of_parentage_number"));
					item.setHead_of_parentage_email(rs.getString("Head_of_parentage_email"));
					item.setHead_of_parentage_address(rs.getString("Head_of_parentage_address"));
					item.setAncestor(rs.getString("Ancestor"));
					item.setHistory_of_parentage(rs.getString("History_of_parentage"));
					item.setConvention_of_parentage(rs.getString("Convention_of_parentage"));
					item.setCult_portion_land(rs.getString("Cult_portion_land"));
					item.setAccount_name(rs.getString("Account_name"));
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return items;
	}

	public ArrayList<ParentageObject> getParentages(ParentageObject similar, int page, byte total) {
		int at = (page - 1) * total;
		ResultSet rs = this.us.getParentages(similar, at, total);
		ArrayList<ParentageObject> items = new ArrayList<ParentageObject>();
		if (rs != null) {
			try {
				while (rs.next()) {
					ArrayList<IndividualObject> it = indc.getIndividuals(rs.getInt("parentage_id"));
					ParentageObject item = new ParentageObject();
					item.setParentage_id(rs.getInt("parentage_id"));
					item.setParentage_name(rs.getString("Parentage_name"));
					item.setHead_of_parentage_name(rs.getString("Head_of_parentage_name"));
					item.setAddress(rs.getString("Address"));
					item.setCultural_spring_day(rs.getString("Cultural_spring_day"));
					item.setCultural_autumn_day(rs.getString("Cultural_autumn_day"));
					item.setHead_of_parentage_number(rs.getString("Head_of_parentage_number"));
					item.setHead_of_parentage_email(rs.getString("Head_of_parentage_email"));
					item.setHead_of_parentage_address(rs.getString("Head_of_parentage_address"));
					item.setAncestor(rs.getString("Ancestor"));
					item.setHistory_of_parentage(rs.getString("History_of_parentage"));
					item.setConvention_of_parentage(rs.getString("Convention_of_parentage"));
					item.setCult_portion_land(it.size()+"");
					item.setAccount_name(rs.getString("Account_name"));
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

	public String viewParentage(ArrayList<ParentageObject> items) {

		String tmp = "";
		
		for (ParentageObject item : items) {
			ArrayList<IndividualObject> it = indc.getIndividuals(item.getParentage_id());
			tmp += "<tr>";
			tmp += "<td>1</td>";
			tmp += "<td><a href=\"default.aspx?cp=dongho&amp;id=28220\">"+item.getParentage_name()+"</a></td>";
			tmp += "<td>"+item.getHead_of_parentage_address()+"</td>";
			tmp += "<td>"+item.getAncestor()+"</td>";
			tmp += "<td>"+it.size()+"</td>";
			tmp += "</tr>";
		}
		return tmp;
	}
}
