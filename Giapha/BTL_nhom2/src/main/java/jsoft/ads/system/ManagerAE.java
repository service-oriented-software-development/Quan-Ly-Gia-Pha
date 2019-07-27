package jsoft.ads.system;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.ConnectionPool;
import jsoft.ads.individual.IndividualControl;
import jsoft.ads.object.ParentageObject;
import jsoft.ads.parentage.ParentageControl;

/**
 * Servlet implementation class ManagerAE
 */
public class ManagerAE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagerAE() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		if (request.getParameter("id") != null && !request.getParameter("id").equalsIgnoreCase("")) {
			id = Integer.parseInt(request.getParameter("id"));
			ConnectionPool cp = (ConnectionPool)request.getServletContext().getAttribute("CPool");
			IndividualControl inc = new IndividualControl(cp);
			ParentageControl prc = new ParentageControl(cp);
			if(cp==null) {
				request.getServletContext().setAttribute("CPool", inc.getCP());
			}
			if(prc.addParentageWeb(id)&&inc.addIndividualWeb(id, prc.getParentageid())) {
				response.sendRedirect("/home/system/admin");
			}
		}
		
		
		String id1 = request.getParameter("prtid");
		if(id1!=null&&!id1.equalsIgnoreCase("")) {
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			ParentageControl pr = new ParentageControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("CPool", pr.getCP());
			}
			ParentageObject item = new ParentageObject();
			int prtid = Integer.parseInt(id1);
			item.setParentage_id(prtid);
			
			if(pr.delParentage(item)) {
				response.sendRedirect("/home/manager/parentage");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
