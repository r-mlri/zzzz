package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class addAccountModel {
    
    public boolean insertData (String username, String password, String role, int pin, Connection conn)        
    {
         try
         {
            String query = "INSERT into accounts SET username = ?, password = ?, role = ?, reset_pin = ? ";
            PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);  
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);
            ps.setInt(4, pin);
            
            ps.executeUpdate();
        } catch (SQLException ex) 
        {
            Logger.getLogger(selectAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }return true;
    }
}
