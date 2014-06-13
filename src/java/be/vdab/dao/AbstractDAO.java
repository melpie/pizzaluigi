/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.dao;


import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author pieter.mels
 */
public class AbstractDAO {
    private static final String JNDI_NAME = "java:/comp/env/jdbc/pizzaluigi";
    public Connection getConnection() {
        Context context = null; 
        try {
            context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup(JNDI_NAME);
            return dataSource.getConnection();
        } catch (NamingException ex) {
            throw new DAOException(JNDI_NAME + " niet gevonden", ex);
        } catch (SQLException ex) {
         throw new DAOException("kan geen connectie krijgen van " + JNDI_NAME, ex);
        } finally {
            try {
                if (context != null) {
                    context.close();
                }
            } catch (NamingException ex) {
                throw new DAOException("kan " + JNDI_NAME + " niet sluiten",ex);
            }
        }
    }
}
