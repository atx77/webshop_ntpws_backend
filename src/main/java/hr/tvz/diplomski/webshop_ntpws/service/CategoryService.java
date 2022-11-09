package hr.tvz.diplomski.webshop_ntpws.service;

import hr.tvz.diplomski.webshop_ntpws.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllParentCategories();
}
