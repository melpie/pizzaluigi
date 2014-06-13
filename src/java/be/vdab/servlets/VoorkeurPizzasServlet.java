/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.dao.PizzaDAO;
import be.vdab.entities.Pizza;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pieter.mels
 */
@WebServlet("/pizzas/voorkeuren.htm")
public class VoorkeurPizzasServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String INPUT_VIEW = "/WEB-INF/JSP/voorkeurpizzasvragen.jsp";
    private static final String SUCCESS_VIEW = "/WEB-INF/JSP/voorkeurpizzastonen.jsp";
    private final PizzaDAO pizzaDAO = new PizzaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String view;
        if (request.getParameterValues("nummer") == null) {
            request.setAttribute("pizzas", pizzaDAO.findAll());
            view = INPUT_VIEW;
        } else {
            List<Pizza> pizzas = new ArrayList<>();
            try {
                for (String nummerAlsString:request.getParameterValues("nummer")){
                    long nummer = Long.parseLong(nummerAlsString);
                    Pizza pizza = pizzaDAO.read(nummer);
                    if (pizza != null) {
                        pizzas.add(pizza);
                     }
                }
                request.setAttribute("pizzas", pizzas);
                view = SUCCESS_VIEW;
            } catch (NumberFormatException ex) {
                request.setAttribute("pizzas", pizzaDAO.findAll());
                view = INPUT_VIEW;
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

}
