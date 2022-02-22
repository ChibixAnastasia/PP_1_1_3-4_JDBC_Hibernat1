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





    /* private static StandardServiceRegistry registry;
        private static SessionFactory sessionFactory;

        public static SessionFactory getSessionFactory() {
            if (sessionFactory == null) {
                try {
                    StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

                    Map<String, String> settingsMap = new HashMap<>();
                    settingsMap.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                    settingsMap.put(Environment.URL, "jdbc:mysql://localhost:3306/first_schema");
                    settingsMap.put(Environment.USER, "root");
                    settingsMap.put(Environment.PASS, "nastya567");
                    settingsMap.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                    registryBuilder.applySettings(settingsMap);

                    registry = registryBuilder.build();

                    MetadataSources sources = new MetadataSources(registry);
                    sources.addAnnotatedClass(User.class);
                    Metadata metadata = sources.getMetadataBuilder().build();

                    sessionFactory = (SessionFactory) metadata.getSessionFactoryBuilder().build();

                } catch (Exception e) {
                    e.printStackTrace();
                    if (registry != null) {
                        StandardServiceRegistryBuilder.destroy(registry);
                    }
                }
            }
            return sessionFactory;
        }*/

 /*if (registry != null) {
         StandardServiceRegistryBuilder.destroy(registry);
         }*/

/*   User user1 = new User();
        user1.setName("Igor");
        user1.setLastName("Degtur");
        user1.setAge(44);
        util.save(user1);

        Users users2 = new Users();
        users2.setName("Sara");
        users2.setEmail("sarra_mother@gmail.com");
        users2.setPassword("qwerty123");
        usersCRUD.save(users2);

        usersCRUD.getAll().forEach(it->System.out.println(it));

        Users userWithId1 = usersCRUD.getById(5);
        System.out.println(userWithId1);

        usersCRUD.delete(userWithId1);

        usersCRUD.getAll().forEach(it->System.out.println(it));*/







