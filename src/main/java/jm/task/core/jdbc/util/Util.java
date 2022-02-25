package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/first_schema";
    private static final String userName = "root";
    private static final String password = "nastya567";

    public static Connection getConnect() {
        Connection connect = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connect = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connect;
    }


    public static SessionFactory createHibernateSessionFactory() {
        Properties prop= new Properties();

        prop.setProperty("hibernate.connection.url", url);
        prop.setProperty( "hibernate.hbm2ddl.auto", "create");

        prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");

        prop.setProperty("hibernate.connection.username", userName);
        prop.setProperty("hibernate.connection.password", password);
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");

        return new Configuration().addProperties(prop).addAnnotatedClass(User.class).buildSessionFactory();

    }




    }













