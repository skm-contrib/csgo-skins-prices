package ua.csgo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.csgo.domain.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
