package com.histoguia_backend.Histoguia.repository;
import com.histoguia_backend.Histoguia.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ThemeRepository extends JpaRepository<Theme, Long> {

    @Query("SELECT t FROM Theme t ORDER BY t.id ASC")
    List<Theme> findAllOrderedById();
    Optional<Theme> findByName(String name);
    Optional<Theme> findById(Long id);
}
