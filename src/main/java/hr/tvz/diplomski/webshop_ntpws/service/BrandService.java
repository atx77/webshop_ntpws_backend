package hr.tvz.diplomski.webshop_ntpws.service;

import hr.tvz.diplomski.webshop_ntpws.domain.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getBrandsForNames(List<String> brandNames);
}
