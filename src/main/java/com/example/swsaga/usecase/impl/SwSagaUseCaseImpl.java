package com.example.swsaga.usecase.impl;

import org.springframework.stereotype.Service;

import com.example.swsaga.usecase.SwSagaUseCase;
import com.example.swsaga.utils.JsonUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SwSagaUseCaseImpl implements SwSagaUseCase {

    private final JsonUtils utils;

    @Override
    public String retrieveFilmList() {
        return utils.loadFileSafe("films.json")
                .orElse("Ooops... Something went wrong :(");
    }
}
