package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement state = Util.getConnect().createStatement()) {
            state.execute("CREATE TABLE IF NOT EXISTS Users " +
                    "(id INT NOT NULL AUTO_INCREMENT, " +
                    "name VARCHAR (45) NOT NULL, " +
                    "lastName VARCHAR (45) NOT NULL, " +
                    "age INT NOT NULL, " +
                    "PRIMARY KEY (id));");
        } catch (SQLException e) {
            System.out.println("Не удалось создать таблицу USERS.");
        }
    }
        public void dropUsersTable() {
            try( Statement state = Util.getConnect().createStatement()) {
                state.executeUpdate("DROP TABLE USERS");
            } catch (SQLException e){
                System.out.println("Не удалось удалить таблицу USERS");
            }
    }

    public void saveUser(String name, String lastName, byte age) {
        String str = "INSERT INTO users(name, lastName, age) VALUES (?,?,?);";
            try( PreparedStatement state = Util.getConnect()
                    .prepareStatement(str)) {
                state.setString(1, name);
                state.setString(2, lastName);
                state.setByte(3, age);
                state.executeUpdate();
                System.out.println("User с именем "+ name +" добавлен в базу USERS");
            } catch (SQLException e) {
                System.out.println("Не удалось сохранить пользователя " + name);
            }
    }

    public void removeUserById(long iD) {
        try(PreparedStatement state = Util.getConnect().prepareStatement(String.valueOf(iD))) {
            state.executeUpdate("DELETE FROM users WHERE id =" + iD);
        } catch (SQLException e) {
            System.out.println("Не удалось удалить пользователя.");
        }
        }

    public List<User> getAllUsers() {

          List<User> usersList = new ArrayList<>();
        try(Statement state = Util.getConnect().createStatement()) {
            ResultSet res = state.executeQuery("select * from users");
            while (res.next()) {
                User user = new User();
                user.setId(res.getLong(1));
                user.setName(res.getString(2));
                user.setLastName(res.getString(3));
                user.setAge(res.getByte(4));
                usersList.add(user);
            }
        }catch (SQLException e){
            System.out.println("Не удалось получить данные из таблицы.");
        }
        return usersList;
    }

    public void cleanUsersTable() {
            try(Statement state = Util.getConnect().createStatement()) {
                state.execute("TRUNCATE users");
            } catch (SQLException e) {
                System.out.println("Не удалось очистить таблицу.");
            }
    }
}
