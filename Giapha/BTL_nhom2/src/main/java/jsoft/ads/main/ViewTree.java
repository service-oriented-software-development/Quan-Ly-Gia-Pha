package jsoft.ads.main;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.ConnectionPool;
import jsoft.ads.individual.IndividualControl;
import jsoft.ads.object.AccountObject;
import jsoft.ads.object.IndividualObject;
import jsoft.ads.object.ParentageObject;
import jsoft.ads.parentage.ParentageControl;
import net.htmlparser.jericho.CharacterReference;

/**
 * Servlet implementation class ViewDetail
 */
public class ViewTree extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html;charset=UTF-8";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTree() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		// System.out.println("ngu");
		AccountObject ac = (AccountObject) request.getSession().getAttribute("Loginned");
		if (ac == null) {
			response.sendRedirect(request.getContextPath() + "/view");
		} else {

			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			ParentageControl pr = new ParentageControl(cp);
			IndividualControl indc = new IndividualControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("CPool", pr.getCP());
			}		
			ParentageObject prO = pr.getParentage(ac.getAccountname());
			IndividualObject indo = indc.getLife(prO.getParentage_id());
			prO.setAccount_name(ac.getAccountname());
			request.setAttribute("prt", prO);
			request.setAttribute("prname", CharacterReference.decode(prO.getParentage_name()));
			request.setAttribute("pracname", CharacterReference.decode(prO.getAccount_name()));
			request.setAttribute("prancestor", CharacterReference.decode(prO.getAncestor()));
			request.setAttribute("prhead", CharacterReference.decode(prO.getHead_of_parentage_name()));
			request.setAttribute("prheadadr", CharacterReference.decode(prO.getHead_of_parentage_address()));
			request.setAttribute("prhistory", CharacterReference.decode(prO.getHistory_of_parentage()));
			request.setAttribute("pradr", CharacterReference.decode(prO.getAddress()));
			request.setAttribute("prlife", indo.getBranch().split("\\.").length);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/familytree.jsp");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
