package com.histoguia_backend.Histoguia.controller;

import com.histoguia_backend.Histoguia.model.Theme;
import com.histoguia_backend.Histoguia.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/theme")
public class ThemeController {
    @Autowired
    private ThemeRepository themeRepository;

    @GetMapping
    public List<Theme> getAllThemes() {
        return themeRepository.findAllOrderedById();
    }

    @GetMapping("/by-name")
    public @ResponseBody Optional<Long> getThemeIdByName(@RequestParam String name) {
        return themeRepository.findByName(name).map(Theme::getId);
    }
}
