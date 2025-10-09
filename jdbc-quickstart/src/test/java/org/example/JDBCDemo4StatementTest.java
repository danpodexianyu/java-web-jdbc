package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class JDBCDemo4StatementTest {

    @Test
    void testDML() {
        String url = "jdbc:mysql:///db_java_web";
        String username = "root";
        String password = "123456";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            String sql = "UPDATE account SET money = 4000 where id = 1";

            int affectedRows = stmt.executeUpdate(sql);

            if (affectedRows > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testDDL() {
        String url = "jdbc:mysql:///db_java_web";
        String username = "root";
        String password = "123456";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            String sql = "create database db_java_web_2";

            stmt.executeUpdate(sql); // 执行成功也可能返回0
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}