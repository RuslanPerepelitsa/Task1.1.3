package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ivan", "Petrov", (byte) 25);
        userService.saveUser("Petr", "Ivanov", (byte) 22);
        userService.saveUser("Kirill", "Pavlov", (byte) 28);
        userService.saveUser("Ruslan", "Perepelitsa", (byte) 19);
        userService.removeUserById(4);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();




    }
}
