package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.connectMySql;
import model.CookieUnit;
@WebServlet("/views/login")
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
		connectMySql conn = new connectMySql();
			if(conn.checkLogin(email, password)) {
				//save session
				HttpSession session = request.getSession();
				session.setAttribute("logged", email);
				//save cookies
				CookieUnit.add("cookieEmail", email, 24, response);
				CookieUnit.add("cookiePass", password, 24, response);
				CookieUnit.add("cookieRem", remember, 24, response);
				//redirect
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
			else {
				request.setAttribute("Message1", "Email or password is incorrect");
				request.getRequestDispatcher("/views/login.jsp").forward(request,response);
				
			}
				
	}

}
