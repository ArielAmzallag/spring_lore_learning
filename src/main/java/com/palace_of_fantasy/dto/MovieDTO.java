package com.palace_of_fantasy.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MovieDTO {
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be at most 100 characters")
    private String title;
    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Release year is required")
    private Integer releaseYear;

    private List<Long> actorIds;
    private List<Long> directorIds;
    private List<Long> genreIds;
}