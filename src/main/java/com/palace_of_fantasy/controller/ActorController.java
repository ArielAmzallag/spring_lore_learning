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

import com.palace_of_fantasy.dto.ActorDTO;
import com.palace_of_fantasy.service.ActorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/actors")
@RequiredArgsConstructor
@Tag(name = "Actors", description = "Actor management APIs")
public class ActorController {
    private final ActorService actorService;

    @GetMapping
    @Operation(summary = "Get all actors")
    public ResponseEntity<List<ActorDTO>> getAllActors() {
        return ResponseEntity.ok(actorService.getAllActors());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an actor by ID")
    public ResponseEntity<ActorDTO> getActorById(@PathVariable Long id) {
        return ResponseEntity.ok(actorService.getActorById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new actor")
    public ResponseEntity<ActorDTO> createActor(@Valid @RequestBody ActorDTO actorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(actorService.createActor(actorDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing actor")
    public ResponseEntity<ActorDTO> updateActor(@PathVariable Long id, @Valid @RequestBody ActorDTO actorDTO) {
        return ResponseEntity.ok(actorService.updateActor(id, actorDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an actor")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        actorService.deleteActor(id);
        return ResponseEntity.noContent().build();
    }
}
