package org.example.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DruidUtils {

    public static final String DRUID_PROPERTIES = "druid.properties";

    private static DataSource dataSource;

    static {
        Properties props = new Properties();
        InputStream inputStream = DruidUtils.class.getClassLoader().getResourceAsStream(DRUID_PROPERTIES);
        try {
            props.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
