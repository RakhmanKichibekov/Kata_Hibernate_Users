package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static final UserServiceImpl userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.createUsersTable();
        userService.saveUser("Rahman", "Kichibekov", (byte) 21);
        userService.saveUser("Anton", "Petrov", (byte) 25);
        userService.saveUser("Igor", "Gunov", (byte) 21);
        userService.saveUser("Sergey", "Sergeev", (byte) 45);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
        // реализуйте алгоритм здесь
    }
}
