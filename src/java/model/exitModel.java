package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;

public class exitModel {
    
    public boolean insertData (int ID, Connection conn)        
    {
         try
         {
            String query = "INSERT INTO student_exit (ID, time, date) VALUES (?, CURRENT_TIME(), NOW())";
            PreparedStatement ps = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);  
            ps.setInt(1, ID);
            
            ps.executeUpdate();
        } catch (SQLException ex) 
        {
            Logger.getLogger(select2Model.class.getName()).log(Level.SEVERE, null, ex);
        }return true;
    }

    public boolean insertCheckboxes(HttpServletRequest request, Connection conn) {
    boolean error = false;

    try {
        String[] checkboxValues = request.getParameterValues("checkbox");

        if (checkboxValues != null) {
            // Insert each selected checkbox into the student_exit_checkboxes table
            for (String checkboxValue : checkboxValues) {
                String query = "INSERT INTO student_exit (ID, equipments_used) VALUES (?, ?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(request.getParameter("ID")));
                ps.setString(2, checkboxValue);
                ps.executeUpdate();
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(exitModel.class.getName()).log(Level.SEVERE, null, ex);
        error = true;
    }

    return !error;
}


}

