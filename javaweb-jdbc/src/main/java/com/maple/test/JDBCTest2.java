package com.maple.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * author: maple_w
 * date: 2023/2/15 周三
 */
public class JDBCTest2 {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
        String username = "root";
        String passowrd = "";
        
        // 1. 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2. 连接数据库
        Connection connection = DriverManager.getConnection(url, username, passowrd);
        // 3. 编写SQL
        String sql = "insert into users(user_id, user_name, user_password, user_email, user_birthday) values (?,?,?,?,?)";
        // 4. 预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        
        ps.setInt(1, 4);
        ps.setString(2, "丁");
        ps.setString(3, "123456");
        ps.setString(4, "d@qq.com");
        ps.setDate(5, new Date(new java.util.Date().getTime()));
        
        // 5. 执行修改SQL 返回影响的行数
        int i = ps.executeUpdate();
        System.out.println(i);

        // 6. 关闭连接，释放资源 先开后关
        ps.close();
        connection.close();
    }
}
