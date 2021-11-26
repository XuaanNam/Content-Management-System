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

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Account account = new Account();
		ConnectMySql activ = new ConnectMySql();
		account.setUsername(username);
		account.setEmail(email);
		account.setPassword(password);
		if(!activ.checkRegister(email, username)) {
			activ.insertUser(account);
			response.sendRedirect(request.getContextPath()+ "/views/login.jsp");
		}
		else {
			request.setAttribute("Message2", "Email or username is existed");
			request.getRequestDispatcher("/views/register.jsp").forward(request,response);
		}
		
	}

}
