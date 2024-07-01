package com.histoguia_backend.Histoguia.controller;

import com.histoguia_backend.Histoguia.model.Answer;
import com.histoguia_backend.Histoguia.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    @Autowired
    private AnswerRepository answerRepository;

    @PostMapping
    public ResponseEntity<List<Answer>> createAnswers(@RequestBody List<Answer> answers) {
        List<Answer> savedAnswers = answerRepository.saveAll(answers);
        return ResponseEntity.ok(savedAnswers);
    }

}
