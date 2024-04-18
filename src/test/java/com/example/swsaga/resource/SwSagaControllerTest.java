package com.example.swsaga.resource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.example.swsaga.domain.SwApiFilm;
import com.example.swsaga.usecase.SwSagaUseCase;

@ExtendWith(MockitoExtension.class)
public class SwSagaControllerTest {

    @InjectMocks
    private SwSagaController controller;

    @Mock
    private SwSagaUseCase useCase;

    @Mock
    private SwApiFilm film;

    private List<Integer> episodes = List.of(1, 2, 3, 4, 5, 6, 999);
    private final String DESCRIPTION = "Save the King";

    @Test
    void listFilmsTest() {
        final var films = assertDoesNotThrow(() -> controller.listFilms());
        assertNotNull(films);
    }

    @Test
    void detailFilmTest() {
        when(useCase.filmDetails(AdditionalMatchers.leq(6))).thenReturn(Optional.of(film));
        episodes.forEach(ep -> {
            final var response = assertDoesNotThrow(() -> controller.detailFilm(ep));
            assertNotNull(response);
            if (ep > 6) {
                assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
            } else {
                assertEquals(HttpStatus.OK, response.getStatusCode());
            }
        });
    }

    @Test
    void updateFilmTest() {
        when(useCase.filmDetails(AdditionalMatchers.leq(6))).thenReturn(Optional.of(film));
        when(film.getDescription()).thenReturn(DESCRIPTION);
        episodes.forEach(ep -> {
            final var response = assertDoesNotThrow(() -> controller.updateFilm(ep, DESCRIPTION));
            assertNotNull(response);
            if (ep > 6) {
                assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
            } else {
                assertEquals(HttpStatus.OK, response.getStatusCode());
                assertEquals(DESCRIPTION, response.getBody().getDescription());
            }
        });
    }
}
