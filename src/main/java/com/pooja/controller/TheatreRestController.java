package com.pooja.controller;

import com.pooja.model.Theatre;
import com.pooja.service.TheatreService;
import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/theatres")
public class TheatreRestController {

    @Autowired
    TheatreService theatreService;

    @Operation(summary = "Create a new theatre", description = "Accepts a Theatre JSON and returns success message")
    @ApiResponse(responseCode = "200", description = "Theatre successfully created")
    @PostMapping
    public ResponseEntity<String> createTheatre(@Valid @RequestBody Theatre theater) {

//        return ResponseEntity.ok("User Created: " + theatre.getName());
        return ResponseEntity.ok(theatreService.saveTheatre(theater).getId());
    }
    @Operation(summary = "Get THEATRE by ID", description = "Fetch a THEATRE based on the ID")
    @ApiResponse(responseCode = "200", description = "User fetched successfully")
    @GetMapping("/{id}")
    public ResponseEntity<Theatre> getTheatre(@PathVariable String id) {
//        return ResponseEntity.ok("Theatre fetched with ID: " + id);
        return theatreService.getTheatreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @Operation(summary = "Update theatre by ID", description = "Update existing theatre details")
    @ApiResponse(responseCode = "200", description = "Theatre updated successfully")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTheatre(@PathVariable String id, @Valid @org.springframework.web.bind.annotation.RequestBody Theatre theatre) {
        return ResponseEntity.ok(theatreService.updateTheatre(id, theatre).getId());
    }

    @Operation(summary = "Delete theatre by ID", description = "Deletes a theatre based on the ID")
    @ApiResponse(responseCode = "200", description = "Theatre deleted successfully")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTheatre(@PathVariable String id) {
        theatreService.deleteTheatre(id);
        return ResponseEntity.ok("Theatre Deleted with ID: " + id);
    }
}
