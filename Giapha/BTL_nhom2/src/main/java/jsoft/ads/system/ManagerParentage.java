package jsoft.ads.system;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.ConnectionPool;
import jsoft.ads.object.AccountObject;
import jsoft.ads.object.ParentageObject;
import jsoft.ads.parentage.ParentageControl;

/**
 * Servlet implementation class ManagerParentage
 */
public class ManagerParentage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerParentage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountObject ac = (AccountObject) request.getSession().getAttribute("Loginned");
		if (ac == null || ac.getRole()<=1) {
			response.sendRedirect(request.getContextPath() + "/view");
		} else {
			ParentageObject similar = null;
			List<ParentageObject> pro;
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			ParentageControl pr = new ParentageControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("CPool", pr.getCP());
			}
			String search = request.getParameter("info");

			similar = new ParentageObject();
			similar.setParentage_name(search);

			pro = pr.getParentageWeb(ac.getAccountname());

			request.setAttribute("a", pro);

			RequestDispatcher rd = request.getRequestDispatcher("/views/sys-admin/listparentage.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
