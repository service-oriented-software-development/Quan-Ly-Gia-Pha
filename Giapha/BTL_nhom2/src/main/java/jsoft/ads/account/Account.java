package jsoft.ads.account;

import java.sql.ResultSet;
import Common.ShareControl;
import jsoft.ads.object.AccountObject;

public interface Account extends ShareControl{
	public boolean addAccount(AccountObject item);
	public boolean editAccount(AccountObject item);
	public boolean delAccount(AccountObject item);
	
	public ResultSet getAccount(int id);
	public ResultSet getAccount(String Accountname, String Accountpass);
	public ResultSet getAccounts(AccountObject similar, int at, byte total);
}
