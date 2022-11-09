package hr.tvz.diplomski.webshop_ntpws.converter;

import hr.tvz.diplomski.webshop_ntpws.domain.Category;
import hr.tvz.diplomski.webshop_ntpws.dto.CategoryDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CategoryToCategoryDtoConverter implements Converter<Category, CategoryDto> {

    @Override
    public CategoryDto convert(Category source) {
        CategoryDto dto = new CategoryDto();
        dto.setCode(source.getCode());
        dto.setActive(source.isActive());
        dto.setName(source.getName());
        dto.setSubCategories(
                source.getSubCategories()
                        .stream()
                        .filter(Objects::nonNull)
                        .map(this::convert)
                        .collect(Collectors.toList()));
        return dto;
    }
}
