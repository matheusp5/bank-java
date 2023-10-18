package dev.mxtheuz.bank.domain.repositories;

import dev.mxtheuz.bank.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, String> {
    User findUserByEmail(String email);
}
