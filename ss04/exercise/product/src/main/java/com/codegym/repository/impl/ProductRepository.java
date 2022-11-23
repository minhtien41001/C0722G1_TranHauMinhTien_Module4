package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static final Map<Integer,Product> productList;

    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "Cafe", 50000, "no", "Trung Nguyen"));
        productList.put(2, new Product(2, "Tra sua", 5000, "no", "Bong"));
        productList.put(3, new Product(3, "Thuoc la", 3000, "no", "Thang Long"));
        productList.put(4, new Product(4, "Banh bong lan", 15000, "no", "..."));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();

        for (Product item : productList.values()){
            if (item.getName().contains(name)){
                products.add(item);
            }
        }
        return products;
    }
}
