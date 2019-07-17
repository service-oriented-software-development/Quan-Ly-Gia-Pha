package jsoft.ads.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Common.ConnectionPool;
import jsoft.ads.image.ImageControl;
import jsoft.ads.object.AccountObject;
import jsoft.ads.object.ImageObject;
import jsoft.ads.object.ParentageObject;
import jsoft.ads.parentage.ParentageControl;


public class album extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html;charset=UTF-8";
	
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public album() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
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
			ImageObject similar = new ImageObject();

			ParentageObject prO = pr.getParentage(ac.getAccountname());
			similar.setParentage_id(prO.getParentage_id());
			ImageControl imageControl = new ImageControl(cp);
			ArrayList<ImageObject> item = new ArrayList<ImageObject>();
			item = imageControl.getImages(similar, 1, (byte) 100);

			String tmp = imageControl.viewImage(item);

			pr.releaseConnection();

			out.print(tmp);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
