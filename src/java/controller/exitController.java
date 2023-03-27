package controller;



import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

///////////////////////DI GUMAGANA JAVAX SAKIN AND SGURO DAHIL SA JAVA KO SO NAG JAKARTA AKO - Rafael Mallari//////////////////////////////////////////////
//////////////////////JUST IGNORE YUNG IMPORT ERRORS AS DI NAMAN APEKTADO BUONG PROJECT, BUT IF U WANT 2 DELETE GO FOR IT//////////////////////////////////
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
///////////////////////DI GUMAGANA JAVAX SAKIN AND SGURO DAHIL SA JAVA KO SO NAG JAKARTA AKO - Rafael Mallari//////////////////////////////////////////////
//////////////////////JUST IGNORE YUNG IMPORT ERRORS AS DI NAMAN APEKTADO BUONG PROJECT, BUT IF U WANT 2 DELETE GO FOR IT//////////////////////////////////

import model.exitModel;
import model.select2Model;

public class exitController extends HttpServlet {

    Connection conn;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        try {
            Class.forName(config.getInitParameter("jdbcClassName"));
            String username = config.getInitParameter("dbUserName");
            String password = config.getInitParameter("dbPassword");
            String url = new String(config.getInitParameter("jdbcURL"))
                +("://")
                +(config.getInitParameter("jdbcHostName"))
                +(":")
                +(config.getInitParameter("dbPort"))
                +("/")
                +(config.getInitParameter("databaseName"));
         conn = DriverManager.getConnection(url, username, password);
            } 
            catch (SQLException sqle) 
            {
            System.out.println("SQLException error occured - " + sqle.getMessage());
            } catch (ClassNotFoundException ex) {   
            Logger.getLogger(exitController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    if("Exit".equals(request.getParameter("hidden"))){

        // Validate input data
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String idString = request.getParameter("ID");
        int id = -1;
        String errorMessage = null;
        
        if (username == null || username.isEmpty()) {
            errorMessage = "<font color=red>Username is required.</font>";
        } else if (password == null || password.isEmpty()) {
            errorMessage = "<font color=red>Password is required.</font>";
        } else if (idString == null || idString.isEmpty()) {
            errorMessage = "<font color=red>ID is required.</font>";
        } else {
            try {
                id = Integer.parseInt(idString);
            } catch (NumberFormatException e) {
                errorMessage = "<font color=red>ID must be a valid integer.</font>";
            }
        }
        
        if (errorMessage != null) {
            // Display error message and stop processing
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/StudentExit.jsp");
            rd.forward(request, response);
            return;
        }
        
        }
    }
}