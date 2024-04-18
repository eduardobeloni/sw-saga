package com.example.swsaga.usecase;

import java.util.List;
import java.util.Optional;

import com.example.swsaga.domain.SwApiFilm;

public interface SwSagaUseCase {

    List<SwApiFilm> listFilms();
    Optional<SwApiFilm> filmDetails(int episode);
    void updateFilm(int episode, String description);
}
