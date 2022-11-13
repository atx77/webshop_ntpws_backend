package hr.tvz.diplomski.webshop_ntpws.service;

import hr.tvz.diplomski.webshop_ntpws.domain.Product;
import hr.tvz.diplomski.webshop_ntpws.dto.ProductDto;
import hr.tvz.diplomski.webshop_ntpws.enumeration.SortType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getModelForId(Long productId);

    List<ProductDto> getAllProductsInCategoryAndFilter(Long categoryId, List<String> brandNames, BigDecimal minPrice,
                                                       BigDecimal maxPrice, boolean isOnSale, SortType sortType);

    List<ProductDto> findAllProductsByTextAndFilter(String searchText, List<String> brandNames, BigDecimal minPrice,
                                                 BigDecimal maxPrice, boolean isOnSale, SortType sortType);

    ProductDto getForId(Long productId);

    List<ProductDto> findNewestProducts();
}
