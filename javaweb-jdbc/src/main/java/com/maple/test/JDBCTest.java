package com.maple.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * author: maple_w
 * date: 2023/2/2 周四
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        String username = "root";
        String passowrd = "";
        
        // 1. 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 连接数据库
        Connection connection = DriverManager.getConnection(url, username, passowrd);
        // 3. 向数据库发送SQL的对象 Statement : CRUD
        Statement statement = connection.createStatement();
        // 4. 编写SQL
        String sql = "select * from users";
        // 5. 执行查询SQL 返回 ResultSet 结果集
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Object userId = resultSet.getObject("user_id");
            Object userName = resultSet.getObject("user_name");
            Object userPassword = resultSet.getObject("user_password");
            Object userEmail = resultSet.getObject("user_email");
            Object userBirthday = resultSet.getObject("user_birthday");
            System.out.println(userId);
            System.out.println(userName);
            System.out.println(userPassword);
            System.out.println(userEmail);
            System.out.println(userBirthday);
            System.out.println("=========================");
        }
        // 6. 关闭连接，释放资源 先开后关
        resultSet.close();
        statement.close();
        connection.close();
    }
}
