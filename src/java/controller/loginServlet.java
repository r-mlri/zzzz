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
import jakarta.servlet.ServletConfig;
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
import model.DBConnection;
import model.User;
import model.UserDAO;

public class loginServlet extends HttpServlet {
    Connection conn;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        conn = DBConnection.getConnection();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        UserDAO userDAO = new UserDAO();
        
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //String depassword = request.getParameter("password");
            if(conn !=null){
            User User = new User(username, password);
            
            User.setUsername(username);
            User.setPassword(password);
            
            
            //Encryption
            //password = Encryption.encrypt(password);
            //Decryption
            //depassword = Encryption.decrypt(password);
            
            
            
            String userValidate = userDAO.check(User, conn);
            HttpSession session = request.getSession();
            session.setAttribute("user", User);
            
            switch (userValidate) {
                case "SUCCESS FOR ADMIN":
                    response.sendRedirect("AdminHomePage.jsp");
                    break;
                case "SUCCESS FOR SS":
                    response.sendRedirect("SSHomePage.jsp");
                    break;
                case "INVALID USER CREDENTIALS":
                    request.setAttribute("errorMessage", "<font color=red>wrong username/password</font>");
                    request.getRequestDispatcher("/Login.jsp").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("/Error404.jsp").forward(request, response);
                    break;   
            }
            }
            } catch (SQLException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}