package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoHibernateImpl userDaoJDBC = new UserDaoHibernateImpl();

    // UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

    public UserDaoHibernateImpl getUserDaoHibernate() {
        return userDaoJDBC;
    }

    public void setUserDaoHibernate(UserDaoHibernateImpl userDaoHibernate) {
        this.userDaoJDBC = userDaoHibernate;
    }
/*    UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

    public UserDaoJDBCImpl getUserDaoJDBC() {
        return userDaoJDBC;
    }

    public void setUserDaoJDBC(UserDaoJDBCImpl userDaoJDBC) {
        this.userDaoJDBC = userDaoJDBC;
    }*/

    public void createUsersTable() {
        userDaoJDBC.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBC.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoJDBC.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoJDBC.cleanUsersTable();
    }
}
