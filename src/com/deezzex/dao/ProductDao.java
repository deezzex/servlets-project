/**
 * @author deezzex <3
 */


package com.deezzex.dao;

import com.deezzex.entity.Product;
import com.deezzex.util.ConnectionManager;
import lombok.SneakyThrows;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDao implements Dao<Long, Product>{

    private static final ProductDao INSTANCE = new ProductDao();

    private static final String FIND_ALL = """
            SELECT id, productName, price, count, deliveryDate, categoryId, commentId, producerId 
            FROM servlets_project.product
            """;

    @SneakyThrows
    @Override
    public List<Product> findAll() {
        try (var connection = ConnectionManager.getConnection()) {
            var preparedStatement = connection.prepareStatement(FIND_ALL);
            var resultSet = preparedStatement.executeQuery();

            List<Product> products = new ArrayList<>();

            while (resultSet.next()){
                products.add(buildProduct(resultSet));
            }
            return products;
        }
    }

    @SneakyThrows
    private Product buildProduct(ResultSet resultSet){
        return Product.builder()
                .id(resultSet.getObject("id", Long.class))
                .productName(resultSet.getObject("productName", String.class))
                .price(resultSet.getObject("price", Double.class))
                .count(resultSet.getObject("count", Integer.class))
                .deliveryDate(resultSet.getObject("deliveryDate", Date.class).toLocalDate())
                .categoryId(resultSet.getObject("categoryId", Long.class))
                .commentId(resultSet.getObject("commentId", Long.class))
                .producerId(resultSet.getObject("producerId", Long.class))
                .build();
    }

    @Override
    public Optional<Product> findById() {
        return Optional.empty();
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public Product save(Product entity) {
        return null;
    }

    public static ProductDao getInstance() {
        return INSTANCE;
    }
}
