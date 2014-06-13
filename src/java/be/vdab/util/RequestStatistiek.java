/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.util;

/**
 *
 * @author pieter.mels
 */
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class RequestStatistiek {
    public synchronized void voegRequestToe(HttpServletRequest request) {
        ServletContext context = request.getServletContext();
        @SuppressWarnings("unchecked")
        Map<String, Integer> statistiek = (Map<String, Integer>) context.getAttribute("statistiek");
        if (statistiek == null) {
            statistiek = new ConcurrentHashMap<>();
            context.setAttribute("statistiek", statistiek);
        }
        String url = request.getRequestURI();
        int index = url.indexOf(";jsessionid=");
        if (index != -1) {
            url = url.substring(0, index);
        }
        if (statistiek.containsKey(url)) {
            statistiek.put(url, statistiek.get(url) + 1);
        } else {
            statistiek.put(url, 1);
        }
    }
}
