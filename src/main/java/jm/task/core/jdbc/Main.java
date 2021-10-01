package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();
        service.createUsersTable();
        service.saveUser("Ivan", "Petrov", (byte) 25);
        service.saveUser("Petr", "Ivanov", (byte) 22);
        service.saveUser("Kirill", "Pavlov", (byte) 23);
        service.saveUser("Ruslan", "Perepelitsa", (byte) 19);
        System.out.println(service.getAllUsers());
        service.cleanUsersTable();
        service.dropUsersTable();


    }
}
