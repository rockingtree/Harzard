package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void addUser(String username, String password) {
        userDao.addUser(username,password);
    }
}
