package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConnectMySql;
import model.beanContent;
import model.Account;
@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectMySql conn = new ConnectMySql();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Account.userId; //id se dc lay tu session cua phan login
		response.setContentType("txt/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String search = request.getParameter("txtsearch");
		if(search == null) {
			search = request.getParameter("s");
		}
		
		int countContent=conn.getTotal(id, false, true, search); 
	    int EndPage=countContent/10;
	    if(countContent%10 != 0) {
	        EndPage++;
	    }
		String Spage = request.getParameter("page");
		if( Spage == null) {Spage = "1";}
		int page = Integer.parseInt(Spage) * 10 - 10;
		
		String sort = request.getParameter("sort");
		String sortType = request.getParameter("sortType");
		if(sort == null) {
			sort = "CreateDate";
		} else if((!sort.equals("CreateDate")) && (!sort.equals("Title")) && (!sort.equals("Brief"))) {
			sort = "CreateDate";
		} 
		if(sortType == null) {
			sortType = "desc";
		} else if((!sortType.equals("asc")) && (!sortType.equals("desc"))) {
			sortType = "desc";
		} 
		
		try {
			List<beanContent> list = conn.Search(search,id, sort, sortType, page);
			request.setAttribute("viewResult", list);
			request.setAttribute("endP", EndPage);
			request.setAttribute("sort", sort);
			request.setAttribute("sortType", sortType);
			request.setAttribute("search", search);
			request.setAttribute("txts",search );
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewContent.tiles");
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("navigation.jsp");
			dispatcher.forward(request, response);
			dispatcher1.forward(request, response);
		} catch (Exception e) {
			
			System.out.print("search failed !");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
