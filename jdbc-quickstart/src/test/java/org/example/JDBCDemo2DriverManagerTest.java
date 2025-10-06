package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class JDBCDemo2DriverManagerTest {

    @Test
    void testDriverManager() throws SQLException {
        String url = "jdbc:mysql:///db_java_web";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 定义sql
        String sql = "UPDATE account SET money = 3000 where id = 1";

        // 4. 获取执行sql的对象
        Statement stmt = conn.createStatement();

        // 5. 执行sql
        int affectedRows = stmt.executeUpdate(sql);

        // 6. 释放资源
        stmt.close();
        conn.close();
    }
}