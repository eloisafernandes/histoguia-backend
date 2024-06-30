package com.histoguia_backend.Histoguia.repository;

import com.histoguia_backend.Histoguia.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}