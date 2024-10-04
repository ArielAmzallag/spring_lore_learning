package com.palace_of_fantasy.mapper;

import com.palace_of_fantasy.model.Actor;
import com.palace_of_fantasy.model.Director;
import com.palace_of_fantasy.model.Genre;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.palace_of_fantasy.dto.MovieDTO;
import com.palace_of_fantasy.model.Movie;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ActorMapper.class, DirectorMapper.class, GenreMapper.class})
public interface MovieMapper {
    @Mapping(target = "actorIds", source = "actors", qualifiedByName = "actorToId")
    @Mapping(target = "directorIds", source = "directors", qualifiedByName = "directorToId")
    @Mapping(target = "genreIds", source = "genres", qualifiedByName = "genreToId")
    MovieDTO toDTO(Movie movie);

    @Mapping(target = "actors", ignore = true)
    @Mapping(target = "directors", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Movie toEntity(MovieDTO movieDTO);

    @Named("actorToId")
    static List<Long> actorToId(List<Actor> actors) {
        return actors.stream().map(Actor::getId).collect(Collectors.toList());
    }

    @Named("directorToId")
    static List<Long> directorToId(List<Director> directors) {
        return directors.stream().map(director -> director.getId()).collect(Collectors.toList());
    }

    @Named("genreToId")
    static List<Long> genreToId(List<Genre> genres) {
        return genres.stream().map(Genre::getId).collect(Collectors.toList());
    }
}