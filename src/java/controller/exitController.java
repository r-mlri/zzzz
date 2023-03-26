package controller;


import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

///////////////////////DI GUMAGANA JAVAX SAKIN AND SGURO DAHIL SA JAVA KO SO NAG JAKARTA AKO - Rafael Mallari//////////////////////////////////////////////
//////////////////////JUST IGNORE YUNG IMPORT ERRORS AS DI NAMAN APEKTADO BUONG PROJECT, BUT IF U WANT 2 DELETE GO FOR IT//////////////////////////////////
/*import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;*/
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

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        if("Leave".equals(request.getParameter("hidden"))){

            int ID = Integer.parseInt(request.getParameter("ID"));

            if(conn != null){
                exitModel model = new exitModel();
                select2Model model2 = new select2Model();

                // Insert the ID into the student_exit table
                boolean exitError = model.insertData(ID, conn);

                // Insert the selected checkboxes into the student_exit_checkboxes table
                boolean checkboxesError = model.insertCheckboxes(request, conn);

                if(exitError == false || checkboxesError == false){
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                    return;
                }

                ResultSet records = model2.retrieveData(conn);

                if(records != null){
                    request.setAttribute("results", records);
                    request.getRequestDispatcher("SuccessPage.jsp").forward(request, response);
                }
                else{
                    request.getRequestDispatcher("error2.jsp").forward(request, response);
                }
            }
            else{
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }    
        }
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}