package main.models.dao;

import main.models.connection.DBConnection;
import main.models.pojo.User;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
public class UserDaoImpl implements UserDao {

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    public List<User> getAll() {
        Connection connection = DBConnection.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *"+
                    " from users");

            ResultSet result = preparedStatement.executeQuery();

            List<User> listUser = new ArrayList<User>();
            while (result.next()) {
                listUser.add(new User(
                        result.getInt("user_id"),
                        result.getString("user_firstName"),
                        result.getString("user_lastName"),
                        result.getString("user_mail"),
                        result.getString("user_password"),
                        result.getInt("user_limit"),
                        result.getBoolean("user_is_admin"))
                );
            }
            return listUser;

        } catch (SQLException e) {
            logger.warn("SQLException in User.getAll()");
            return null;
        }
    }

    public User get(int id) {
        Connection connection = DBConnection.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *"+
                    " from users where user_id=?");
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            return new User(
                    result.getInt("user_id"),
                    result.getString("user_firstName"),
                    result.getString("user_lastName"),
                    result.getString("user_mail"),
                    result.getString("user_password"),
                    result.getInt("user_limit"),
                    result.getBoolean("user_is_admin")
            );

        } catch (SQLException e) {
            logger.warn("SQLException in User.get()");
            return null;
        }
    }

    public boolean update(User user) {
        Connection connection = DBConnection.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET(" +
                    " user_firstName, user_lastName, user_mail, user_password, user_limit, user_is_admin)" +
                    " = (?, ?, ?, ?, ?, ?) WHERE id = ?");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getMail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getLimit());
            preparedStatement.setBoolean(6, user.isIs_admin());
            preparedStatement.setInt(7, user.getId_user());
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            logger.warn("SQLException in User.update()");
            return false;
        }
    }

    public boolean delete(User user) {
        Connection connection = DBConnection.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from users " +
                    " WHERE id = ?");
            preparedStatement.setInt(1, user.getId_user());
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            logger.warn("SQLException in User.delete()");
            return false;
        }
    }

    public boolean insert(User user) {
        Connection connection = DBConnection.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert users (" +
                    " user_firstName, user_lastName, user_mail, user_password, user_limit, user_is_admin, user_id)" +
                    " = (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getMail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getLimit());
            preparedStatement.setBoolean(6, user.isIs_admin());
            preparedStatement.setInt(7, user.getId_user());
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            logger.warn("SQLException in User.insert()");
            return false;
        }
    }

    public User findUserByLoginAndPassword(String login, String password) {
        Connection connection = DBConnection.initConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from users where user_mail = ? and user_password = ?");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                return new User(
                        result.getInt("user_id"),
                        result.getString("user_firstname"),
                        result.getString("user_lastname"),
                        result.getString("user_mail"),
                        result.getString("user_password"),
                        result.getInt("user_limit"),
                        result.getBoolean("user_is_admin")
                );
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
