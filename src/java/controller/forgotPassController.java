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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DBConnection;
import model.User;
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
        
        conn = DBConnection.getConnection();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        conn = DBConnection.getConnection();
        
        forgotPassModel user = new forgotPassModel();
        if ("reset".equals(request.getParameter("hidden"))) {        
        String username = request.getParameter("username");
        String password = request.getParameter("password"); 
        int pin = Integer.parseInt(request.getParameter("pin"));   
        
        
        if (conn != null) {
        try {
            if(user.checkU(username, pin, conn) == true)
            {
                if(user.checkP(password, username, pin, conn) == true)
                {
                    response.sendRedirect("Login.jsp"); 
                }
                else{
                request.setAttribute("errorMessage", "<font color=red>Failed to update password. REASON PASSWORD DOES NOT MEET EXPECTATIONS</font>");
                request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
                }
            }
            else if (pin < 10000 || pin > 99999) {
            request.setAttribute("errorMessage", "<font color=red>PIN should be a 4-digit number.</font>");
            request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
        }
            else{
                request.setAttribute("errorMessage", "<font color=red>Failed to update password. REASON WRONG USERNAME/RESETPIN</font>");
                request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(forgotPassController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    }
}