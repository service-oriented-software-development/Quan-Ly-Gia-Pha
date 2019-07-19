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

	public boolean addIndividualWeb(int i, int id) {
		return this.us.addIndividualWeb(i, id);
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

	public IndividualObject getLife(int prid) {
		ResultSet rs = this.us.getLife(prid);
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
	
	public ArrayList<IndividualObject> getIndividualWebs(int prid) {
		ResultSet rs = this.us.getIndividualWebs(prid);
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

	public String viewIndividual(ArrayList<IndividualObject> items, boolean b, int life) {
		int doi, doi1;
		String tmp = "";
		tmp += "<div class=\"rcontent-item item3\" >";
		if (b) {
			tmp += "<h1>Từ đời 1 - Đến đời " + life + "</h1>";
		}
		for (IndividualObject item : items) {
			doi = item.getBranch().split("\\.").length + 1;
			if(item.getBranch().split("\\.").length==1 && item.getFather()==0) {
				doi1 = 0;
			}else {
				doi1 = Integer.parseInt(item.getBranch().split("\\.")[0]);
			}
			
			
			if (b) {
				if (life + 1 < doi) {
					continue;
				}
			}
			if (item.getFather()>0) {
				for (int i = 0; i < doi; i++) {
					tmp += "&nbsp;&nbsp;&nbsp;&nbsp;";
				}
				tmp += "<img align=\"absmiddle\" src=\"/home/adimgs/plus4.gif\" style=\"padding: 0px; margin: 0px; width: 18px; height: 18px;\" id=\"img0\" onclick=\"img1()\">";
				tmp += "<img src=\"/home/adimgs/m.jpg\" align=\"absmiddle\" style=\"width: 18px; height: 18px;\" id=\"img1\">";
				tmp += "<button class=\"tree\">" + item.getFullname() + "</button>";
			} else {
				for (int i = 0; i < doi1; i++) {
					tmp += "&nbsp;&nbsp;&nbsp;&nbsp;";
				}
				tmp += "<img align=\"absmiddle\" src=\"/home/adimgs/plus4.gif\" style=\"padding: 0px; margin: 0px; width: 18px; height: 18px;\" id=\"img0\" onclick=\"img1()\">";
				tmp += "<img src=\"/home/adimgs/m.jpg\" align=\"absmiddle\" style=\"width: 18px; height: 18px;\" id=\"img1\">";
				tmp += "<button class=\"tree\">" + item.getFullname() + "</button>";
			}

			if (b) {
				tmp += "<button class=\"tree tree1\" onclick=\"openedit(" + item.getIndividual_id()
						+ ")\"><img src=\"/home/adimgs/pencil.png\" width=\"14px\" heigh=\"14px\"></button>";
				tmp += "<button class=\"tree tree1\" onclick=\"del(" + item.getIndividual_id()
						+ ")\"><img src=\"/home/adimgs/delete.png\" width=\"14px\" heigh=\"14px\"></button>";
			}
			tmp += "</br>";
		}

		tmp += "</div>";
		return tmp;
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		IndividualControl id = new IndividualControl(cp);

		IndividualObject list = id.getIndividual(6);

		System.out.println(list.getBranch().split("\\.")[1]);
	}
}
