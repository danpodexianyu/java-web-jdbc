package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 注册驱动
        // MySQL 5之后的版本可以省略这个注册驱动的步骤
        // 将自动加载jar包中META-INF/services/java.sql.Driver文件中的驱动类
        // Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db_java_web";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 定义sql
        String sql = "UPDATE account SET money = 2000 where id = 1";

        // 4. 获取执行sql的对象
        Statement stmt = conn.createStatement();

        // 5. 执行sql
        int affectedRows = stmt.executeUpdate(sql);

        // 6. 释放资源
        stmt.close();
        conn.close();
    }
}