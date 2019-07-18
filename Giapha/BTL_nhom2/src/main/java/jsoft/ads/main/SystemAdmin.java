package jsoft.ads.main;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsoft.ads.library.ListParentageWeb;
import jsoft.ads.object.AccountObject;

public class SystemAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html;charset=UTF-8";

	public SystemAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccountObject ac = (AccountObject) request.getSession().getAttribute("Loginned");
		if (ac == null) {
			response.sendRedirect(request.getContextPath() + "/view");
		} else {

			ListParentageWeb view = new ListParentageWeb();
			int n = 0;
			if (request.getParameter("src") != null && !request.getParameter("src").equalsIgnoreCase("")) {
				n = Integer.parseInt(request.getParameter("src"));
			} else {
				n = 10;
			}
			String listprt = view.ViewParentages(n);
			request.setAttribute("prts", listprt);
			request.setAttribute("src", n + 10);
			RequestDispatcher rd = request.getRequestDispatcher("/views/sys-admin/index.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
