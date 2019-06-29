package jsoft.ads.parentage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String name = request.getParameter("name");
		ArrayList<ParentageObject> pro;
		
		if(name!=null&&!name.equalsIgnoreCase("undifined")) {
			similar = new ParentageObject();
			similar.setParentage_name(name);
		}		
		
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		ParentageControl pr = new ParentageControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("CPool", pr.getCP());
		}
		
		pro = pr.getParentages(similar, 1, (byte)10);		
		
		
		AccountObject ac = (AccountObject) request.getSession().getAttribute("Loginned");
		ParentageObject pro1 =null;
		if(ac != null) {
		 pro1 = pr.getParentage(ac.getAccountname());
		}
		pr.releaseConnection();

		if (ac != null) {
			if (pro1 != null && pro1.getAccount_name()!=null) {
				out.print("<div class=\"row\">");
				out.print("<div class=\"col-sm-12 col-lg-6\">");
				out.print("<div class=\"card h-100 bg-primary\">");
				out.print("<div class=\"card-body\">");
				out.print(
						"<h4 class=\"card-title\"><img src=\"adimgs/favicon-32x32.png\" alt=\"vietnamgiapha\">Bạn đang quản lý: Gia phả ["+pro1.getParentage_name()+"]</h4>");
				out.print(
						"<p class=\"card-text\">ở tại "+pro1.getHead_of_parentage_address()+", ngày cập nhật cuối cùng "+(java.time.LocalDate.now())+" <a class=\"btn btn-sm pull-right btn-warning\" target=\"_blank\" href=\"/XemGiaPha/11191/giapha.html\">Xem chi tiết</a> <a class=\"btn btn-sm pull-right btn-warning\" "
						+ "href=\"http://localhost:8080/adv/parentage/ae\">Chỉnh sửa</a>");
				out.print("</p>");
				out.print(
						"<div class=\"fb-share-button fb_iframe_widget\" data-href=\"/XemGiaPha/11191/giapha.html\" data-layout=\"button_count\" fb-xfbml-state=\"rendered\" fb-iframe-plugin-query=\"app_id=801465833345912&amp;container_width=603&amp;href=http%3A%2F%2Fvietnamgiapha.com%2FXemGiaPha%2F11191%2Fgiapha.html&amp;layout=button_count&amp;locale=en_US&amp;sdk=joey\">");
				out.print("<span style=\"vertical-align: bottom; width: 69px; height: 20px;\">");
				out.print(
						"<iframe name=\"f3f056d2faa46c4\" width=\"1000px\" height=\"1000px\" frameborder=\"0\" allowtransparency=\"true\" allowfullscreen=\"true\" scrolling=\"no\" allow=\"encrypted-media\" title=\"fb:share_button Facebook Social Plugin\" src=\"https://www.facebook.com/v3.2/plugins/share_button.php?app_id=801465833345912&amp;channel=https%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_arbiter.php%3Fversion%3D44%23cb%3Df222be60f2b54b%26domain%3Dvietnamgiapha.com%26origin%3Dhttp%253A%252F%252Fvietnamgiapha.com%252Ff37cdb516563f08%26relation%3Dparent.parent&amp;container_width=603&amp;href=http%3A%2F%2Fvietnamgiapha.com%2FXemGiaPha%2F11191%2Fgiapha.html&amp;layout=button_count&amp;locale=en_US&amp;sdk=joey\" style=\"border: none; visibility: visible; width: 69px; height: 20px;\" class=\"\">");
				out.print("</iframe>");
				out.print("</span>");
				out.print("</div>");
				out.print("<p></p>");
				out.print("</div>");
				out.print("</div>");
				out.print("</div>");
				out.print("</div>");
			} else {
				out.print("<div class=\"alert alert-warning\" role=\"alert\">");
				out.print("<p>Hiện tại bạn chưa có gia phả</p>");
				out.print("<p>Nếu muốn tạo mới gia phả");
				out.print(
						"<a class=\"btn btn-sm btn-success\" href=\"http://localhost:8080/adv/parentage/ae\">Tạo mới tại đây</a></p>");
				out.print("</div>");
			}
		}
		// gp admin
		out.print(pr.viewParentage(pro));

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
