package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class forgotPassModel {
    
    public boolean updateData (String password, String username, int pin, Connection conn)        
    {
         try
         {
            String query = "UPDATE accounts SET password = ? WHERE username = ? AND reset_pin = ?";
            PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);  
            ps.setString(1, password);
            ps.setString(2, username);
            ps.setInt(3, pin);
            
            ps.executeUpdate();
        } catch (SQLException ex) 
        {
            Logger.getLogger(selectAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }return true;
    }
}
