package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConnectMySql;
import model.beanContent;
import model.Account;

@WebServlet("/viewTrashBinServlet")
public class viewTrashBinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectMySql conn = new ConnectMySql();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int id = Account.userId; 
			
			List<beanContent> listContent = conn.trashBinContentWithId(id);
			if(listContent == null) { 
				System.out.print("listContent is null!");
			}else {
				request.setAttribute("viewResult", listContent);
			}
	        request.getRequestDispatcher("trashBin.tiles").forward(request, response);
		} catch (Exception e) {
			System.out.print("trash bin servlet failed !");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
