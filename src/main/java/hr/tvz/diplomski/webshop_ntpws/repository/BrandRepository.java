package hr.tvz.diplomski.webshop_ntpws.repository;

import hr.tvz.diplomski.webshop_ntpws.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Optional<Brand> findByNameEquals(String name);
    List<Brand> findAllByNameIn(List<String> names);
}
