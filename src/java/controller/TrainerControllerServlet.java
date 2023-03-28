
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Trainer;
import model.TrainerDAO;


public class TrainerControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TrainerDAO trainerDAO;

 public void init(ServletConfig config) throws ServletException{
        super.init(config);

	String jdbcClassName = config.getInitParameter("jdbcClassName");
        String Username = config.getInitParameter("dbUserName");
        String Password = config.getInitParameter("dbPassword");
        
        StringBuffer url = new StringBuffer(config.getInitParameter("jdbcURL"))
                .append("://")
                .append(config.getInitParameter("dbHostName"))
                .append(":")
                .append(config.getInitParameter("dbPort"))
                .append("/")
                .append(config.getInitParameter("databaseName"));
        trainerDAO = new TrainerDAO(jdbcClassName, url.toString(), Username, Password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertTrainer(request, response);
                break;
            case "/delete":
                deleteTrainer(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateTrainer(request, response);
                break;
            default:
                listTrainers(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void listTrainers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Trainer> trainers = trainerDAO.getAllTrainers();
        request.setAttribute("trainers", trainers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AdminTrainersPage.jsp");   //List of all trainers
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditTrainers.jsp");    //edit form
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Trainer existingTrainer = trainerDAO.getTrainer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditTrainers.jsp");    //edit form
        request.setAttribute("trainer", existingTrainer);
        dispatcher.forward(request, response);

    }

    private void insertTrainer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String specialty = request.getParameter("specialty");
        String sports = request.getParameter("sports");
        if(name == null && specialty ==null && sports ==null){
            request.setAttribute("errorMessage", "<font color=red>please fill up the form</font>");
            request.getRequestDispatcher("addTrainer.jsp").forward(request, response);
        }else if(name != null && specialty !=null && sports !=null){
            Trainer newTrainer = new Trainer(name, specialty, sports);
            trainerDAO.saveTrainer(newTrainer);
            response.sendRedirect("list");
        }

        
    }

    private void updateTrainer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String specialty = request.getParameter("specialty");
        String sports = request.getParameter("sports");
        Trainer trainer = new Trainer(id, name, specialty, sports);
        trainerDAO.updateTrainer(trainer);
        response.sendRedirect("list");        
    }

    private void deleteTrainer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        trainerDAO.deleteTrainer(id);
        response.sendRedirect("list");
    }
}