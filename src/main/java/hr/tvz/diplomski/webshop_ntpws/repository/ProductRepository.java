package hr.tvz.diplomski.webshop_ntpws.repository;

import hr.tvz.diplomski.webshop_ntpws.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}
