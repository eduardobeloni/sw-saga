package com.example.swsaga.usecase.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.swsaga.domain.SwApiFilm;
import com.example.swsaga.external.client.SwApiClient;
import com.example.swsaga.usecase.SwSagaUseCase;

@Service
public class SwSagaUseCaseImpl implements SwSagaUseCase {

    private final List<SwApiFilm> films;

    public SwSagaUseCaseImpl(SwApiClient client) {
        this.films = client.getFilms().getResults();
    }

    @Override
    public List<SwApiFilm> listFilms() {
        return films;
    }

    @Override
    public Optional<SwApiFilm> filmDetails(int episode) {
        return films.stream()
                .filter(film -> film.getEpisode() == episode)
                .findFirst();
    }

    @Override
    public void updateFilm(int episode, String description) {
        this.filmDetails(episode)
            .ifPresent(film -> {
                film.setDescription(description);
                film.setVersion(film.getVersion() + 1);
            });
    }
}
