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

@MultipartConfig
public class album extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html;charset=UTF-8";
	private static final String UPLOAD_DIR = "adimgs";
	

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
			similar.setParentage_id(1);
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
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		AccountObject ac = (AccountObject) request.getSession().getAttribute("Loginned");
		if (ac == null) {
			response.sendRedirect(request.getContextPath() + "/view");
		}
		ImageControl imgcrt = new ImageControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("CPool", imgcrt.getCP());
		}

		
		ImageObject item = new ImageObject();
		String fileimg = uploadFile(request);
		item.setUrl(fileimg);
		item.setParentage_id(1);
		if(imgcrt.addImage(item)) {
			response.sendRedirect(request.getContextPath() + "/image/view");
		}
		imgcrt.releaseConnection();
	}
private String uploadFile(HttpServletRequest request) throws IOException, ServletException {
		
		String fileName = "";
		try {
			Part filePart = request.getPart("img-format");
			fileName = (String) getFileName(filePart);
			String applicationPath = request.getServletContext().getRealPath("");
			String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;
			InputStream inputStream = null;
			OutputStream outputStream = null;
			try {
				File outputFilePath = new File(basePath + fileName);
				inputStream = filePart.getInputStream();
				outputStream = new FileOutputStream(outputFilePath);
				int read = 0;
				final byte[] bytes = new byte[1024];
				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
			} catch (Exception e) {
				e.printStackTrace();
				fileName = "";
			} finally {
				if (inputStream != null) {
					inputStream.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
			}

		} catch (Exception e) {
			fileName = "";
		}
		
		return fileName;
	}

	private String getFileName(Part part) {
		final String partHeader = part.getHeader("content-disposition");
		System.out.println("*****partHeader :" + partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}

		return null;
	}

}
