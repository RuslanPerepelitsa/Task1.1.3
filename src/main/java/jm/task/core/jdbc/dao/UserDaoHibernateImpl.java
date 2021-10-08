package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {
    }


    @Override
    public void createUsersTable() {
        Transaction transaction = null;
        try {
            Session session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users " +
                    "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, " +
                    "age TINYINT NOT NULL)").executeUpdate();
            transaction.commit();
            session.close();
            System.out.println("The table was created successfully");
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        try {
            Session session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
            transaction.commit();
            session.close();
            System.out.println("The table was dropped successfully");
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try {
            Session session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(new User(name, lastName, age));
            transaction.commit();
            session.close();
            System.out.println("User " + name + " " + lastName + " was saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try {
            Session session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(session.get(User.class, id));
            transaction.commit();
            session.close();
            System.out.println("User " + id + " was deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = null;
        Transaction transaction = null;
        try {
            Session session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            list = session.createQuery("From " + User.class.getSimpleName()).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        List<User> users;
        try {
            Session session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            users = session.createQuery("From " + User.class.getSimpleName()).list();
            for (Object o :
                    users) {
                session.delete(o);
            }
            transaction.commit();
            session.close();
            System.out.println("The table was cleaned successfully");
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}



