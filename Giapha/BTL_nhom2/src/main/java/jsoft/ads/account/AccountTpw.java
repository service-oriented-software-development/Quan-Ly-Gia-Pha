package jsoft.ads.account;

import java.io.IOException;
import java.io.PrintWriter;

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
	private static final String CONTENT_TYPE = "text/html;charset=UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountTpw() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setContentType(CONTENT_TYPE);
		response.setCharacterEncoding("UTF-8");
		String password = request.getParameter("password");
		String new_password = request.getParameter("new_password");
		String confirm_password = request.getParameter("confirm_password");

		
		AccountObject ac = (AccountObject) request.getSession().getAttribute("Loginned");
		if (ac.getAccountname() == null) {
			response.sendRedirect("/home");
		} else {
			
			if (password != null && new_password != null && confirm_password != null) {
				
				if (!password.equalsIgnoreCase("") && !new_password.equalsIgnoreCase("")
						&& !confirm_password.equalsIgnoreCase("")) {
					ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
					AccountObject ao = new AccountObject();
					ao.setAccountname(ac.getAccountname());
					ao.setAccountpass(new_password);
					ao.setRole(1);
					AccountControl acc = new AccountControl(cp);
					if (cp == null) {
						getServletContext().setAttribute("CPool", acc.getCP());
					}
					System.out.println(ac.getAccountpass()+"  ------"+password);
					if (ac.getAccountpass().equalsIgnoreCase(password)) {
						
						if (confirm_password.equalsIgnoreCase(new_password)) {
							
							if (acc.editAccount(ao)) {
								response.sendRedirect("/home/account/tpw?ok");
							}
						}
					}else {
						response.sendRedirect("/home/account/tpw?err=notok");
					}
				}else {
					response.sendRedirect("/home/account/tpw?err=param");
				}
			} else {
				response.sendRedirect("/home/account/tpw?err=value");
			}
		}

	}

}
