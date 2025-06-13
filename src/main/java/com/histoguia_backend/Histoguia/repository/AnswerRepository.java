package com.histoguia_backend.Histoguia.repository;

import com.histoguia_backend.Histoguia.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionId(Long questionId);
}
