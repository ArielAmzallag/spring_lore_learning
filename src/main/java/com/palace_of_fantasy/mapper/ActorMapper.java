package com.palace_of_fantasy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.palace_of_fantasy.dto.ActorDTO;
import com.palace_of_fantasy.model.Actor;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    ActorDTO toDTO(Actor actor);

    @Mapping(target = "movies", ignore = true)
    Actor toEntity(ActorDTO actorDTO);
}
