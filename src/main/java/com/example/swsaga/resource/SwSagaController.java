package com.example.swsaga.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwSagaController {

    @GetMapping("/films")
    public String films() {
        return "WIP";
    }
}
