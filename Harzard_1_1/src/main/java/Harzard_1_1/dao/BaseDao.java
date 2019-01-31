package Harzard_1_1.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * BaseDao提供程序向数据库的连接
 * 实现数据库的连接
 */
public class BaseDao {
    //读取main/resources目录下database.properties文件的数据
    //四个连接参数,都保存着properties文件中
    private static String driver;
    private static String url;
    private static String userName;
    private static String password;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    static {
        //static{}(即static块)，会在类被加载的时候执行且仅会被执行一次
        //读取properties文件的操作
        Properties properties = new Properties();
        //获取properties文件 在classpath下的InputStream
        InputStream is = BaseDao.class.getResourceAsStream(
                "/database.properties");
        //调用load方法,加载进properties对象中
        try {
            properties.load(is);
            //通过文件中的参数名获取参数值
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            userName = properties.getProperty("userName");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //1.获取连接的方法
    private void getConnection() {
        //加载驱动类
        try {
            Class.forName(driver);
            //获取连接
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("--->数据库已连接\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //2.执行DQL语句的方法
    //...为不定长(0~N个)参数 不定长参数只能位于参数列表的末尾
    //不定长参数可以作为Java数组
    //参数的顺序要求和?顺序一直
    protected ResultSet executeQuery(String sql, Object... objs) {
        //调用getConnection方法
        getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            //此处可以给sql字句中的?赋值
            //例如: select * from student where id=? and name=?;
            for (int i = 0; i < objs.length; i++) {
                preparedStatement.setObject(i + 1, objs[i]);
            }
            //将结果用resultSet接收
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            //此处可以用于撤销事物
            e.printStackTrace();
        }
        return null;
    }

    //3.执行DML语句的方法
    protected int executeUpdate(String sql, Object... objs) {
        //调用connection方法
        getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            //此处可以给sql字句中的?赋值
            //例如: insert into student values(?,?)
            for (int i = 0; i < objs.length; i++) {
                preparedStatement.setObject(i + 1, objs[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //4.关闭资源的方法
    protected void closeAll() {
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
            System.out.println("--->数据库连接已断开\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
