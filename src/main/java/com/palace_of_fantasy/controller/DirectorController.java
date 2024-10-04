package com.palace_of_fantasy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.palace_of_fantasy.dto.DirectorDTO;
import com.palace_of_fantasy.service.DirectorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/directors")
@RequiredArgsConstructor
@Tag(name = "Directors", description = "Director management APIs")
public class DirectorController {
    private final DirectorService directorService;

    @GetMapping
    @Operation(summary = "Get all directors")
    public ResponseEntity<List<DirectorDTO>> getAllDirectors() {
        return ResponseEntity.ok(directorService.getAllDirectors());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a director by ID")
    public ResponseEntity<DirectorDTO> getDirectorById(@PathVariable Long id) {
        return ResponseEntity.ok(directorService.getDirectorById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new director")
    public ResponseEntity<DirectorDTO> createDirector(@Valid @RequestBody DirectorDTO directorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(directorService.createDirector(directorDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing director")
    public ResponseEntity<DirectorDTO> updateDirector(@PathVariable Long id, @Valid @RequestBody DirectorDTO directorDTO) {
        return ResponseEntity.ok(directorService.updateDirector(id, directorDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a director")
    public ResponseEntity<Void> deleteDirector(@PathVariable Long id) {
        directorService.deleteDirector(id);
        return ResponseEntity.noContent().build();
    }
}
