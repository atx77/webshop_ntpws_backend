package hr.tvz.diplomski.webshop_ntpws.controller;

import hr.tvz.diplomski.webshop_ntpws.dto.CategoryDto;
import hr.tvz.diplomski.webshop_ntpws.dto.ProductDto;
import hr.tvz.diplomski.webshop_ntpws.dto.ProductFilterDto;
import hr.tvz.diplomski.webshop_ntpws.enumeration.SortType;
import hr.tvz.diplomski.webshop_ntpws.service.CategoryService;
import hr.tvz.diplomski.webshop_ntpws.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @Resource
    private ProductService productService;

    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public List<CategoryDto> getAllParent() {
        return categoryService.getAllParentCategories();
    }

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
    public List<ProductDto> getAllProductForCategoryAndFilters(@PathVariable("categoryId") Long categoryId,
                                                               @RequestParam(value = "brand", required = false) final List<String> brands,
                                                               @RequestParam(value = "minPrice", required = false) final BigDecimal minPrice,
                                                               @RequestParam(value = "maxPrice", required = false) final BigDecimal maxPrice,
                                                               @RequestParam(value = "isOnSale", required = false, defaultValue = "false") final boolean isOnSale,
                                                               @RequestParam(value = "sort", required = false) final SortType sortType) {
        return productService.getAllProductsInCategoryAndFilter(categoryId, brands, minPrice, maxPrice, isOnSale, sortType);
    }

    @RequestMapping(value = "/{categoryId}/all-filters", method = RequestMethod.GET)
    public ProductFilterDto getProductFilters(@PathVariable("categoryId") final Long categoryId) {
        List<ProductDto> products = productService.getAllProductsInCategoryAndFilter(categoryId, null, null, null, false, null);
        ProductFilterDto productFilterDto = new ProductFilterDto();
        productFilterDto.setBrands(products.stream().map(ProductDto::getBrand).filter(Objects::nonNull).collect(Collectors.toSet()));
        productFilterDto.setSortCodes(Arrays.stream(SortType.values()).map(SortType::name).collect(Collectors.toList()));
        return productFilterDto;
    }
}
