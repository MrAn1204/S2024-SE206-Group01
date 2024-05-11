package se206.group01.mobileworld.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import se206.group01.mobileworld.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
