package jsoft.ads.image;

import java.sql.ResultSet;

import jsoft.ads.object.ImageObject;

public interface Image {
	public boolean addImage(ImageObject item);
	public boolean delImage(ImageObject item);
	
	public ResultSet getImage(int id);
	public ResultSet getImages(ImageObject similar, int at, byte total);
}
