package com.histoguia_backend.Histoguia.seeder;


import com.histoguia_backend.Histoguia.model.Answer;
import com.histoguia_backend.Histoguia.model.Question;
import com.histoguia_backend.Histoguia.model.Theme;
import com.histoguia_backend.Histoguia.repository.AnswerRepository;
import com.histoguia_backend.Histoguia.repository.QuestionRepository;
import com.histoguia_backend.Histoguia.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

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
//            Theme theme3 = new Theme();
//            theme3.setName("Tecido Conjuntivo Propriamente Dito");
//            themeRepository.save(theme3);
//
//            Theme theme4 = new Theme();
//            theme4.setName("Tecido Conjuntivo Denso");
//            themeRepository.save(theme4);
//
//            Theme theme5 = new Theme();
//            theme5.setName("Tecido Muscular Estriado Esquelético");
//            themeRepository.save(theme5);
//
//            Theme theme6 = new Theme();
//            theme6.setName("Tecido Muscular Liso");
//            themeRepository.save(theme6);
//
//            Theme theme7 = new Theme();
//            theme7.setName("Tecido Nervoso");
//            themeRepository.save(theme7);
//
//            Theme theme8 = new Theme();
//            theme8.setName("Cartilagem Hialina");
//            themeRepository.save(theme8);

//            Question question1 = new Question();
//            question1.setStatement("Qual é a função principal do epitélio estratificado?");
//            question1.setTheme(theme1);
//            questionRepository.save(question1);
//
//            Answer answer1Q1 = new Answer();
//            answer1Q1.setAnswer("Proteger tecidos subjacentes contra abrasões e desgaste mecânico.");
//            answer1Q1.setExplication("Correta. O epitélio estratificado é geralmente encontrado em áreas do corpo que estão sujeitas a desgaste mecânico, como a pele, atuando como uma barreira protetora.");
//            answer1Q1.setCorret(true);
//            answer1Q1.setQuestion(question1);
//            answerRepository.save(answer1Q1);
//
//            Answer answer2Q1 = new Answer();
//            answer2Q1.setAnswer("Regular a troca de gases respiratórios nos pulmões.");
//            answer2Q1.setExplication("Incorreta. Esta função é desempenhada principalmente pelo epitélio respiratório presente nos pulmões, não pelo epitélio estratificado.");
//            answer2Q1.setCorret(false);
//            answer2Q1.setQuestion(question1);
//            answerRepository.save(answer2Q1);
//
//            Answer answer3Q1 = new Answer();
//            answer3Q1.setAnswer("Absorver nutrientes do ambiente externo para o corpo.");
//            answer3Q1.setExplication("Incorreta. A absorção de nutrientes geralmente ocorre através de epitélios especializados, como o epitélio intestinal, não pelo epitélio estratificado.\n");
//            answer3Q1.setCorret(false);
//            answer3Q1.setQuestion(question1);
//            answerRepository.save(answer3Q1);
//
//            Answer answer4Q1 = new Answer();
//            answer4Q1.setAnswer("Secretar hormônios para regular funções corporais.");
//            answer4Q1.setExplication("Incorreta. A secreção hormonal é realizada por glândulas especializadas, não pelo epitélio estratificado.");
//            answer4Q1.setCorret(false);
//            answer4Q1.setQuestion(question1);
//            answerRepository.save(answer4Q1);


        };
    }
}