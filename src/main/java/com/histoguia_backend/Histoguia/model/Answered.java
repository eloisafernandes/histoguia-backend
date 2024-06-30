package com.histoguia_backend.Histoguia.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "answereds")
public class Answered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private boolean isSucess;

    @Column(nullable = false)
    private LocalDate date;


}
