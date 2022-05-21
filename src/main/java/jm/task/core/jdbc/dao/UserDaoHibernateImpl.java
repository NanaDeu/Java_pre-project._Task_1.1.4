package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "CREATE TABLE IF NOT EXISTS user (id INT PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                " name VARCHAR(40), lastName VARCHAR(40), age INT);";

        Query query = session.createNativeQuery(sql);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DROP TABLE IF EXISTS user";

        Query query = session.createNativeQuery(sql);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User newUser = new User(name, lastName, age);
        String sql = "INSERT INTO user(name, lastName, age) VALUES('" + newUser.getName() + "'" +
                ",'" + newUser.getLastName() + "'" + "," + newUser.getAge() + ");";

        Query query = session.createNativeQuery(sql);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DELETE FROM user WHERE id = " + id + ";";

        Query query = session.createNativeQuery(sql);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = (List<User>)  getSessionFactory().openSession().createQuery("From User").list();

        System.out.println(users.toString());
        return users;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            String sql = "DELETE FROM user;";

            Query query = session.createNativeQuery(sql);
            query.executeUpdate();

            transaction.commit();
            session.close();
        }

    }
}
