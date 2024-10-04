package com.palace_of_fantasy.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.palace_of_fantasy.dto.DirectorDTO;
import com.palace_of_fantasy.exception.ResourceNotFoundException;
import com.palace_of_fantasy.mapper.DirectorMapper;
import com.palace_of_fantasy.model.Director;
import com.palace_of_fantasy.model.Movie;
import com.palace_of_fantasy.repository.DirectorRepository;
import com.palace_of_fantasy.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DirectorService {
    private final DirectorRepository directorRepository;
    private final DirectorMapper directorMapper;

    public List<DirectorDTO> getAllDirectors() {
        return directorRepository.findAll().stream()
                .map(directorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DirectorDTO getDirectorById(Long id) {
        Director director = directorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Director not found with id: " + id));
        return directorMapper.toDTO(director);
    }

    public DirectorDTO createDirector(DirectorDTO directorDTO) {
        Director director = directorMapper.toEntity(directorDTO);
        Director savedDirector = directorRepository.save(director);
        return directorMapper.toDTO(savedDirector);
    }

    public DirectorDTO updateDirector(Long id, DirectorDTO directorDTO) {
        Director director = directorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Director not found with id: " + id));
        director.setName(directorDTO.getName());
        director.setBio(directorDTO.getBio());
        Director updatedDirector = directorRepository.save(director);
        return directorMapper.toDTO(updatedDirector);
    }
    private final MovieRepository movieRepository;
    public void deleteDirector(Long id) {
        Director director = directorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Director not found with id: " + id));
    
        // Remove associations with movies
        List<Movie> movies = director.getMovies();
        for (Movie movie : movies) {
            movie.getDirectors().remove(director);
        }
        movieRepository.saveAll(movies);
    
        directorRepository.delete(director);
    }
}