package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.connectMySql;
import model.beanContent;

@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 3;
		String search = request.getParameter("txtsearch");
		connectMySql conn = new connectMySql();
		List<beanContent> list = conn.Search(search,id);
		request.setAttribute("viewResult", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewContent.tiles");
		dispatcher.forward(request, response);

	}

}
