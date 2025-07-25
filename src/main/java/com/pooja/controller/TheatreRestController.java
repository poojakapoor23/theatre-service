package com.pooja.controller;

import com.pooja.model.Theatre;
import com.pooja.service.TheatreService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public class TheatreRestController {

    TheatreService theatreService;
    public ResponseEntity<String> createTheatre(@Valid @RequestBody Theatre theatre) {

//        return ResponseEntity.ok("User Created: " + theatre.getName());
        return ResponseEntity.ok(theatreService.saveTheatre(theatre).getId());
    }
}
