package com.histoguia_backend.Histoguia.repository;
import com.histoguia_backend.Histoguia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String login);
}