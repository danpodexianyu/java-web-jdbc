package org.example.service.impl;

import org.example.pojo.Brand;
import org.example.service.BrandService;
import org.example.util.DruidUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandServiceImpl implements BrandService {

    private DataSource dataSource = DruidUtils.getDataSource();

    @Override
    public List<Brand> getAll() {
        List<Brand> brands = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            String sql = "select * from tb_brand";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Brand brand = new Brand();
                    brand.setId(rs.getInt("id"));
                    brand.setBrandName(rs.getString("brand_name"));
                    brand.setCompanyName(rs.getString("company_name"));
                    brand.setOrdered(rs.getInt("ordered"));
                    brand.setDescription(rs.getString("description"));
                    brand.setStatus(rs.getInt("status"));
                    brands.add(brand);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return brands;
    }
}
