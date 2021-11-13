package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.connectMySql;
import model.beanContent;

@WebServlet("/updateContentServlet")
public class updateContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	connectMySql conn = new connectMySql();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LocalDateTime today = LocalDateTime.now();		
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String brief = request.getParameter("brief");
		String content = request.getParameter("content");
		String updatetime = today.toString();
		beanContent bCt = new beanContent(id, title, brief, content, updatetime);
		try {
			conn.updateContent(bCt);
			request.setAttribute("contentResult", bCt);
			request.getRequestDispatcher("editContent.tiles").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}