package com.example.swsaga.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.swsaga.domain.SwApiFilm;
import com.example.swsaga.usecase.SwSagaUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SwSagaController {

    private final SwSagaUseCase useCase;

    @GetMapping("/films/list")
    public List<SwApiFilm> listFilms() {
        return useCase.listFilms();
    }

    @GetMapping("/films/detail/{episode}")
    public SwApiFilm detailFilm(@PathVariable int episode) {
        return useCase.filmDetails(episode);
    }

    @PatchMapping("/films/update/{episode}")
    public SwApiFilm updateFilm(@PathVariable int episode, @RequestBody String description) {
        useCase.updateFilm(episode, description);
        return useCase.filmDetails(episode);
    }
}
