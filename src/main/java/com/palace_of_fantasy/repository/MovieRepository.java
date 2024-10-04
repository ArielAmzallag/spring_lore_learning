package com.palace_of_fantasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palace_of_fantasy.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContainingIgnoreCase(String title);
    List<Movie> findByReleaseYear(Integer releaseYear);
    List<Movie> findByActorsId(Long actorId);
    List<Movie> findByDirectorsId(Long directorId);
    List<Movie> findByGenresId(Long genreId);
}
