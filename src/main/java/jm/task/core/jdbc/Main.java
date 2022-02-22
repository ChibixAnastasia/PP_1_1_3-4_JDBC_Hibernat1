package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
/*
        userService.createUsersTable();

        userService.saveUser("Nastya", "Chibix", (byte) 30);
        userService.saveUser("Natali", "Feoktistova", (byte) 29);
        userService.saveUser("Kristina", "Burakova", (byte) 25);
        userService.saveUser("Ira", "Pugach", (byte) 26);

        userService.removeUserById(4);

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();

        userService.dropUsersTable();*/

        userService.saveUser("Nastya", "Chibis", (byte) 30);
        userService.saveUser("Nastya", "Chibis", (byte) 32);
        userService.saveUser("Nastya", "Chibis", (byte) 35);
        userService.saveUser("Nastya", "Chibis", (byte) 40);

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();


    }

}
