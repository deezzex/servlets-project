/**
 * @author deezzex <3
 */


package com.deezzex.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private Long id;
    private String productName;
    private Double price;
    private Integer count;
    private LocalDate deliveryDate;
    private Long categoryId;
    private Long commentId;
    private Long producerId;
}
