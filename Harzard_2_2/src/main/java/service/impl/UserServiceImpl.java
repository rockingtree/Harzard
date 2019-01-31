package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAll() {
        UserDao userDao=new UserDaoImpl();
        return userDao.getAll();
    }
}
