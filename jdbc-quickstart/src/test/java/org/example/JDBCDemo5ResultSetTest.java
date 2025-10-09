package org.example;

import org.example.pojo.Account;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class JDBCDemo5ResultSetTest {

    @Test
    void testResultSet() {
        String url = "jdbc:mysql:///db_java_web";
        String username = "root";
        String password = "123456";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            String sql = "select * from account";

            ResultSet rs = stmt.executeQuery(sql);

            List<Account> accounts = new ArrayList<>();
            // 处理结果
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double money = rs.getDouble("money");

                System.out.printf("id=%s, name=%s, money=%s", id, name, money);
                System.out.println();

                Account account = new Account();
                account.setId((long) id);
                account.setName(name);
                account.setMoney(money);

                accounts.add(account);
            }

            for (Account account : accounts) {
                System.out.println(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}