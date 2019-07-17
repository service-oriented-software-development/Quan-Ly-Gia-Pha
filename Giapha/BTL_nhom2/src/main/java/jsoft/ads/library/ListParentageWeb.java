package jsoft.ads.library;

import java.io.IOException;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.htmlparser.jericho.CharacterReference;

public class ListParentageWeb {
	public String ViewParentages(int n) {
		String tmp = "";
		Document doc = null;
		int k;
		if(n>10) {
			k=n-10;
		}else {
			k=1;
		}
		for (int i=k; i <= n; i++) {
			String url = "http://vietnamgiapha.com/XemPhaHe/" + i + "/pha_he.html";
			try {
				doc = Jsoup.connect(url).get();
			}catch (NullPointerException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    } catch (HttpStatusException e) {
		         if (e.getStatusCode() == 500)
		             continue;
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
			if (doc != null) {
				Element title = doc.select("font[color=red]").first();

				if (title != null) {
					tmp += "<li style=\"float:left; height:80px; width:270px\">";
					tmp += title.ownText();
					tmp += "<div><a href=\"/adv/manager/ae?id="+i+"\" id=\"btn_save\" style=\"color:blue\"></br><i>Lưu lại</i></a></div>";
					tmp += "</li>";
					tmp += "\n";
				}
			}
		}
		return tmp;
	}

	public String ViewIndividuals(int n, int id) {
		String tmp = "";
		Document doc = null;
		String url = "http://vietnamgiapha.com/XemPhaHe/" + n + "/pha_he.html";
		try {
			doc = Jsoup.connect(url).get();
		}catch (NullPointerException e) {	      
	        e.printStackTrace();
	    } catch (HttpStatusException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		Elements elm = doc.select("a[href]");

		for (int i = 0; i < elm.size(); i++) {
			if (elm.get(i).ownText().split("\\.").length == 2) {
				tmp += "('" + elm.get(i).ownText().split(" ")[0]+"','"+CharacterReference.encode(elm.get(i).ownText().replaceAll(elm.get(i).ownText().split(" ")[0], ""))+"', "+id+")";
				if(i==elm.size()-2) {
					tmp+=";";
				}else {
					tmp+=",";
				}
			}						
		}
		
		
		return tmp;
	}
	
	public String ParentageQuery(int n) {
		String tmp = "";
		Document doc = null;
		String url = "http://vietnamgiapha.com/XemPhaHe/" + n + "/pha_he.html";
		try {
			doc = Jsoup.connect(url).get();
		}catch (NullPointerException e) {	      
	        e.printStackTrace();
	    } catch (HttpStatusException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		Element title = doc.select("font[color=red]").first();
		tmp+="('"+CharacterReference.encode(title.ownText())+"','systemadmin')";
		
		return tmp;
	}

	public static void main(String[] args) {
		ListParentageWeb view = new ListParentageWeb();
		System.out.println(view.ViewIndividuals(8,1));
	}

}
