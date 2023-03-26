package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class entryModel {
    
    public boolean insertData (int ID, Connection conn)        
    {
         try
         {
            //String query = "INSERT into student_entry SET ID = ?";
            String query = "INSERT INTO student_entry (ID, time, date) VALUES (?, CURRENT_TIME(), NOW())";
            PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);  
            ps.setInt(1, ID);
            
            ps.executeUpdate();
        } catch (SQLException ex) 
        {
            Logger.getLogger(selectModel.class.getName()).log(Level.SEVERE, null, ex);
        }return true;
    }
}
