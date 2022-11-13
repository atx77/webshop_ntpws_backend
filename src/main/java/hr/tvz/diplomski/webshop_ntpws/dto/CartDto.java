package hr.tvz.diplomski.webshop_ntpws.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartDto {
    private List<CartItemDto> cartItems;
    private BigDecimal totalPrice;
}
