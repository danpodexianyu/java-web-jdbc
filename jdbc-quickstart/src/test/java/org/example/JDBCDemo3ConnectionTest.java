package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class JDBCDemo3ConnectionTest {

    @Test
    void testTransaction() throws SQLException {
        String url = "jdbc:mysql:///db_java_web";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "UPDATE account SET money = 4000 where id = 1";
        String sql2 = "UPDATE account SET money = 3000 where id = 2";

        // 执行SQL
        Statement stmt = conn.createStatement();

        // 开启事务
        conn.setAutoCommit(false);

        try {
            int affectRows = stmt.executeUpdate(sql);
            System.out.printf("affected rows: %s%n", affectRows);

            // 模拟异常
            // int i = 1 / 0; // 这里将抛出异常, 导致事务回滚

            int affectRows2 = stmt.executeUpdate(sql2);
            System.out.printf("affected rows: %s%n", affectRows2);
        } catch (SQLException e) {
            conn.rollback();
        }

        // 提交事务
        conn.commit();

        stmt.close();
        conn.close();
    }
}