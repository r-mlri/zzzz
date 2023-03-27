package controller;

///////////////////////DI GUMAGANA JAVAX SAKIN AND SGURO DAHIL SA JAVA KO SO NAG JAKARTA AKO - Rafael Mallari//////////////////////////////////////////////
//////////////////////JUST IGNORE YUNG IMPORT ERRORS AS DI NAMAN APEKTADO BUONG PROJECT, BUT IF U WANT 2 DELETE GO FOR IT//////////////////////////////////
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
///////////////////////DI GUMAGANA JAVAX SAKIN AND SGURO DAHIL SA JAVA KO SO NAG JAKARTA AKO - Rafael Mallari//////////////////////////////////////////////
//////////////////////JUST IGNORE YUNG IMPORT ERRORS AS DI NAMAN APEKTADO BUONG PROJECT, BUT IF U WANT 2 DELETE GO FOR IT//////////////////////////////////
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import model.UserDAO;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class loginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            // get the username and password from the request parameters
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            // authenticate the user
            UserDAO userDao = new UserDAO();
            User user = userDao.authenticate(username, password);
            
            // if the user was not found, redirect back to the login page with an error message
            if (user == null) {
                request.setAttribute("errorMessage", "<font color=red>Invalid username or password.</font>");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
                return;
            }
            else if (password == null && password == "")
            {
                request.setAttribute("errorMessage", "<font color=red>Enter your password.</font>");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            else {
                request.setAttribute("errorMessage", "<font color=red>Either user name or password or role is wrong.</font>");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            
            if (user.getRole().equals("admin")) {
                response.sendRedirect("AdminHomePage.jsp");
            } else if (user.getRole().equals("support staff")) {
                response.sendRedirect("SSHomePage.jsp");
            } else {
                // unknown role, redirect back to the login page with an error message
                request.setAttribute("errorMessage", "Unknown role: " + user.getRole());
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}       