/**
 * @author deezzex <3
 */


package com.deezzex.entity.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class ProductDto {
    Long id;
    String productName;
    Double price;
    Integer count;
    LocalDate deliveryDate;
    Long categoryId;
    Long commentId;
    Long producerId;
}
