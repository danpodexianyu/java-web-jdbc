package org.example.service.impl;

import org.example.pojo.Brand;
import org.example.service.BrandService;
import org.junit.jupiter.api.Test;

import java.util.List;

class BrandServiceImplTest {

    private final BrandService brandService = new BrandServiceImpl();

    @Test
    void getAll() {
        List<Brand> brands = brandService.getAll();
        brands.stream().forEach(System.out::println);
    }
}