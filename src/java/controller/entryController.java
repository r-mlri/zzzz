package controller;



import java.io.IOException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entryModel;
import model.selectModel;

public class entryController extends HttpServlet {

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
            }   
            catch (ClassNotFoundException nfe) 
            {
            System.out.println("ClassNotFoundException error occured - " + nfe.getMessage());
            }
    }

      protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if ("Entry".equals(request.getParameter("hidden"))) {

            String errorMessage = "";
            
            // Validate input parameters
            String username = request.getParameter("username");
            if (username == null || username.length() == 0) {
                errorMessage = "<font color=red>Please enter a valid username.</font>";
            }

            String IDString = request.getParameter("ID");
            int ID = 0;
            try {
                ID = Integer.parseInt(IDString);
            } catch (NumberFormatException e) {
                errorMessage = "<font color=red>Please enter a valid ID.</font>";
            }

            String input = request.getParameter("input");
            if (input == null || input.length() != 10 || !input.matches("\\d+")) {
                errorMessage = "<font color=red>Please enter a valid input (10 digits only).</font>";
            }

            if (!errorMessage.isEmpty()) {
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/StudentLog.jsp");
                rd.include(request, response);
                return;
            }

           
        }
    }
}