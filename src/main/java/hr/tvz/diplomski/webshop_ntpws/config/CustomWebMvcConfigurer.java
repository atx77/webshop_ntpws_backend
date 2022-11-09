package hr.tvz.diplomski.webshop_ntpws.config;

import hr.tvz.diplomski.webshop_ntpws.converter.CategoryToCategoryDtoConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new CategoryToCategoryDtoConverter());
    }
}
