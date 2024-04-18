package com.example.swsaga.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SwApiFilm {

    @JsonProperty("episode_id")
    private int episode;

    private String title;
    private int version = 1;
}
