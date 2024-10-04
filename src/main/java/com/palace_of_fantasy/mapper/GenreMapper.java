package com.palace_of_fantasy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.palace_of_fantasy.dto.GenreDTO;
import com.palace_of_fantasy.model.Genre;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreDTO toDTO(Genre genre);

    @Mapping(target = "movies", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Genre toEntity(GenreDTO genreDTO);
}