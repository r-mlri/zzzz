package controller;


import java.io.IOException;
import java.sql.*;
///////////////////////DI GUMAGANA JAVAX SAKIN AND SGURO DAHIL SA JAVA KO SO NAG JAKARTA AKO - Rafael Mallari//////////////////////////////////////////////
//////////////////////JUST IGNORE YUNG IMPORT ERRORS AS DI NAMAN APEKTADO BUONG PROJECT, BUT IF U WANT 2 DELETE GO FOR IT//////////////////////////////////
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DBConnection;
///////////////////////DI GUMAGANA JAVAX SAKIN AND SGURO DAHIL SA JAVA KO SO NAG JAKARTA AKO - Rafael Mallari//////////////////////////////////////////////
//////////////////////JUST IGNORE YUNG IMPORT ERRORS AS DI NAMAN APEKTADO BUONG PROJECT, BUT IF U WANT 2 DELETE GO FOR IT//////////////////////////////////

import model.forgotPassModel;
import model.selectAccounts;

public class forgotPassController extends HttpServlet {

    Connection conn;

    /**
     *
     * @param config
     * @throws ServletException
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        Connection conn;
        
        conn = DBConnection.getConnection();
    }

     protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

               if("hidden".equals(request.getParameter("reset"))){
                 String username = request.getParameter("username");
                 String password = request.getParameter("password");
                 int pin = Integer.parseInt(request.getParameter("pin"));
                 String pinStr = String.valueOf(pin);
                if(conn != null){
                    forgotPassModel model = new forgotPassModel();
                    selectAccounts model1 = new selectAccounts();
                    ResultSet error = model1.retrieveData(conn);
                    
                    if(error != null){
                         boolean records = model.updateData(password, username, pin, conn);

                         if(records != false){
                             request.setAttribute("results", records);
                             request.getRequestDispatcher("Login.jsp").forward(request, response);
                         }
                    } else{
                        if (username == null) {
			request.setAttribute("errorMessage", "<font color=red>Enter username.</font>");
                        request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
			} 
                        else if (password == null){
                        request.setAttribute("errorMessage", "<font color=red>Please Input a Password</font>");
                        request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
                        }
                        else if (pinStr == null) {
                            request.setAttribute("errorMessage", "<font color=red>Enter the correct pin.</font>");
                            request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
                        } 
                    }
                    }
            }
    }
 }