package com.example.swsaga.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swsaga.usecase.SwSagaUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SwSagaController {

    private final SwSagaUseCase useCase;

    @GetMapping("/films")
    public String films() {
        return useCase.retrieveFilmList();
    }
}
