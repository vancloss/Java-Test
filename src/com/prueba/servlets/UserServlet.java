package com.prueba.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prueba.dao.*;
import com.prueba.beans.*;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private DocumentDAO documentDAO;
       
	
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
        documentDAO = new DocumentDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String action = request.getServletPath();
        
        try {
            switch (action) {
            case "/display":
                displayUser(request, response);
                break;
            default:
                listUser(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	 private void listUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        List<User> listUser = userDAO.listAllUser();
	        request.setAttribute("listUser", listUser);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");
	        dispatcher.forward(request, response);
	    }
	 private void displayUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
		    String id = request.getParameter("id");
		    String status = request.getParameter("status");
	        User user = userDAO.getUser(id);
	        request.setAttribute("user", user);
	        List<Document> listDocument = documentDAO.listAllDocumentbyUser(id, status);
	        request.setAttribute("listDocument",listDocument);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("displayUser.jsp");
	        dispatcher.forward(request, response);
	    }
	
	    

}
