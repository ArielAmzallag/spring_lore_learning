package com.palace_of_fantasy.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.palace_of_fantasy.dto.GenreDTO;
import com.palace_of_fantasy.exception.ResourceNotFoundException;
import com.palace_of_fantasy.mapper.GenreMapper;
import com.palace_of_fantasy.model.Genre;
import com.palace_of_fantasy.model.Movie;
import com.palace_of_fantasy.repository.GenreRepository;
import com.palace_of_fantasy.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public List<GenreDTO> getAllGenres() {
        return genreRepository.findAll().stream()
                .map(genreMapper::toDTO)
                .collect(Collectors.toList());
    }

    public GenreDTO getGenreById(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id: " + id));
        return genreMapper.toDTO(genre);
    }

    public GenreDTO createGenre(GenreDTO genreDTO) {
        Genre genre = genreMapper.toEntity(genreDTO);
        Genre savedGenre = genreRepository.save(genre);
        return genreMapper.toDTO(savedGenre);
    }

    public GenreDTO updateGenre(Long id, GenreDTO genreDTO) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id: " + id));
        genre.setName(genreDTO.getName());
        Genre updatedGenre = genreRepository.save(genre);
        return genreMapper.toDTO(updatedGenre);
    }

       
    private final MovieRepository movieRepository;
    public void deleteGenre(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id: " + id));
        
        // Remove associations with movies
        List<Movie> movies = genre.getMovies();
        for (Movie movie : movies) {
            movie.getGenres().remove(genre);
        }
        movieRepository.saveAll(movies);
        
        genreRepository.delete(genre);
    }
}