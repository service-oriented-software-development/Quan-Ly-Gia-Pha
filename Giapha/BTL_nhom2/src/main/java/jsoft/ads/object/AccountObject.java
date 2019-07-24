package jsoft.ads.object;

public class AccountObject {
	private String Accountname;
	private String Accountpass;
	private int role;
	private String Accountpassn;
	public String getAccountpassn() {
		return Accountpassn;
	}
	public void setAccountpassn(String accountpassn) {
		Accountpassn = accountpassn;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getAccountname() {
		return Accountname;
	}
	public void setAccountname(String Accountname) {
		this.Accountname = Accountname;
	}
	public String getAccountpass() {
		return Accountpass;
	}
	public void setAccountpass(String Accountpass) {
		this.Accountpass = Accountpass;
	}
	
}
