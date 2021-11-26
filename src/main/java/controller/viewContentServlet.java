package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.connectMySql;
import model.beanContent;

@WebServlet({"/viewContentServlet"})
public class viewContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	connectMySql conn = new connectMySql();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = 1; //id se dc lay tu session cua phan login		
		
		
		
		String sort = request.getParameter("sort");
		String sortType = request.getParameter("sortType");
		if(sort == null) {
			sort = "CreateDate";
		} else if((!sort.equals("CreateDate")) && (!sort.equals("Title")) && (!sort.equals("Brief"))) {
			sort = "CreateDate";
		} 
		if(sortType == null) {
			sortType = "desc";
		} else if(sortType.equals("option")) {
			
		} else if((!sortType.equals("asc")) && (!sortType.equals("desc"))) {
			sortType = "desc";
		} 
		
		
		int countContent=conn.getTotal(id,false, false, ""); 
	    int EndPage=countContent/10;
	    if(countContent%10 != 0) {
	        EndPage++;
	    }
	    
		String Spage = request.getParameter("page");
		if( Spage == null) {Spage = "1";}
		int page = Integer.parseInt(Spage) * 10 - 10;
		
		
		try {
			
			List<beanContent> listContent = conn.viewContentWithId(id, sort, sortType, page);
			request.setAttribute("viewResult", listContent);
			request.setAttribute("endP", EndPage);
			request.setAttribute("sort", sort);
			request.setAttribute("sortType", sortType);
			
			request.getRequestDispatcher("viewContent.tiles").forward(request, response);

		} catch (Exception e) {
			System.out.print("view content servlet failed !");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
