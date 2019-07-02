package jsoft.ads.image;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Common.ConnectionPool;
import Common.ConnectionPoolImpl;

import jsoft.ads.object.ImageObject;

public class ImageControl {
	private ImageImpl us;

	

	public ImageControl(ConnectionPool cp) {
		super();
		this.us = new ImageImpl(cp);
	}



	public boolean addImage(ImageObject item) {
		return this.us.addImage(item);
	}

	

	public boolean delImage(ImageObject item) {
		return this.us.delImage(item);
	}

	public ImageObject getImage(int id) {
		ResultSet rs = this.us.getImage(id);
		ImageObject item = new ImageObject();
		if (rs != null) {
			try {
				if (rs.next()) {
					item.setId(rs.getInt("id"));
					item.setParentage_id(rs.getInt("parentage_id"));
					item.setUrl(rs.getString("url"));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}


	public ImageObject getImages(int id) {
		ResultSet rs = this.us.getImage(id);
		ImageObject item = new ImageObject();
		if (rs != null) {
			try {
				if (rs.next()) {
					
					item.setId(rs.getInt("id"));
					item.setParentage_id(rs.getInt("parentage_id"));
					item.setUrl(rs.getString("url"));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}

	public ArrayList<ImageObject> getImages(ImageObject similar, int page, byte total) {
		int at = (page - 1) * total;
		ResultSet rs = this.us.getImages(similar, at, total);
		ArrayList<ImageObject> items = new ArrayList<ImageObject>();
		if (rs != null) {
			try {
				while (rs.next()) {
					ImageObject item = new ImageObject();
					item.setId(rs.getInt("id"));
					item.setParentage_id(rs.getInt("parentage_id"));
					item.setUrl(rs.getString("url"));
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

	public String viewImage(ArrayList<ImageObject> items) {		
		String tmp = "";
		tmp+="<div>";
		for (ImageObject item : items) {
			
			tmp +="<img src=\"/adv/adimgs/"+item.getUrl()+"\" align=\"absmiddle\" id=\"img1\"/>";
		}
		tmp+="</div>";
		return tmp;
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		ImageControl id = new ImageControl(cp);
		
		ImageObject list = id.getImage(6);
		
		System.out.println(list.getUrl());
	}
}
