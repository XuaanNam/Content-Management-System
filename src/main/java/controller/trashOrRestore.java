package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.connectMySql;

@WebServlet("/trashOrRestore")
public class trashOrRestore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	connectMySql conn = new connectMySql();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean set = false;
		try {
			if(conn.checkDraft(id)) {
				set = false;
				conn.trashOrRestore(id, set);
				request.getRequestDispatcher("/viewTrashBinServlet").forward(request, response);
			}
			else {
				set = true;
				conn.trashOrRestore(id, set);
				request.getRequestDispatcher("/viewContentServlet").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
