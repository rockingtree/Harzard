package dao.impl;

import dao.BaseDao;
import dao.UserDao;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private BaseDao baseDao = new BaseDao();
    @Override
    public List<User> getAll() {
        ResultSet resultSet = baseDao.executeQuery("select name,password,type from user");
        List<User> users=new ArrayList<>();
        try {
            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setType(resultSet.getString(3));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        baseDao.closeAll();
        return users;
    }

    @Override
    public void addUser(String username, String password) {
        baseDao.executeUpdate("insert into user (name,password) values(?,?)",username,password);
    }
}
