package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static final UserServiceImpl userService = new UserServiceImpl();

    public static void main(String[] args) throws SQLException {
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
