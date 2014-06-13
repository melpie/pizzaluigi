/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.dao.PizzaDAO;
import be.vdab.util.RequestStatistiek;
import java.io.IOException;
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
@WebServlet("/menu/pizzas.htm")
public class PizzasServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/pizzas.jsp";
    
    private final RequestStatistiek requestStatistiek = new RequestStatistiek();
    
    private final PizzaDAO pizzaDAO = new PizzaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        requestStatistiek.voegRequestToe(request);
        
        request.setAttribute("pizzas", pizzaDAO.findAll());
        request.setAttribute("sterren", 5);
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);

    }

}
