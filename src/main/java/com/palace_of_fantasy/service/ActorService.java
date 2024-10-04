package com.palace_of_fantasy.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.palace_of_fantasy.dto.ActorDTO;
import com.palace_of_fantasy.exception.ResourceNotFoundException;
import com.palace_of_fantasy.mapper.ActorMapper;
import com.palace_of_fantasy.model.Actor;
import com.palace_of_fantasy.repository.ActorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActorService {
    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;
    private static final String ACTOR_NOT_FOUND_MESSAGE = "Actor not found with id: ";

    public List<ActorDTO> getAllActors() {
        return actorRepository.findAll().stream()
                .map(actorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ActorDTO getActorById(Long id) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ACTOR_NOT_FOUND_MESSAGE + id));
        return actorMapper.toDTO(actor);
    }

    public ActorDTO createActor(ActorDTO actorDTO) {
        Actor actor = actorMapper.toEntity(actorDTO);
        Actor savedActor = actorRepository.save(actor);
        return actorMapper.toDTO(savedActor);
    }

    public ActorDTO updateActor(Long id, ActorDTO actorDTO) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ACTOR_NOT_FOUND_MESSAGE + id));
        actor.setName(actorDTO.getName());
        actor.setBio(actorDTO.getBio());
        Actor updatedActor = actorRepository.save(actor);
        return actorMapper.toDTO(updatedActor);
    }

    public void deleteActor(Long id) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ACTOR_NOT_FOUND_MESSAGE + id));
        actorRepository.delete(actor);
    }
}