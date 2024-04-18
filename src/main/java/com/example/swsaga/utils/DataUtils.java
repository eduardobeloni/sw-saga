package com.example.swsaga.utils;


import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DataUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);

	public static <T> Optional<T> toObjectSafe(String json, Class<T> type) {
		try {
			synchronized (objectMapper) {
				return Optional.of(objectMapper.readValue(json, type));
			}
		} catch (IOException e) {
		    e.printStackTrace();
		    return Optional.empty();
		}
	}

	public static Optional<String> loadFileSafe(String fileName) {
	    try {
	        final var file = new ClassPathResource(fileName).getFile();
            return Optional.of(new String(Files.readAllBytes(file.toPath())));
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
	}
}