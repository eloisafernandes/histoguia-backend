package com.histoguia_backend.Histoguia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "subThemes")
public class SubTheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;

}
