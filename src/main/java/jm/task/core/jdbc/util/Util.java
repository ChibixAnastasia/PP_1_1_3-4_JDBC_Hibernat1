package jm.task.core.jdbc.util;

import com.mysql.cj.xdevapi.SessionFactory;
import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import javax.imageio.spi.ServiceRegistry;
import java.lang.module.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Util {
    private static String url = "jdbc:mysql://localhost:3306/first_schema";
    private static String userName = "root";
    private static String password = "nastya567";

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





}



