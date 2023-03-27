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

                addAccountModel add = new addAccountModel();
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String role = request.getParameter("role");
                String pinStr = request.getParameter("pin");
                int pin = 0;


                if (conn != null) {
                    if(add.selectUsername(username, conn) == null){
                        try {
                            pin = Integer.parseInt(pinStr);
                            if(add.insertData(username, password, role, pin, conn) == true){
                                request.getRequestDispatcher("/AdminHomePage.jsp").forward(request, response);
                            }else if (pin < 10000 || pin > 99999) {
                            request.setAttribute("errorMessage", "<font color=red>PIN should be a 5-digit number.</font>");
                            request.getRequestDispatcher("/AddAccount.jsp").forward(request, response);
                        }
                        } catch (NumberFormatException e) {
                            request.setAttribute("errorMessage", "<font color=red>PIN should be a number.</font>");
                            request.getRequestDispatcher("/AddAccount.jsp").forward(request, response);
                            return;  
                        } 
                    }else if (add.selectUsername(username, conn) != null) {
                        request.setAttribute("errorMessage", "<font color=red>The Username already exist</font>");
                        request.getRequestDispatcher("/AddAccount.jsp").forward(request, response);
                    }
                }
            }
     }
}