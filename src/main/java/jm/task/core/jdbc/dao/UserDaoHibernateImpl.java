package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class UserDaoHibernateImpl implements UserDao {

    private final SessionFactory sessionFactory = Util.createHibernateSessionFactory();

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();


    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = new User();
        user.setId(id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);

        TypedQuery<User> allQuery = session.createQuery(all);
        return allQuery.getResultList();


    }

    @Override
    public void cleanUsersTable() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("delete from User").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
