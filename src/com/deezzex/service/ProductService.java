/**
 * @author deezzex <3
 */


package com.deezzex.service;

import com.deezzex.dao.ProductDao;
import com.deezzex.entity.dto.ProductDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductService {

    private static final ProductService INSTANCE = new ProductService();

    private final ProductDao productDao = ProductDao.getInstance();

    public List<ProductDto> findAll(){
        return productDao.findAll().stream()
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .productName(product.getProductName())
                        .price(product.getPrice())
                        .count(product.getCount())
                        .deliveryDate(product.getDeliveryDate())
                        .categoryId(product.getCategoryId())
                        .commentId(product.getCommentId())
                        .producerId(product.getProducerId())
                        .build()
                ).collect(toList());
    }

    public static ProductService getInstance() {
        return INSTANCE;
    }
}
