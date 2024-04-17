package com.example.swsaga.usecase.impl;

import org.springframework.stereotype.Service;

import com.example.swsaga.usecase.SwSagaUseCase;

@Service
public class SwSagaUseCaseImpl implements SwSagaUseCase {

    @Override
    public String retrieveFilmList() {
        return "Almost there mate";
    }
}
