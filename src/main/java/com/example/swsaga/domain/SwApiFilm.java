package com.example.swsaga.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SwApiFilm {

    @JsonProperty("episode_id")
    private int episode;

    @Setter
    @JsonProperty("opening_crawl")
    private String description;

    private String title;

    @Setter
    private int version = 1;
}
