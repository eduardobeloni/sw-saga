package com.example.swsaga.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.swsaga.domain.SwApiResponse;

@FeignClient(name = "swapi", url = "https://swapi.dev/api")
public interface SwApiClient {

    @GetMapping(value = "/films", consumes = MediaType.APPLICATION_JSON_VALUE)
    SwApiResponse getFilms();
}