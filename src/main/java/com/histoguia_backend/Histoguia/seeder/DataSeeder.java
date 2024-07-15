package com.histoguia_backend.Histoguia.seeder;

import com.histoguia_backend.Histoguia.model.Question;
import com.histoguia_backend.Histoguia.model.Theme;
import com.histoguia_backend.Histoguia.repository.QuestionRepository;
import com.histoguia_backend.Histoguia.repository.ThemeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class DataSeeder {

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {
            // Seed themes
//            Theme theme1 = new Theme();
//            theme1.setName("Epitélio Simples");
//            themeRepository.save(theme1);
//
//            Theme theme2 = new Theme();
//            theme2.setName("Epitélio Estratificado");
//            themeRepository.save(theme2);
//
//            // Seed questions
//            Question question1 = new Question();
//            question1.setStatement("O que é história?");
//            question1.setTheme(theme1);
//            questionRepository.save(question1);
//
//            Question question2 = new Question();
//            question2.setStatement("O que é uma célula?");
//            question2.setTheme(theme2);
//            questionRepository.save(question2);
            //
        };
    }
}