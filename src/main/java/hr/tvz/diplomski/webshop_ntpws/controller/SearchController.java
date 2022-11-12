package hr.tvz.diplomski.webshop_ntpws.controller;

import hr.tvz.diplomski.webshop_ntpws.dto.ProductDto;
import hr.tvz.diplomski.webshop_ntpws.dto.ProductFilterDto;
import hr.tvz.diplomski.webshop_ntpws.enumeration.SortType;
import hr.tvz.diplomski.webshop_ntpws.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/search")
@CrossOrigin(origins = "http://localhost:4200")
public class SearchController {

    @Resource
    private ProductService productService;

    @RequestMapping(value = "/{text}", method = RequestMethod.GET)
    public List<ProductDto> searchProducts(@PathVariable("text") final String searchText,
                                           @RequestParam(value = "brand", required = false) final List<String> brands,
                                           @RequestParam(value = "minPrice", required = false) final BigDecimal minPrice,
                                           @RequestParam(value = "maxPrice", required = false) final BigDecimal maxPrice,
                                           @RequestParam(value = "isOnSale", required = false, defaultValue = "false") final boolean isOnSale,
                                           @RequestParam(value = "sort", required = false) final SortType sortType) {
        return productService.findAllProductsByTextAndFilter(searchText, brands, minPrice, maxPrice, isOnSale, sortType);
    }

    @RequestMapping(value = "/{text}/all-filters", method = RequestMethod.GET)
    public ProductFilterDto getProductFilters(@PathVariable("text") final String searchText) {
        List<ProductDto> products = productService.findAllProductsByTextAndFilter(searchText, null, null, null, false, null);
        ProductFilterDto productFilterDto = new ProductFilterDto();
        productFilterDto.setBrands(products.stream().map(ProductDto::getBrand).filter(Objects::nonNull).collect(Collectors.toSet()));
        productFilterDto.setSortCodes(Arrays.stream(SortType.values()).map(SortType::name).distinct().collect(Collectors.toList()));
        return productFilterDto;
    }
}
