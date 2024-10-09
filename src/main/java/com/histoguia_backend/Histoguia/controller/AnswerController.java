package com.histoguia_backend.Histoguia.controller;

import com.histoguia_backend.Histoguia.model.Answer;
import com.histoguia_backend.Histoguia.repository.AnswerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.elasticsearch.ResourceNotFoundException;
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

    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<Answer>> getAnswersByQuestionId(@PathVariable Long questionId) {
        List<Answer> answers = answerRepository.findByQuestionId(questionId);
        if (answers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(answers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable Long id, @Valid @RequestBody Answer updatedAnswer) {
        Answer existingAnswer = answerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Answer not found with id: " + id));

        existingAnswer.setAnswer(updatedAnswer.getAnswer());
        existingAnswer.setExplication(updatedAnswer.getExplication());
        existingAnswer.setCorret(updatedAnswer.isCorret());

        Answer savedAnswer = answerRepository.save(existingAnswer);
        return ResponseEntity.ok(savedAnswer);
    }





}
