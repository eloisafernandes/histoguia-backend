package com.histoguia_backend.Histoguia.repository;
import com.histoguia_backend.Histoguia.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
    Optional<Theme> findByName(String name);
    Optional<Theme> findById(Long id);
}
