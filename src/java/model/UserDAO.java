package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

    public String check(User User, Connection conn) throws SQLException
   {
       
       String sql = "SELECT * FROM accounts";
       String username = User.getUsername();
       String password = User.getPassword();
         
       
       String userdb = "";
       String passdb = "";
       String roledb = "";
       
         try
         {
             conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet.next()){
                 
              userdb = resultSet.getString("username");
              passdb = resultSet.getString("password");
              roledb = resultSet.getString("role");
 
               if(username.equals(userdb) && password.equals(passdb) && roledb.equals("admin")){
                  return "SUCCESS FOR ADMIN";
                  
               }else if (username.equals(userdb) && password.equals(passdb) && roledb.equals("support staff")){
                   return "SUCCESS FOR SS";
                   
               }else if(!username.equals(userdb) && !password.equals(passdb)){
                   return "INVALID USER CREDENTIALS";
                   
               }
               else{
                   return null;
               }
             }
             }   catch (SQLException ex) {
                 Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        return null;
   }

}