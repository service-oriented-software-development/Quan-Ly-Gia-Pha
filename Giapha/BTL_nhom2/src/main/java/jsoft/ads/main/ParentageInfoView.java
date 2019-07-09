package jsoft.ads.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.ConnectionPool;
import jsoft.ads.image.ImageControl;
import jsoft.ads.individual.IndividualControl;
import jsoft.ads.object.ImageObject;
import jsoft.ads.object.IndividualObject;
import jsoft.ads.object.ParentageObject;
import jsoft.ads.parentage.ParentageControl;
import net.htmlparser.jericho.CharacterReference;

public class ParentageInfoView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ParentageInfoView() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		ParentageControl pr = new ParentageControl(cp);
		IndividualControl indc = new IndividualControl(cp);
		ImageControl imgc = new ImageControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("CPool", pr.getCP());
		}
		int prtid = Integer.parseInt(request.getParameter("prtid"));
		ParentageObject prO = pr.getParentage(prtid);
		ArrayList<IndividualObject> items = indc.getIndividuals(prO.getParentage_id());
		ArrayList<ImageObject> imgs = imgc.getImages(prtid);
		ArrayList<IndividualObject> inds = indc.getIndividuals(prtid);
		String fmtree = indc.viewIndividual(inds);
		pr.releaseConnection();
		
		request.setAttribute("prt", prO);
		request.setAttribute("list_imgs", imgs);
		request.setAttribute("fmtree", fmtree);
		request.setAttribute("prname", CharacterReference.decode(prO.getParentage_name()));
		request.setAttribute("pracname", CharacterReference.decode(prO.getAccount_name()));
		request.setAttribute("prancestor", CharacterReference.decode(prO.getAncestor()));
		request.setAttribute("prhead", CharacterReference.decode(prO.getHead_of_parentage_name()));
		request.setAttribute("prheadadr", CharacterReference.decode(prO.getHead_of_parentage_address()));
		request.setAttribute("prhistory", CharacterReference.decode(prO.getHistory_of_parentage()));
		request.setAttribute("pradr", CharacterReference.decode(prO.getAddress()));
		request.setAttribute("premail", prO.getHead_of_parentage_email());
		request.setAttribute("prnumber", prO.getHead_of_parentage_number());
		request.setAttribute("prnumber_individual", items.size());
		request.setAttribute("pradvise", CharacterReference.decode(prO.getConvention_of_parentage()));
		request.setAttribute("pradvertisment", CharacterReference.decode(prO.getCult_portion_land()));
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/parentageinfo.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
