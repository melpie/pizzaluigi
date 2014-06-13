/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.dao;

import be.vdab.entities.Pizza;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author pieter.mels
 */
public class PizzaDAO extends AbstractDAO {
   
    private static final String FIND_ALL_SQL =
        "select nummer,naam,prijs,pikant from pizzas order by naam";
    private static final String READ_SQL =
        "select nummer,naam,prijs,pikant from pizzas where nummer=?";
    private static final String FIND_BY_PRIJS_BETWEEN_SQL =
        "select nummer,naam,prijs,pikant from pizzas"+
        " where prijs between ? and ? order by prijs";
    private static final String CREATE_SQL =
        "insert into pizzas(naam,prijs,pikant) values (?,?,?)";
    
    public Iterable<Pizza> findAll() {
        try (Connection connection = getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(FIND_ALL_SQL);) {
            List<Pizza> pizzas = new ArrayList<>();
            while (resultSet.next()) {
                pizzas.add(resultSetRijNaarPizza(resultSet));
            }
            return pizzas;
        } catch (SQLException ex) {
            throw new DAOException("Kan pizzas niet lezen uit database", ex);
        }
    }

    private Pizza resultSetRijNaarPizza(ResultSet resultSet)
            throws SQLException {
        return new Pizza(resultSet.getLong("nummer"), resultSet.getString("naam"),
            resultSet.getBigDecimal("prijs"), resultSet.getBoolean("pikant"));
    }

    public Pizza read(long nummer) {
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(READ_SQL)) {
            Pizza pizza = null;
            statement.setLong(1, nummer);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    pizza = resultSetRijNaarPizza(resultSet);
                }
                return pizza;
            }
        } catch (SQLException ex) {
            throw new DAOException("Kan pizza niet lezen uit database", ex);
        }
    }

    public Iterable<Pizza> findByPrijsBetween(BigDecimal van, BigDecimal tot) {
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                FIND_BY_PRIJS_BETWEEN_SQL);) {
            List<Pizza> pizzas = new ArrayList<>();
            statement.setBigDecimal(1, van);
            statement.setBigDecimal(2, tot);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    pizzas.add(resultSetRijNaarPizza(resultSet));
                }
                return pizzas;
            }
        } catch (SQLException ex) {
            throw new DAOException("Kan pizzas niet lezen uit database", ex);
        }
    }

    public void create(Pizza pizza) {
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                CREATE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, pizza.getNaam());
            statement.setBigDecimal(2, pizza.getPrijs());
            statement.setBoolean(3, pizza.isPikant());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys())
            {
                if (!resultSet.next()) {
                    throw new DAOException(
                        "Kan nummer toegevoegde pizza niet lezen uit database");
                }
                pizza.setNummer(resultSet.getLong(1));
            }
        }
        catch (SQLException ex) {
            throw new DAOException("Kan pizzas niet toevoegen aan database", ex);
        }
    }
    
}
