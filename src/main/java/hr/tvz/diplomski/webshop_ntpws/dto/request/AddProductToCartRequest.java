package hr.tvz.diplomski.webshop_ntpws.dto.request;

import lombok.Data;

@Data
public class AddProductToCartRequest {
    Long productCode;
    Integer quantity;
}
