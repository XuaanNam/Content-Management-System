package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ConnectMySql;
import model.Account;
import model.CookieUnit;
@WebServlet("/view/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String remember = request.getParameter("checkbox");
		ConnectMySql conn = new ConnectMySql();
			if(conn.checkLogin(email, password)) {				
				if(remember != null) {
					CookieUnit.add("remember", "yes", 24, response);
				}
				//redirect
				response.sendRedirect(request.getContextPath() + "/cms.tiles");
			}
			else {
				request.setAttribute("Message1", "Email or password is incorrect");
				request.getRequestDispatcher("/views/login.jsp").forward(request,response);
			}
				
	}

}
