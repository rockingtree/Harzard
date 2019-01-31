package dao.impl;

import dao.BaseDao;
import dao.UserDao;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getAll() {
        BaseDao baseDao = new BaseDao();
        ResultSet resultSet = baseDao.executeQuery("select name,password from user");
        List<User> users=new ArrayList<>();
        try {
            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        baseDao.closeAll();
        return users;
    }
}
