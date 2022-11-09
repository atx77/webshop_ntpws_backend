package hr.tvz.diplomski.webshop_ntpws.service;

import hr.tvz.diplomski.webshop_ntpws.domain.Category;
import hr.tvz.diplomski.webshop_ntpws.dto.CategoryDto;
import hr.tvz.diplomski.webshop_ntpws.repository.CategoryRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    @Resource
    private ConversionService conversionService;

    @Override
    public List<CategoryDto> getAllParentCategories() {
        return (List<CategoryDto>) conversionService.convert(categoryRepository.findAllByParentCategoryIsNullAndActiveIsTrue(),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Category.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CategoryDto.class)));
    }
}
