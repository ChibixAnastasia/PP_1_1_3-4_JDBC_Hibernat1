package jm.task.core.jdbc.dao;

import com.mysql.cj.Session;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import javax.persistence.Entity;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() throws SQLException {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
      /*  Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(users); //пользуемся ее методами
        session.flush();
        session.close();*/


    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
