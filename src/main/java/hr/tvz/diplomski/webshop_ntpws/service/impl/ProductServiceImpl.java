package hr.tvz.diplomski.webshop_ntpws.service.impl;

import hr.tvz.diplomski.webshop_ntpws.domain.Brand;
import hr.tvz.diplomski.webshop_ntpws.domain.Category;
import hr.tvz.diplomski.webshop_ntpws.domain.Product;
import hr.tvz.diplomski.webshop_ntpws.dto.ProductDto;
import hr.tvz.diplomski.webshop_ntpws.enumeration.SortType;
import hr.tvz.diplomski.webshop_ntpws.repository.ProductRepository;
import hr.tvz.diplomski.webshop_ntpws.service.BrandService;
import hr.tvz.diplomski.webshop_ntpws.service.CategoryService;
import hr.tvz.diplomski.webshop_ntpws.service.ProductService;
import hr.tvz.diplomski.webshop_ntpws.util.ProductSearchSortBuilder;
import hr.tvz.diplomski.webshop_ntpws.util.ProductSearchSpecificationBuilder;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductRepository productRepository;

    @Resource
    private CategoryService categoryService;

    @Resource
    private BrandService brandService;

    @Resource
    private ConversionService conversionService;

    @Resource
    private ProductSearchSpecificationBuilder productSearchSpecificationBuilder;

    @Resource
    private ProductSearchSortBuilder productSearchSortBuilder;

    @Override
    public ProductDto getForId(Long productId) {
        return conversionService.convert(productRepository.findById(productId).orElse(null), ProductDto.class);
    }

    @Override
    public Optional<Product> getModelForId(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public List<ProductDto> getAllProductsInCategoryAndFilter(Long categoryId, List<String> brandNames,
                                                              BigDecimal minPrice, BigDecimal maxPrice,
                                                              boolean isOnSale, SortType sortType) {
        Optional<Category> category = categoryService.getCategoryForId(categoryId);
        if (!category.isPresent()) {
            throw new IllegalArgumentException("No category with code " + categoryId);
        }

        List<Brand> brands = new ArrayList<>();
        if (brandNames != null) {
            brands = brandService.getBrandsForNames(brandNames);
        }

        List<Category> parentAndChildCategories = new ArrayList<>();
        parentAndChildCategories.add(category.get());
        parentAndChildCategories.addAll(category.get().getSubCategories());
        Specification<Product> productSpecification = productSearchSpecificationBuilder.build(parentAndChildCategories,
                brands, minPrice, maxPrice, isOnSale, null);
        Sort sort = productSearchSortBuilder.build(sortType);

        return (List<ProductDto>) conversionService.convert(productRepository.findAll(productSpecification, sort),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Product.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ProductDto.class)));
    }

    @Override
    public List<ProductDto> findAllProductsByTextAndFilter(String searchText, List<String> brandNames, BigDecimal minPrice,
                                                           BigDecimal maxPrice, boolean isOnSale, SortType sortType) {
        List<Brand> brands = new ArrayList<>();
        if (brandNames != null) {
            brands = brandService.getBrandsForNames(brandNames);
        }

        Specification<Product> productSpecification = productSearchSpecificationBuilder.build(null,
                brands, minPrice, maxPrice, isOnSale, searchText);
        Sort sort = productSearchSortBuilder.build(sortType);

        return (List<ProductDto>) conversionService.convert(productRepository.findAll(productSpecification, sort),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Product.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ProductDto.class)));
    }

    @Override
    public List<ProductDto> findNewestProducts() {
        return (List<ProductDto>) conversionService.convert(productRepository.findTop5ByActiveIsTrueOrderByCreationDateDesc(),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Product.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ProductDto.class)));
    }
}
