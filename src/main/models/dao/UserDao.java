package main.models.dao;

import main.models.pojo.User;

import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
public interface UserDao {
    public List<User> getAll();
    public User get(int id);
    public boolean update(User user);
    public boolean delete(User user);
    public boolean insert(String firsName, String lastName, String mail, String password, Integer limit, boolean isAdmin, Integer idUser);
    public Integer insert(String firsName, String lastName, String mail, String password, Integer limit);
    User findUserByLoginAndPassword(String login, String password);
}