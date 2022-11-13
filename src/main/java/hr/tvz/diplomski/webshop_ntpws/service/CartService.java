package hr.tvz.diplomski.webshop_ntpws.service;

import hr.tvz.diplomski.webshop_ntpws.domain.Cart;
import hr.tvz.diplomski.webshop_ntpws.dto.CartDto;

public interface CartService {
    CartDto getCartForLoggedUser();

    void addProductToCart(Long productId, Integer quantity);
    void recalculateCartTotalPrice();
    void removeProductFromCart(Long productId);
    CartDto changeProductQuantityInCart(Long productId, Integer quantity);
    void clearCart(Cart cart);
}
