package com.example.swsaga.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SwApiResponse {

    private Long count;
    private List<SwApiFilm> results;
}
