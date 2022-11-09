package hr.tvz.diplomski.webshop_ntpws.repository;

import hr.tvz.diplomski.webshop_ntpws.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailEquals(String email);
}
