package main.services;

import main.models.dao.UserDao;
import main.models.dao.UserDaoImpl;
import main.models.pojo.User;
import org.apache.log4j.Logger;

/**
 * Created by admin on 21.04.2017.
 */
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    private static UserDao userDao = new UserDaoImpl();

    public User auth(String login, String password) {
        User user = userDao.findUserByLoginAndPassword(login, password);

        if (user == null) {
            return null;
        }

        return user;
    }
}
