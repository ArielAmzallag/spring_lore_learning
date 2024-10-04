package com.palace_of_fantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palace_of_fantasy.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByNameIgnoreCase(String name);
}
