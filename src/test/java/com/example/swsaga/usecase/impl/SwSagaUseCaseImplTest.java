package com.example.swsaga.usecase.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.swsaga.domain.SwApiFilm;
import com.example.swsaga.domain.SwApiResponse;
import com.example.swsaga.external.client.SwApiClient;

@ExtendWith(MockitoExtension.class)
public class SwSagaUseCaseImplTest {

    private SwSagaUseCaseImpl useCase;

    @Mock
    private SwApiClient client;

    @Mock
    private SwApiResponse apiResponse;

    @Mock
    private SwApiFilm film;

    private List<SwApiFilm> films;
    private List<Integer> episodes = List.of(1, 2, 3, 4, 5, 6, 999);
    private final String DESCRIPTION = "Save the King";

    @BeforeEach
    void setup() {
        films = List.of(film);
        when(client.getFilms()).thenReturn(apiResponse);
        when(apiResponse.getResults()).thenReturn(films);
        useCase = new SwSagaUseCaseImpl(client);
    }

    @Test
    void listFilmsTest() {
        final var films = assertDoesNotThrow(() -> useCase.listFilms());
        assertNotNull(films);
    }

    @Test
    void filmDetailsTest() {
        episodes.forEach(ep -> {
            if (ep <= 6) when(film.getEpisode()).thenReturn(ep);
            final var filmOpt = assertDoesNotThrow(() -> useCase.filmDetails(ep));
            if (ep > 6) {
                assertTrue(filmOpt.isEmpty());
            } else {
                assertTrue(filmOpt.isPresent());
            }
        });
    }

    @Test
    void updateFilmTest() {
        when(film.getVersion()).thenReturn(2);
        when(film.getDescription()).thenReturn(DESCRIPTION);
        episodes.forEach(ep -> {
            if (ep <= 6) when(film.getEpisode()).thenReturn(ep);
            assertDoesNotThrow(() -> useCase.updateFilm(ep, DESCRIPTION));
            if (ep <= 6) {
                final String description = useCase.filmDetails(ep).get().getDescription();
                final int version = useCase.filmDetails(ep).get().getVersion();
                assertEquals(DESCRIPTION, description);
                assertEquals(2, version);
            }
        });
    }
}
