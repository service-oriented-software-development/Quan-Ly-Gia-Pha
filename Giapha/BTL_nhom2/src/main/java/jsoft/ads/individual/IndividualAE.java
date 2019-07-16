package jsoft.ads.individual;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Common.ConnectionPool;
import jsoft.ads.library.HttpUtil;
import jsoft.ads.object.AccountObject;
import jsoft.ads.object.IndividualObject;
import jsoft.ads.object.ParentageObject;
import jsoft.ads.parentage.ParentageControl;
import net.htmlparser.jericho.CharacterReference;

@MultipartConfig
//@WebServlet("individual/ae")
public class IndividualAE extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html;charset=UTF-8";
	private static final String UPLOAD_DIR = "adimgs";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndividualAE() {
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
		// System.out.println("ngu");
		AccountObject ac = (AccountObject) request.getSession().getAttribute("Loginned");
		if (ac == null) {
			response.sendRedirect(request.getContextPath() + "/view");
		} else {

			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
			ParentageControl pr = new ParentageControl(cp);
			IndividualControl ind = new IndividualControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("CPool", pr.getCP());
			}
			ParentageObject prO = pr.getParentage(ac.getAccountname());
			prO.setAccount_name(ac.getAccountname());

			// thông tin dòng họ
			request.setAttribute("prt", prO);
			request.setAttribute("prname", CharacterReference.decode(prO.getParentage_name()));
			request.setAttribute("pracname", CharacterReference.decode(prO.getAccount_name()));
			request.setAttribute("prancestor", CharacterReference.decode(prO.getAncestor()));
			request.setAttribute("prhead", CharacterReference.decode(prO.getHead_of_parentage_name()));
			request.setAttribute("prheadadr", CharacterReference.decode(prO.getHead_of_parentage_address()));
			request.setAttribute("prhistory", CharacterReference.decode(prO.getHistory_of_parentage()));
			request.setAttribute("pradr", CharacterReference.decode(prO.getAddress()));

			// thông tin thành viên		
			int id = Integer.parseInt(request.getParameter("id"));
			String img = request.getParameter("img");
			String imgchild = request.getParameter("imgchild");
			IndividualObject indo = ind.getIndividual(id);
			String fm = CharacterReference.decode(indo.getFullname());
			if (fm.indexOf('&') > -1) {
				request.setAttribute("indname", fm.split("&")[0]);
				request.setAttribute("indpartnername", fm.split("&")[1]);
			} else {
				System.out.println(fm);
				request.setAttribute("indname", fm);
			}
			
			request.setAttribute("indid", id);
			request.setAttribute("indbirth", indo.getDate_of_birth());
			request.setAttribute("inddeath", indo.getDate_of_death());
			request.setAttribute("indsex", indo.getGender());
			request.setAttribute("indfather", indo.getFather());
			request.setAttribute("indbranch", indo.getBranch());
			request.setAttribute("indprid", indo.getParentage_id());
			request.setAttribute("indorder", indo.getBranch().split("\\.").length);
			
			if(img!=null) {
				if(!img.equalsIgnoreCase("")&&!img.equalsIgnoreCase("undefied")) {					
					request.setAttribute("indavatar", img);
				}
			}else {
				if (indo.getAvatar() != null) {
					if (!indo.getAvatar().equalsIgnoreCase("")) {
						request.setAttribute("indavatar", indo.getAvatar());			
					}
				} else {
					request.setAttribute("indavatar", "default.png");
				}
			}
			
			

			// thông tin thành viên thêm
			ArrayList<IndividualObject> bro = ind.getIndividuals(indo, 1, (byte) 100);
			String tmp = "";
			int i = 1;
			for (IndividualObject item : bro) {
				String fn = CharacterReference.decode(item.getFullname());
				if (fn.indexOf('&') > -1) {
					tmp += (i++) + ":" + fn.split("&")[0] + "; ";
				} else {
					tmp += (i++) + ":" + fn + "; ";
				}

			}
			IndividualObject parent;
			if (indo.getFather() != 0) {
				parent = ind.getIndividual(indo.getFather());
			} else {
				parent = new IndividualObject();
				parent.setFullname("Thủy tổ");
			}
			IndividualObject child = new IndividualObject();
			child.setFather(indo.getIndividual_id());
			child.setParentage_id(indo.getParentage_id());
			ArrayList<IndividualObject> childs = ind.getIndividuals(child, 1, (byte) 100);
			String tmp1 = "";
			
			for (IndividualObject item : childs) {

				String fn = CharacterReference.decode(item.getFullname());
				if (fn.indexOf('&') > -1) {
					tmp1 += item.getBranch().charAt(item.getBranch().length()-1) + ":" + fn.split("&")[0] + "; ";
				} else {
					tmp1 += item.getBranch().charAt(item.getBranch().length()-1) + ":" + fn + "; ";
				}
			}

			request.setAttribute("parent", CharacterReference.decode(parent.getFullname()));
			request.setAttribute("bro", CharacterReference.decode(tmp));
			request.setAttribute("child", CharacterReference.decode(tmp1));
			
			
			
			
			///ảnh
			if (imgchild != null) {
				if (!imgchild.equalsIgnoreCase("")&&!imgchild.equalsIgnoreCase("undefied")) {
					
					request.setAttribute("childavatar", imgchild);			
				}
			} else {
				request.setAttribute("childavatar", "default.png");
			}
			

			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/edittree.jsp");
			rd.include(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		String act = request.getParameter("action");
		String id = request.getParameter("id");
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		ParentageControl pr = new ParentageControl(cp);
		IndividualControl ind = new IndividualControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("CPool", pr.getCP());
		}
		
		if(act!=null) {
			if (!act.equalsIgnoreCase("del") && !act.equalsIgnoreCase("undefied")) { // ThÃªm & Sá»­a
				String data = request.getParameter("data");
				HttpUtil util = new HttpUtil(data);
				IndividualObject inds = util.toModel(IndividualObject.class);
				IndividualObject indv = ind.getIndividual(Integer.parseInt(id));
				inds.setFullname(CharacterReference.encode(inds.getFullname()));
				File apath = new File(inds.getAvatar());
				inds.setAvatar(apath.getName());				
				if (act.equalsIgnoreCase("edit")) { // sua
					inds.setIndividual_id(Integer.parseInt(id));
					if (inds.getDate_of_birth() == "") {
						inds.setDate_of_birth(null);
					}
					if (inds.getDate_of_death() == "") {
						inds.setDate_of_death(null);
					}
					
					if (ind.editIndividual(inds)) {
						out.println("Update Successfully.");
		 				if(indv.getAvatar()!=null && !indv.getAvatar().equalsIgnoreCase("default.png")) {
							String source = request.getServletContext().getRealPath("")+File.separator+ UPLOAD_DIR + File.separator+indv.getAvatar();
							File file = new File(source);
							file.delete();
						}

					} else {
						out.println("Update Failure.");
					}
				} else if (act.equalsIgnoreCase("add")) { // them
					if (inds.getDate_of_birth() == "") {
						inds.setDate_of_birth(null);
					}
					if (inds.getDate_of_death() == "") {
						inds.setDate_of_death(null);
					}
					if (ind.addIndividual(inds)) {
						out.println("Add Successfully.");
					} else {
						System.out.print("fuck");
						out.println("Add Failure, dupplicate number of indivisual!");
					}
				}
			} else if (act.equalsIgnoreCase("del"))     { // xoa
				IndividualObject indd = new IndividualObject();
				indd.setIndividual_id(Integer.parseInt(id));
				if (ind.delIndividual(indd)) {
					out.println("Delete Successfully");
				} else {
					
					out.println("Delete Failure! Still has branchs");
				}

			}
			
		}else {
			String fileimg = uploadFile(request);
			if(request.getParameter("addchild")!=null) {
				request.setAttribute("childavatar", fileimg);
				response.sendRedirect(request.getContextPath()+"/individual/ae?id="+id+"&imgchild="+fileimg); //chá»�n áº£nh
			}else {
				request.setAttribute("indavatar", fileimg);
				response.sendRedirect(request.getContextPath()+"/individual/ae?id="+id+"&img="+fileimg); //chá»�n áº£nh
			}
			
		}
		ind.releaseConnection();

	}

	private String uploadFile(HttpServletRequest request) throws IOException, ServletException {
		
		String fileName = "";
		try {
			Part filePart = null;
			if(request.getParameter("addchild")!=null) {
				if(request.getParameter("addchild").equalsIgnoreCase("1"))
				filePart = request.getPart("real");
			}else {
				filePart = request.getPart("real1");
			}
			//Part filePart = request.getPart("real1");
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
