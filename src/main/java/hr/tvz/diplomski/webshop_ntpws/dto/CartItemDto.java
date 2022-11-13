package hr.tvz.diplomski.webshop_ntpws.dto;

import lombok.Data;

@Data
public class CartItemDto {
    private ProductDto product;
    private Integer quantity;
}
