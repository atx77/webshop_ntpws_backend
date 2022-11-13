package hr.tvz.diplomski.webshop_ntpws.repository;

import hr.tvz.diplomski.webshop_ntpws.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    List<Product> findTop5ByActiveIsTrueOrderByCreationDateDesc();
}
