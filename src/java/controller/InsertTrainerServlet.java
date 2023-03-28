package controller;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.InsertTrainer;
import model.Trainer;


@WebServlet("/register")
public class InsertTrainerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InsertTrainer insert;

    public void init() {
        insert = new InsertTrainer();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String name = request.getParameter("name");
        String specialty = request.getParameter("specialty");
        String sports = request.getParameter("sports");
        
                        
                        
        if(name != null && specialty!= null && sports!= null)
            {                

                response.sendRedirect("SuccessPage.jsp");       

            }
            else 
                {
			if (name == null) 
                        {
                            request.setAttribute("errorMessage", "<font color=red>Enter a name.</font>");
                            RequestDispatcher rd = getServletContext().getRequestDispatcher("addTrainer.jsp");
                            rd.include(request, response);
			} 
                        
                        else if (specialty == null)
                        {
                            request.setAttribute("errorMessage", "<font color=red>Enter a specialty.</font>");
                            RequestDispatcher rd = getServletContext().getRequestDispatcher("addTrainer.jsp");
                            rd.include(request, response);
                        }
                        else if (sports == null)
                        {
                            request.setAttribute("errorMessage", "<font color=red>Enter a sport.</font>");
                            RequestDispatcher rd = getServletContext().getRequestDispatcher("addTrainer.jsp");
                            rd.include(request, response);
                        }
                        else 
                        {
			request.setAttribute("errorMessage", "<font color=red>Please fill up the form.</font>");
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("addTrainer.jsp");
                        rd.include(request, response);
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher("addTrainer.jsp");
                        rd.include(request, response);
                }    
        
                Trainer trainer = new Trainer();
                
                trainer.setName(name);
                trainer.setSpecialty(specialty);
                trainer.setSports(sports);

        try {
            insert.insertTrainers(trainer);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}