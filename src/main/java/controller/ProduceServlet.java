package controller;

import model.Produce;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProduceServlet", urlPatterns = "Concac")
public class ProduceServlet extends HttpServlet {

    private UserService userService;
    private Produce produce;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        UserService userService = new UserService();
        switch (action) {
            case "/new":

                break;
            case "/insert":
                try {
                    insertProduce(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete":
                try {
                    deleteProduce(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/update":
                try {
                    updateProduce(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listProduce(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void listProduce(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Produce> list = userService.showAll();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean existingBook = userService.updateProduce(produce);
        RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
        request.setAttribute("list", existingBook);
        dispatcher.forward(request, response);

    }

    private void insertProduce(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String prime = request.getParameter("prime");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String status = request.getParameter("status");


        Produce produce = new Produce(id);
        userService.addProduce(produce);
        response.sendRedirect("list");
    }

    private void updateProduce(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String prime = request.getParameter("prime");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String status = request.getParameter("status");

        Produce produce = new Produce(id);
        userService.updateProduce(produce);
        response.sendRedirect("list");
    }

    private void deleteProduce(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Produce produce = new Produce(id);
        userService.deleteUser(produce);
        response.sendRedirect("list");

    }
}
