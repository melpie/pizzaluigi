/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.dao.PizzaDAO;
import be.vdab.entities.Pizza;
import be.vdab.util.RequestStatistiek;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet("/pizzas/toevoegen.htm")
public class PizzaToevoegenServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/pizzatoevoegen.jsp";
    private static final String SUCCESS_VIEW = "/WEB-INF/JSP/pizzas.jsp";
    private final PizzaDAO pizzaDAO = new PizzaDAO();
    private final RequestStatistiek requestStatistiek = new RequestStatistiek();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        requestStatistiek.voegRequestToe(request);
        
        RequestDispatcher dispatcher=request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        Map<String, String> fouten = new HashMap<>();
        String naam = request.getParameter("naam");
        if (naam == null || naam.isEmpty()) {
            fouten.put("naam", "verplicht");
        }
        BigDecimal prijs = null;
        try {
            prijs = new BigDecimal(request.getParameter("prijs"));
            if (prijs.compareTo(BigDecimal.ZERO) < 1) {
                fouten.put("prijs", "tik een positief getal");
            }
        } catch (Exception ex) {
            fouten.put("prijs", "tik een getal");
        }
        boolean pikant = "pikant".equals(request.getParameter("pikant"));
        if (fouten.isEmpty()) {
            Pizza pizza = new Pizza(naam, prijs, pikant);
            pizzaDAO.create(pizza);
            request.setAttribute("pizzas", pizzaDAO.findAll());
            RequestDispatcher dispatcher = request.getRequestDispatcher(SUCCESS_VIEW);
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("fouten", fouten);
            RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
            dispatcher.forward(request, response);
        }
        
    }

}
