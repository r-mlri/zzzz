package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class selectModel {
    public ResultSet retrieveData(Connection conn)
    {
        try {
            String query = "SELECT * FROM student_entry ";
            PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           
            
            ResultSet records = ps.executeQuery();
            
            if(records.next()){
                records.beforeFirst();
                return records;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(selectModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}