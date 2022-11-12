package hr.tvz.diplomski.webshop_ntpws.service;

import hr.tvz.diplomski.webshop_ntpws.domain.Category;
import hr.tvz.diplomski.webshop_ntpws.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryDto> getAllParentCategories();

    Optional<Category> getCategoryForId(Long id);
}
