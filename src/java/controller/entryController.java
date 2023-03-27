package controller;



import java.io.IOException;
import java.sql.*;

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
            int ID = Integer.parseInt(request.getParameter("ID"));
            String input = request.getParameter("input");
            /*if (input == null || input.length() != 10 || !input.matches("\\d+")) {
                errorMessage = "<font color=red>Please enter a valid input (10 digits only).</font>";
            }*/
            if(conn != null){
                    entryModel model = new entryModel();
                    selectModel model2 = new selectModel();
                    boolean error = model.insertData(ID, conn);
                    
                    if(error != false){
                         ResultSet records = model2.retrieveData(conn);

                         if(records != null){
                             request.setAttribute("results", records);
                             request.getRequestDispatcher("SuccessPage.jsp").forward(request, response);
                         }
                         /*else{
                             request.getRequestDispatcher("error2.jsp").forward(request, response);
                         }*/
                    }
                    /*else{
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }*/
                }
                /*else{
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }*/    
        }
      }
}