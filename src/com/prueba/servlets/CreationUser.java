package com.prueba.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prueba.beans.User;

/**
 * Servlet implementation class CreationUser
 */
@WebServlet("/CreationUser")
public class CreationUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        /*
         * Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        String firstname = request.getParameter( "nameUser" );
        String password = request.getParameter( "pwdUser" );
        String mail = request.getParameter( "mailUser" );
        String codeidentification = request.getParameter( "codeUser" );
        String status = request.getParameter( "statusUser" );
        String expiration_date = request.getParameter("dateUser");
        //SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        //surround below line with try catch block as below code throws checked exception
        //do further processing with Date object


        String message;
        /*
         * Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès
         */
        if ( firstname.trim().isEmpty() || password.trim().isEmpty() || mail.trim().isEmpty() ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerClient.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
        } else {
            message = "Client créé avec succès !";
        }
        /*
         * Création du bean Client et initialisation avec les données récupérées
         */
        User user = new User();
        user.setFirstname(firstname);
        user.setPassword(password);
        user.setMail(mail);
        user.setCodeidentification(codeidentification);
        user.setStatus(status);
        user.setExpiration_date(expiration_date);

        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( "user", user );
        request.setAttribute( "message", message );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( "/displayUser.jsp" ).forward( request, response );
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
