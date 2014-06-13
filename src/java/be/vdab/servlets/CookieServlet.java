/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pieter.mels
 */
@WebServlet("/cookies.htm")
public class CookieServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/cookies.jsp";
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) 
            throws ServletException, IOException {
        // de gesubmitte form verwerken
        Cookie cookie=new Cookie("naam",
            URLEncoder.encode(request.getParameter("naam"), "UTF-8"));
        cookie.setMaxAge(60 * 30); // 60 seconden x 30 = 30 minuten
        response.addCookie(cookie);
        // een redirect naar dezelfde servlet:
        response.sendRedirect(request.getRequestURI());
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // de pagina met de form presenteren aan de gebruiker
        if (request.getCookies() != null) {
            for (Cookie cookie:request.getCookies()) {
                if (cookie.getName().equals("naam")) {
                    // als de cookie 'naam' al bestaat,
                    // de inhoud van deze cookie doorgeven aan de JSP,
                    // zodat hij daarmee het tekstvak kan initialiseren:
                    request.setAttribute("naam",
                        URLDecoder.decode(cookie.getValue(), "UTF-8"));
                }
            }
        }
        
        RequestDispatcher dispatcher=request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);

    }

}
