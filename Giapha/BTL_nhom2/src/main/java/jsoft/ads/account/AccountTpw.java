package jsoft.ads.account;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.ConnectionPool;
import jsoft.ads.individual.IndividualControl;
import jsoft.ads.object.AccountObject;
import jsoft.ads.object.ParentageObject;
import jsoft.ads.parentage.ParentageControl;

/**
 * Servlet implementation class AccountTpw
 */
public class AccountTpw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountTpw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/tpw.jsp");
			rd.forward(request, response);
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
