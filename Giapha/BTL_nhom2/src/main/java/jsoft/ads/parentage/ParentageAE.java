package jsoft.ads.parentage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.ConnectionPool;
import jsoft.ads.individual.IndividualControl;
import jsoft.ads.library.HttpUtil;
import jsoft.ads.object.AccountObject;
import jsoft.ads.object.IndividualObject;
import jsoft.ads.object.ParentageObject;
import net.htmlparser.jericho.*;

/**
 * Servlet implementation class ParentageAE
 */
public class ParentageAE extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html;charset=UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParentageAE() {
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
			IndividualControl indc = new IndividualControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("CPool", pr.getCP());
			}
			ParentageObject prO = pr.getParentage(ac.getAccountname());
			ArrayList<IndividualObject> items = indc.getIndividuals(prO.getParentage_id());
			
			pr.releaseConnection();
			
			prO.setAccount_name(ac.getAccountname());
			request.setAttribute("prt", prO);
			request.setAttribute("prname", CharacterReference.decode(prO.getParentage_name()));
			request.setAttribute("pracname", CharacterReference.decode(prO.getAccount_name()));
			request.setAttribute("prancestor", CharacterReference.decode(prO.getAncestor()));
			request.setAttribute("prhead", CharacterReference.decode(prO.getHead_of_parentage_name()));
			request.setAttribute("prheadadr", CharacterReference.decode(prO.getHead_of_parentage_address()));
			request.setAttribute("prhistory", CharacterReference.decode(prO.getHistory_of_parentage()));
			request.setAttribute("pradr", CharacterReference.decode(prO.getAddress()));
			request.setAttribute("prnumber_individual", items.size());

			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/edit.jsp");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setContentType(CONTENT_TYPE);
		response.setCharacterEncoding("UTF-8");

		AccountObject ac = (AccountObject) request.getSession().getAttribute("Loginned");

		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("CPool");
		ParentageControl pr = new ParentageControl(cp);
		IndividualControl ind = new IndividualControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("CPool", pr.getCP());
		}

		ParentageObject prO = pr.getParentage(ac.getAccountname());
		String data = request.getParameter("data");
		if (data != null && !data.equalsIgnoreCase("")) {
			HttpUtil util = new HttpUtil(data);
			ParentageObject item = util.toModel(ParentageObject.class);
			item.setParentage_name(CharacterReference.encode(item.getParentage_name()));
			item.setAccount_name(CharacterReference.encode(item.getAccount_name()));
			item.setAncestor(CharacterReference.encode(item.getAncestor()));
			item.setHead_of_parentage_name(CharacterReference.encode(item.getHead_of_parentage_name()));
			item.setHead_of_parentage_address(CharacterReference.encode(item.getHead_of_parentage_address()));
			item.setHistory_of_parentage(CharacterReference.encode(item.getHistory_of_parentage()));
			item.setAddress(CharacterReference.encode(item.getAddress()));
			if (item.getCultural_autumn_day() == "") {
				item.setCultural_autumn_day(null);
			}
			if (item.getCultural_spring_day() == "") {
				item.setCultural_spring_day(null);
			}

			IndividualObject indo = new IndividualObject();

			if (prO.getParentage_id() > 0) {
				item.setParentage_id(prO.getParentage_id());
				if (pr.editParentage(item)) {
					IndividualObject ind1 = ind.getAncestor(prO.getParentage_id());					
					ind1.setFullname(item.getAncestor());
					if(ind.editIndividual(ind1)) {
						out.print("Update Successfully");
					}
				} else {
					out.print("Update Failure");
				}
			} else {
				if (pr.addParentage(item)) {
					ParentageObject pr1 = pr.getParentage(ac.getAccountname());
					indo.setParentage_id(pr1.getParentage_id());
					indo.setFather(0);
					indo.setFullname(pr1.getAncestor());
					if (ind.addIndividual(indo)) {
						IndividualObject ind1 = ind.getAncestor(pr1.getParentage_id());
						ind1.setBranch(ind1.getIndividual_id()+"");
						if(ind.editIndividual(ind1)) {
							out.print("Add Successfully");
						}
					} else {
						out.print("Add Failure");
					}
				} else {
					out.print("Add Failure");
				}
			}
			pr.releaseConnection();

		} else {
			out.print(CharacterReference.encode("System error"));
			response.sendRedirect("/parentage/ae");
		}

	}
}
