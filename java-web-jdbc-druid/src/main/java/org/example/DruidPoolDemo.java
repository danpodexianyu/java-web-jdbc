package org.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DruidPoolDemo {
    private static DataSource dataSource = null;

    static {
        Properties properties = new Properties();
        InputStream inputStream = DruidPoolDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectData() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "select * from tb_user";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Long id = rs.getLong("id");
                    String name = rs.getString("username");
                    System.out.printf("id = %s, username = %s;", id, name);
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        DruidPoolDemo demo = new DruidPoolDemo();
        demo.selectData();
    }
}