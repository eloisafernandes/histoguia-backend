package com.histoguia_backend.Histoguia.repository;

import com.histoguia_backend.Histoguia.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByThemeId(Long themeId);


}