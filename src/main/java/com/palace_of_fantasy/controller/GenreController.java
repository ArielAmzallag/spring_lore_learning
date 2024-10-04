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

import com.palace_of_fantasy.dto.GenreDTO;
import com.palace_of_fantasy.service.GenreService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
@Tag(name = "Genres", description = "Genre management APIs")
public class GenreController {
    private final GenreService genreService;

    @GetMapping
    @Operation(summary = "Get all genres")
    public ResponseEntity<List<GenreDTO>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a genre by ID")
    public ResponseEntity<GenreDTO> getGenreById(@PathVariable Long id) {
        return ResponseEntity.ok(genreService.getGenreById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new genre")
    public ResponseEntity<GenreDTO> createGenre(@Valid @RequestBody GenreDTO genreDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(genreService.createGenre(genreDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing genre")
    public ResponseEntity<GenreDTO> updateGenre(@PathVariable Long id, @Valid @RequestBody GenreDTO genreDTO) {
        return ResponseEntity.ok(genreService.updateGenre(id, genreDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a genre")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }
}
