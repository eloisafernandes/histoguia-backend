package com.histoguia_backend.Histoguia.controller;

import com.histoguia_backend.Histoguia.model.Question;
import com.histoguia_backend.Histoguia.repository.QuestionRepository;
import com.histoguia_backend.Histoguia.repository.ThemeRepository;
import com.histoguia_backend.Histoguia.model.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ThemeRepository themeRepository;

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        return ResponseEntity.ok(questions);
    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        Theme theme = themeRepository.findById(question.getTheme().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid theme ID"));

        question.setTheme(theme);
        Question savedQuestion = questionRepository.save(question);

        return ResponseEntity.ok(savedQuestion);
    }
}