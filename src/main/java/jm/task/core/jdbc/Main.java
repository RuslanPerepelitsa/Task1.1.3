package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


public class Main {
    private static final User user1 = new User("Ivan", "Petrov", (byte) 25);
    private static final User user2 = new User("Petr", "Ivanov", (byte) 22);
    private static final User user3 = new User("Kirill", "Pavlov", (byte) 28);
    private static final User user4 = new User("Ruslan", "Perepelitsa", (byte) 19);

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        Util.createSessionFactory();
        userService.createUsersTable();
        userService.saveUser(user1.getName(),user1.getLastName(),user1.getAge());
        userService.saveUser(user2.getName(),user2.getLastName(),user2.getAge());
        userService.saveUser(user3.getName(),user3.getLastName(),user3.getAge());
        userService.saveUser(user4.getName(),user4.getLastName(),user4.getAge());
        userService.removeUserById(4);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
        Util.closeConnection();
    }
}
