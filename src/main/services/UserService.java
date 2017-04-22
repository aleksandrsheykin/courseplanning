package main.services;

import main.models.pojo.User;

/**
 * Created by admin on 21.04.2017.
 */
public interface UserService {

    public User auth(String login, String password);
    public boolean registration(String mail, String password, String firstName, String lastName, Integer limit);
}
