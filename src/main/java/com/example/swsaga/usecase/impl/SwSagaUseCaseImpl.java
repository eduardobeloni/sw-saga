package com.example.swsaga.usecase.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.swsaga.domain.SwApiFilm;
import com.example.swsaga.domain.SwApiResponse;
import com.example.swsaga.usecase.SwSagaUseCase;
import com.example.swsaga.utils.DataUtils;

@Service
public class SwSagaUseCaseImpl implements SwSagaUseCase {

    private final DataUtils utils;
    private List<SwApiFilm> films;

    public SwSagaUseCaseImpl(DataUtils utils) {
        this.utils = utils;
        final String filmsJson = utils.loadFileSafe("films.json").orElse("");
        this.films = utils.toObjectSafe(filmsJson, SwApiResponse.class)
                .map(SwApiResponse::getResults)
                .orElse(List.of());
    }

    @Override
    public String retrieveFilmList() {
        return utils.loadFileSafe("films.json")
                .orElse("Ooops... Something went wrong :(");
    }

    @Override
    public List<SwApiFilm> listFilms() {
        return films;
    }
}
