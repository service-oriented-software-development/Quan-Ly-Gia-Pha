package jsoft.ads.image;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Common.ConnectionPool;
import jsoft.ads.basic.BasicImpl;
import jsoft.ads.object.ImageObject;


public class ImageImpl extends BasicImpl implements Image {

	public ImageImpl(ConnectionPool cp) {
		super(cp, "Image");
	}

	public boolean addImage(ImageObject item) {
		
		String sql = "insert into Image (url,parentage_id) values(?,?)";
		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			pre.setString(1, item.getUrl());
			pre.setInt(2, item.getParentage_id());
			return this.add(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean delImage(ImageObject item) {
		
		String sql = "delete from Image where id=?";
		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			pre.setInt(1, item.getId());

			return this.del(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ResultSet getImage(int id) {
		String sql = "select * from Image ";
		sql += "where id = " + id;
		return this.get(sql);
	}

	public ResultSet getImages(ImageObject similar, int at, byte total) {
		String sql = "select * from Image ";
		sql += "where father="+similar.getParentage_id();
		sql += " Limit " + at + "," + total;
		return this.get(sql);
	}


}
