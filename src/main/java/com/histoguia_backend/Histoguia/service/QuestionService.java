package com.histoguia_backend.Histoguia.service;

import com.histoguia_backend.Histoguia.model.Question;
import com.histoguia_backend.Histoguia.repository.AnswerRepository;
import com.histoguia_backend.Histoguia.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    public List<Question> getQuestionsByThemeId(Long themeId, int numberOfQuestions) {
        List<Question> questions = questionRepository.findByThemeId(themeId);


        if (questions.size() > numberOfQuestions) {
            return questions.subList(0, numberOfQuestions);
        }
        return questions;
    }


}