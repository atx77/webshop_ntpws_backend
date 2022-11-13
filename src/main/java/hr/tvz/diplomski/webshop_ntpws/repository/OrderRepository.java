package hr.tvz.diplomski.webshop_ntpws.repository;

import hr.tvz.diplomski.webshop_ntpws.domain.Order;
import hr.tvz.diplomski.webshop_ntpws.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByCodeEquals(String code);
    List<Order> findAllByUserEqualsOrderByCreationDateDesc(User user);
}
