
package com.histoguia_backend.Histoguia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String answer;

    @Column(nullable = true)
    private String explication;

    @Column(nullable = false)
    private boolean corret;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getExplication() {
        return explication;
    }

    public void setExplication(String explication) {
        this.explication = explication;
    }

    public boolean isCorret() {
        return corret;
    }

    public void setCorret(boolean corret) {
        this.corret = corret;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion( Question question) {
        this.question = question;
    }
}