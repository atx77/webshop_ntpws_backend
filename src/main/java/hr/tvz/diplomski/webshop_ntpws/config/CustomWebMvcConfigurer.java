package hr.tvz.diplomski.webshop_ntpws.config;

import hr.tvz.diplomski.webshop_ntpws.converter.CategoryToCategoryDtoConverter;
import hr.tvz.diplomski.webshop_ntpws.converter.ProductToProductDtoConverter;
import hr.tvz.diplomski.webshop_ntpws.converter.UserToUserDtoConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Resource
    private CategoryToCategoryDtoConverter categoryToCategoryDtoConverter;

    @Resource
    private UserToUserDtoConverter userToUserDtoConverter;

    @Resource
    private ProductToProductDtoConverter productToProductDtoConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(categoryToCategoryDtoConverter);
        registry.addConverter(userToUserDtoConverter);
        registry.addConverter(productToProductDtoConverter);
    }
}
