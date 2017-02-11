package com.prueba.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prueba.dao.DocumentDAO;
import com.prueba.dao.UserDAO;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.prueba.dao.*;
import com.prueba.beans.*;
/**
 * Servlet implementation class ListDocumentbyUserServlet
 */
@WebServlet("/ListDocumentbyUserServlet")
public class ListDocumentbyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private DocumentDAO documentDAO;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListDocumentbyUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
        documentDAO = new DocumentDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String id = request.getParameter("select_user");
	    String status = request.getParameter("select_status");
        User user;
		try {
			
			user = userDAO.getUser(id);
		    

		} catch (SQLException e ) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		request.setAttribute("user", user);
		
        List<Document> listDocument;
		try {
			listDocument = documentDAO.listAllDocumentbyUser(id, status);
			try{
				request.setAttribute("listDocument",listDocument);
			}
			catch (NullPointerException e)
			{
				throw new ServletException(e);
			}
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewDocumentsUser.jsp");
        dispatcher.forward(request, response);
	}

}
