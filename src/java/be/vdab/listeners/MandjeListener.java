/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Web application lifecycle listener.
 *
 * @author pieter.mels
 */
@WebListener()
public class MandjeListener implements HttpSessionAttributeListener {
    
    private static final String MANDJE = "mandje";
    private static final String AANTAL_MANDJES = "aantalMandjes";
    
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if (event.getName().equals(MANDJE)) {
            verhoogMandjeTeller(event.getSession().getServletContext());
        }
    }
    
    private synchronized void verhoogMandjeTeller(ServletContext servletContext) {
        Integer mandjeTeller = (Integer) servletContext.getAttribute(AANTAL_MANDJES);
        if (mandjeTeller == null) {
            mandjeTeller = 1;
        } else {
            mandjeTeller++;
        }
        servletContext.setAttribute(AANTAL_MANDJES, mandjeTeller);
    }


    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if (event.getName().equals(MANDJE)) {
            verlaagMandjeTeller(event.getSession().getServletContext());
        }
    }
    
    private synchronized void verlaagMandjeTeller(ServletContext servletContext) {
        Integer mandjeTeller = (Integer) servletContext.getAttribute(AANTAL_MANDJES);
        mandjeTeller--;
        servletContext.setAttribute(AANTAL_MANDJES, mandjeTeller);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
    }
}
