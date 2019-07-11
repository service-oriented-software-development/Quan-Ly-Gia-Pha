package jsoft.ads.individual;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.ConnectionPool;
import jsoft.ads.object.AccountObject;
import jsoft.ads.object.IndividualObject;
import jsoft.ads.object.ParentageObject;
import jsoft.ads.parentage.ParentageControl;

//@WebServlet(urlPatterns = { "/individual/view" })
public class IndividualView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndividualView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		AccountObject ac = (AccountObject) request.getSession().getAttribute("Loginned");
		if (ac == null) {
			response.sendRedirect(request.getContextPath() + "/view");
		} else {

			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			ParentageControl pr = new ParentageControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("CPool", pr.getCP());
			}
			ParentageObject prO = pr.getParentage(ac.getAccountname());

			int life = Integer.parseInt(request.getParameter("life"));
			if(prO.getParentage_id()>0) {
				IndividualControl fs = new IndividualControl(cp);
				ArrayList<IndividualObject> items = fs.getIndividuals(prO.getParentage_id());

				fs.releaseConnection();

				out.print(fs.viewIndividual(items,true,life));
			}
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
