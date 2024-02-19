package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private static final Session session = Util.getSessionFactory().openSession();

    @Override
    public void createUsersTable() {
        Transaction transaction = session.beginTransaction();
        String sql = "CREATE TABLE IF NOT EXISTS  users (\n" +
                "    userid BIGINT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    firstname VARCHAR(255),\n" +
                "    lastName VARCHAR(255),\n" +
                "    age TINYINT\n" +
                ")";
        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        transaction.commit();
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = session.beginTransaction();
        String sql = "DROP TABLE IF EXISTS users";
        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        transaction.commit();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = session.beginTransaction();
        String sql = "INSERT INTO users (firstname, lastname, age) VALUES(:name, :lastname, :age)";
        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.setParameter("name", name);
        query.setParameter("lastname", lastName);
        query.setParameter("age", age);
        query.executeUpdate();
        transaction.commit();
        //System.out.println("User с именем — " + name + " добавлен в базу данных");
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = session.beginTransaction();
        String sql = "DELETE FROM users WHERE userid = :id";
        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT userid, firstname, lastname, age FROM users";
        Query query = session.createSQLQuery(sql).addEntity(User.class);
        return query.list();
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = session.beginTransaction();
        String sql = "TRUNCATE TABLE users";
        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        transaction.commit();
    }
}
