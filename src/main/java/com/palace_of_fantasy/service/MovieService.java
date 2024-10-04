package com.palace_of_fantasy.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palace_of_fantasy.dto.MovieDTO;
import com.palace_of_fantasy.exception.ResourceNotFoundException;
import com.palace_of_fantasy.mapper.MovieMapper;
import com.palace_of_fantasy.model.Actor;
import com.palace_of_fantasy.model.Director;
import com.palace_of_fantasy.model.Genre;
import com.palace_of_fantasy.model.Movie;
import com.palace_of_fantasy.repository.ActorRepository;
import com.palace_of_fantasy.repository.DirectorRepository;
import com.palace_of_fantasy.repository.GenreRepository;
import com.palace_of_fantasy.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;
    private final GenreRepository genreRepository;
    private final MovieMapper movieMapper;

    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(movieMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MovieDTO getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
        return movieMapper.toDTO(movie);
    }

    @Transactional
    public MovieDTO createMovie(MovieDTO movieDTO) {
        Movie movie = movieMapper.toEntity(movieDTO);
        movie.setActors(getActorsFromIds(movieDTO.getActorIds()));
        movie.setDirectors(getDirectorsFromIds(movieDTO.getDirectorIds()));
        movie.setGenres(getGenresFromIds(movieDTO.getGenreIds()));
        Movie savedMovie = movieRepository.save(movie);
        return movieMapper.toDTO(savedMovie);
    }

    @Transactional
    public MovieDTO updateMovie(Long id, MovieDTO movieDTO) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
        movie.setTitle(movieDTO.getTitle());
        movie.setDescription(movieDTO.getDescription());
        movie.setReleaseYear(movieDTO.getReleaseYear());
        movie.setActors(getActorsFromIds(movieDTO.getActorIds()));
        movie.setDirectors(getDirectorsFromIds(movieDTO.getDirectorIds()));
        movie.setGenres(getGenresFromIds(movieDTO.getGenreIds()));
        Movie updatedMovie = movieRepository.save(movie);
        return movieMapper.toDTO(updatedMovie);
    }

    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
        movieRepository.delete(movie);
    }

    private List<Actor> getActorsFromIds(List<Long> actorIds) {
        return actorIds.stream()
                .map(id -> actorRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Actor not found with id: " + id)))
                .collect(Collectors.toList());
    }

    private List<Director> getDirectorsFromIds(List<Long> directorIds) {
        return directorIds.stream()
                .map(id -> directorRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Director not found with id: " + id)))
                .collect(Collectors.toList());
    }

    private List<Genre> getGenresFromIds(List<Long> genreIds) {
        return genreIds.stream()
                .map(id -> genreRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id: " + id)))
                .collect(Collectors.toList());
    }
}