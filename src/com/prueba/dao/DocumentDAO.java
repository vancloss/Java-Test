package com.prueba.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.prueba.beans.*;

public class DocumentDAO {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public DocumentDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername,
					jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	public List<Document> listAllDocumentbyUser(String id_user, String status_user)
			throws SQLException {
		List<Document> listDocument = new ArrayList<>();

		String sql = "SELECT * FROM mert_bitacora WHERE id_ubicacion = \""
				+ id_user + "\" AND estdocumento = \"" + status_user + "\"";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			String id = resultSet.getString("id_documento");
			String type = resultSet.getString("tipdocumento");
			Date enter_date = resultSet.getDate("fecentrada");
			Date exit_date = resultSet.getDate("fecsalida");
			String status = resultSet.getString("estdocumento");
			String commentary = resultSet.getString("descomentario");
			User user = new User(id_user);

			Document document = new Document(id, type, enter_date, exit_date,
					status, commentary, user);

			listDocument.add(document);
		}
		resultSet.close();
		statement.close();

		disconnect();

		return listDocument;
	}
}
