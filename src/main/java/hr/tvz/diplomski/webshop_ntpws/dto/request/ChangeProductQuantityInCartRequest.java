package hr.tvz.diplomski.webshop_ntpws.dto.request;

import lombok.Data;

@Data
public class ChangeProductQuantityInCartRequest {
    Long productCode;
    Integer quantity;
}
