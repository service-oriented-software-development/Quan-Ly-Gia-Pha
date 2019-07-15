package jsoft.ads.system;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.ConnectionPool;
import jsoft.ads.individual.IndividualControl;
import jsoft.ads.parentage.ParentageControl;

/**
 * Servlet implementation class ManagerAE
 */
public class ManagerAE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerAE() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		if (request.getParameter("id") != null && !request.getParameter("id").equalsIgnoreCase("")) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		ConnectionPool cp = (ConnectionPool)request.getServletContext().getAttribute("CPool");
		IndividualControl inc = new IndividualControl(cp);
		ParentageControl prc = new ParentageControl(cp);
		if(cp==null) {
			request.getServletContext().setAttribute("CPool", inc.getCP());
		}
		prc.addParentageWeb(id);
		inc.addIndividualWeb(id, 4);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
