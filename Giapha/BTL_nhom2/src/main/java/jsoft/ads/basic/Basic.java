package jsoft.ads.basic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Common.ShareControl;

public interface Basic extends ShareControl{
	public boolean add(PreparedStatement pre);
	public boolean edit(PreparedStatement pre);
	public boolean del(PreparedStatement pre);
	
	public ResultSet get(String sql, int value);
	public ResultSet get(String sql, String username, String userpass);
	public ResultSet get(String sql);
	public ResultSet[] gets(String sql[]);
}
