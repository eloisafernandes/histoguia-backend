package com.histoguia_backend.Histoguia.controller;

import com.histoguia_backend.Histoguia.model.Answer;
import com.histoguia_backend.Histoguia.model.Question;
import com.histoguia_backend.Histoguia.repository.AnswerRepository;
import com.histoguia_backend.Histoguia.repository.QuestionRepository;
import com.histoguia_backend.Histoguia.repository.ThemeRepository;
import com.histoguia_backend.Histoguia.model.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid question ID"));
        return ResponseEntity.ok(question);
    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        Theme theme = themeRepository.findById(question.getTheme().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid theme ID"));

        question.setTheme(theme);
        Question savedQuestion = questionRepository.save(question);

        return ResponseEntity.ok(savedQuestion);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid question ID"));


        List<Answer> answers = answerRepository.findByQuestionId(id);
        answerRepository.deleteAll(answers);

        questionRepository.delete(question);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question questionDetails) {
        return questionRepository.findById(id)
                .map(question -> {
                    question.setStatement(questionDetails.getStatement());
                    question.setTheme(questionDetails.getTheme());
                    Question updatedQuestion = questionRepository.save(question);
                    return ResponseEntity.ok(updatedQuestion);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}