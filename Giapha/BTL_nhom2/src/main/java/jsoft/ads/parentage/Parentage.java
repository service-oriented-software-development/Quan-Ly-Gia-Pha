package jsoft.ads.parentage;

import java.sql.ResultSet;

import jsoft.ads.object.ParentageObject;

public interface Parentage {
	public boolean addParentage(ParentageObject item);
	public boolean editParentage(ParentageObject item);
	public boolean delParentage(ParentageObject item);
	
	public ResultSet getParentage(int id);
	public ResultSet getParentages();
	public ResultSet getParentages(ParentageObject similar, int at, byte total);
}
