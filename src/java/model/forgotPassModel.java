package model;

import controller.forgotPassController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class forgotPassModel {
   public boolean checkU(String username, int pin, Connection conn) throws ClassNotFoundException, SQLException
   {
       
       String sql = "SELECT * FROM accounts WHERE username = ? AND resetpin = ?";
       
       try {
       PreparedStatement st = conn.prepareStatement(sql,  ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       st.setString(1, username);
       st.setInt(2, pin);
               
       ResultSet rs = st.executeQuery();
       
       if(rs.next())
       {
          return true;
       }
       
       }catch (SQLException ex) {
                Logger.getLogger(forgotPassController.class.getName()).log(Level.SEVERE, null, ex);
   }
       return false;
}
    public boolean checkP(String password, String username, int pin, Connection conn) throws ClassNotFoundException, SQLException
       {
       
       String query = "UPDATE accounts SET password = ? WHERE username = ? AND resetpin = ?";
       
       try {
           PreparedStatement stp = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           stp.setString(1, password);
           stp.setString(2, username);
           stp.setInt(3, pin);
           
           stp.executeUpdate();
               return true;
       }catch (SQLException ex) {
           Logger.getLogger(forgotPassController.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
       }
}