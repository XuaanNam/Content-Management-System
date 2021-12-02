package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConnectMySql;
import model.beanContent;
import model.Account;

@WebServlet("/addContentServlet")
public class addContentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ConnectMySql conn = new ConnectMySql();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Account.userId;

        LocalDateTime today = LocalDateTime.now();
        response.setContentType("txt/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String brief = request.getParameter("brief");
        String content = request.getParameter("content");
        String createtime = today.toString();
        beanContent newContent = new beanContent(title, brief, content, createtime, id);
        try {
            conn.insertContent(newContent);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/viewContentServlet");

    }

}