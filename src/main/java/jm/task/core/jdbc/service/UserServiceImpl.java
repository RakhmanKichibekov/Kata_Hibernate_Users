package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final UserDaoHibernateImpl userHibernateImpl = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {
        userHibernateImpl.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userHibernateImpl.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userHibernateImpl.saveUser(name, lastName, age);
        System.out.println("User с именем — " + name + " добавлен в базу данных");
    }

    @Override
    public void removeUserById(long id) {
        userHibernateImpl.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userHibernateImpl.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userHibernateImpl.cleanUsersTable();
    }
}
