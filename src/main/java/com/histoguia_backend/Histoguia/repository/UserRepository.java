package com.histoguia_backend.Histoguia.repository;
import com.histoguia_backend.Histoguia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}