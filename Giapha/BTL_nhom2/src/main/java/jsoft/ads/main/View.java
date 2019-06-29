package jsoft.ads.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.ConnectionPool;
import jsoft.ads.account.AccountControl;
import jsoft.ads.library.HttpUtil;
import jsoft.ads.object.AccountObject;
import jsoft.ads.object.ParentageObject;

//@WebServlet("/view")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public View() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.removeAttribute("prt");
		response.setContentType(CONTENT_TYPE);
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equalsIgnoreCase("logout")) {
				request.getSession().removeAttribute("Loginned");
				request.getSession().removeAttribute("acname");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.include(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("Pool");
		AccountControl us = new AccountControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("Pool", us.getCP());
		}
		String accountname = request.getParameter("loginid");
		String accountpass = request.getParameter("pass");
		String data = request.getParameter("data");

		

		if (data != null) {
			System.out.println(data);
			if (!data.equalsIgnoreCase("undefined")) {
				HttpUtil util = new HttpUtil(data);
				AccountObject similar = util.toModel(AccountObject.class);
				ArrayList<AccountObject> b = us.getAccounts(similar, 1, (byte) 10);
				us.releaseConnection();

				if (b.size() > 0) {
					out.print("Account name has existed");
				} else {
					if (us.addAccount(similar)) {
						out.print("Regist Succesfull");
					} else {
						out.print("Regist failure");
					}
				}
			}

		} else {
			// Đăng nhập

			if (!accountname.equalsIgnoreCase("") && !accountpass.equalsIgnoreCase("")) {
				AccountObject b = us.getAccount(accountname, accountpass);

				us.releaseConnection();
				if (b.getAccountname() != null) {
					request.getSession().setAttribute("Loginned", b);
					request.getSession().setAttribute("acname", accountname);
					response.sendRedirect(request.getContextPath() + "/view");
					
				} else {
					response.sendRedirect(request.getContextPath() + "/view?err=notok");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/view?err=value");
			}
		}

	}

}
