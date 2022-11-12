package hr.tvz.diplomski.webshop_ntpws.converter;

import hr.tvz.diplomski.webshop_ntpws.domain.Product;
import hr.tvz.diplomski.webshop_ntpws.dto.ProductDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductDtoConverter implements Converter<Product, ProductDto> {

    @Override
    public ProductDto convert(Product source) {
        ProductDto productDto = new ProductDto();
        productDto.setCode(source.getId());
        productDto.setName(source.getName());
        productDto.setDescription(source.getDescription());
        productDto.setSummary(source.getSummary());
        productDto.setRegularPrice(source.getRegularPrice());
        productDto.setActionPrice(source.getActionPrice());
        productDto.setDiscountPercentage(source.getDiscountPercentage());
        productDto.setAvailableQuantity(source.getAvailableQuantity());
        productDto.setImageUrl(source.getImageUrl());
        productDto.setBrand(source.getBrand() != null ? source.getBrand().getName() : null);
        return productDto;
    }
}
