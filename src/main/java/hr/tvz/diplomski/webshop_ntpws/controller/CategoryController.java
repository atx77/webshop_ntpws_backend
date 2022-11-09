package hr.tvz.diplomski.webshop_ntpws.controller;

import hr.tvz.diplomski.webshop_ntpws.dto.CategoryDto;
import hr.tvz.diplomski.webshop_ntpws.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public List<CategoryDto> getAllParent() {
        return categoryService.getAllParentCategories();
    }
}
