package com.example.swsaga.usecase.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SwSagaUseCaseImplTest {

    @InjectMocks
    private SwSagaUseCaseImpl useCase;

    private List<Integer> episodes = List.of(1, 2, 3, 4, 5, 6, 999);
    private final String DESCRIPTION = "Save the King";

    @Test
    void listFilmsTest() {
        final var films = assertDoesNotThrow(() -> useCase.listFilms());
        assertNotNull(films);
    }

    @Test
    void filmDetailsTest() {
        episodes.forEach(ep -> {
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
        episodes.forEach(ep -> {
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
