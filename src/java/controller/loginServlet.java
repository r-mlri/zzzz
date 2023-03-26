package controller;

///////////////////////DI GUMAGANA JAVAX SAKIN AND SGURO DAHIL SA JAVA KO SO NAG JAKARTA AKO - Rafael Mallari//////////////////////////////////////////////
//////////////////////JUST IGNORE YUNG IMPORT ERRORS AS DI NAMAN APEKTADO BUONG PROJECT, BUT IF U WANT 2 DELETE GO FOR IT//////////////////////////////////
/*import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
///////////////////////DI GUMAGANA JAVAX SAKIN AND SGURO DAHIL SA JAVA KO SO NAG JAKARTA AKO - Rafael Mallari//////////////////////////////////////////////
//////////////////////JUST IGNORE YUNG IMPORT ERRORS AS DI NAMAN APEKTADO BUONG PROJECT, BUT IF U WANT 2 DELETE GO FOR IT//////////////////////////////////

import java.io.IOException;
import model.User;
import model.UserDAO;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class loginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the username and password from the request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // authenticate the user
        UserDAO userDao = new UserDAO();
        User user = userDao.authenticate(username, password);

        // if the user was not found, redirect back to the login page with an error message
        if (user == null) {
            request.setAttribute("errorMessage", "Invalid username or password.");
            request.getRequestDispatcher("error").forward(request, response);
            return;
        }

        // if the user was found, store their information in the session and redirect to the appropriate page
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
    }
}
