package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConnectMySql;
import model.beanContent;


@WebServlet("/editContentServlet")
public class editContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectMySql conn = new ConnectMySql();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			beanContent bCt = conn.editContent(id);
			if(bCt == null) { 
				System.out.print("Content is null!");
			}else {
				request.setAttribute("contentResult", bCt);
			}
	        request.getRequestDispatcher("editContent.tiles").forward(request, response);
		} catch (Exception e) {
			System.out.print("edit content servlet failed !");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
