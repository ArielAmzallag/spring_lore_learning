package com.palace_of_fantasy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.palace_of_fantasy.dto.DirectorDTO;
import com.palace_of_fantasy.model.Director;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
    DirectorDTO toDTO(Director director);

    @Mapping(target = "movies", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Director toEntity(DirectorDTO directorDTO);
}