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

import model.addAccountModel;
import model.selectAccounts;

public class addAccountController extends HttpServlet {

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

     protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    if("create".equals(request.getParameter("hidden"))){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String pinStr = request.getParameter("pin");
        int pin = 0;
        
        // Error structure
        if (username == null || username.equals("")) {
            request.setAttribute("errorMessage", "<font color=red>Please enter a username.</font>");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddAccount.jsp");
            rd.include(request, response);
            return;
        } 

        if (password == null || password.equals("")) {
            request.setAttribute("errorMessage", "<font color=red>Please enter a password.</font>");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddAccount.jsp");
            rd.include(request, response);
            return;
        }
 
        if (pinStr == null || pinStr.equals("")) {
            request.setAttribute("errorMessage", "<font color=red>Please enter a PIN.</font>");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddAccount.jsp");
            rd.include(request, response);
            return;
        } else {
            try {
                pin = Integer.parseInt(pinStr);
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "<font color=red>PIN should be a number.</font>");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddAccount.jsp");
                rd.include(request, response);
                return;
            }
        }
        if (pin < 1000 || pin > 9999) {
            request.setAttribute("errorMessage", "<font color=red>PIN should be a 4-digit number.</font>");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddAccount.jsp");
            rd.include(request, response);
            return;
        }
        if(conn != null){
                    addAccountModel model1 = new addAccountModel();
                    selectAccounts model2 = new selectAccounts();
                    boolean error = model1.insertData(username, password, role, pin, conn);
                    
                    if(error != false){
                         ResultSet records = model2.retrieveData(conn);

                         if(records != null){
                             request.setAttribute("results", records);
                             request.getRequestDispatcher("Login.jsp").forward(request, response);
                         }
                    }
        }
    }
     }
}