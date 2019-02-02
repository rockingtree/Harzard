package dao;

import entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    void addUser(String username,String password);
}
