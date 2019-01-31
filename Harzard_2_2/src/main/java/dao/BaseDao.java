package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

public class BaseDao {
    //获取四个连接参数
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    static {
        //读取properties文件的操作
        Properties properties = new Properties();
        //获取properties文件在classpath下的InputStream
        InputStream is = BaseDao.class.getResourceAsStream("/database.properties");
        try {
            properties.load(is);
            //通过文件中的参数名获取参数值
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取连接
    private void getConnection() {
        //加载驱动类
        try {
            Class.forName(driver);
            //获取连接
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("---> 数据库连接成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //执行DQL
    public ResultSet executeQuery(String sql, Objects... objects) {
        getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }
            resultSet = preparedStatement.executeQuery();
            //closeAll();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //执行DML
    public int executeUpdate(String sql, Objects... objects) {
        getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }
            //closeAll();
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //关闭连接
    public void closeAll() {
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
            System.out.println("---> 数据库连接已关闭");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
