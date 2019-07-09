package jsoft.ads.parentage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import Common.ConnectionPool;
import jsoft.ads.object.AccountObject;
import jsoft.ads.object.ParentageObject;

//@WebServlet("/parentage/view")
public class ParentageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParentageView() {
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
		PrintWriter out = response.getWriter();
		ParentageObject similar = null;
		List<ParentageObject> pro;
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		ParentageControl pr = new ParentageControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("CPool", pr.getCP());
		}
		String search = request.getParameter("info");
		
		if(search!=null && !search.equalsIgnoreCase("")) {
			similar = new ParentageObject();
			similar.setParentage_name(search);
			
		}
		pro = pr.getParentages(similar, 1, (byte)10);
		request.setAttribute("a", pro);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/vnparentage.jsp");
		rd.forward(request, response);
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
