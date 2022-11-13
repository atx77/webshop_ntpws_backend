package hr.tvz.diplomski.webshop_ntpws.converter;

import hr.tvz.diplomski.webshop_ntpws.domain.CartItem;
import hr.tvz.diplomski.webshop_ntpws.dto.CartItemDto;
import org.springframework.core.convert.converter.Converter;

public class CartItemToCartItemDtoConverter implements Converter<CartItem, CartItemDto> {

    @Override
    public CartItemDto convert(CartItem source) {
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setQuantity(source.getQuantity());

        ProductToProductDtoConverter productToProductDtoConverter = new ProductToProductDtoConverter();
        cartItemDto.setProduct(productToProductDtoConverter.convert(source.getProduct()));
        return cartItemDto;
    }
}
