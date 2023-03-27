package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class addAccountModel {
    
    public ResultSet selectUsername(String username, Connection conn)
    {
        try {
            String query = "SELECT * FROM accounts WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, username);
            
            ResultSet records = ps.executeQuery();
            if(records.next())
            {
                return records;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(addAccountModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet selectPIN(int pin, Connection conn)
    {
        try {
            String query = "SELECT * FROM accounts WHERE resetpin = ?";
            PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setInt(1, pin);
            
            ResultSet records = ps.executeQuery();
            if(records.next())
            {
                return records;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(addAccountModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean insertData (String username, String password, String role, int pin, Connection conn)        
    {
         try
         {
            String query = "INSERT into accounts SET username = ?, password = ?, role = ?, resetpin = ?";
            PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);  
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);
            ps.setInt(4, pin);
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) 
        {
            Logger.getLogger(addAccountModel.class.getName()).log(Level.SEVERE, null, ex);
        }return false;
    }
}
