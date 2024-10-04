package com.palace_of_fantasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palace_of_fantasy.model.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
    List<Director> findByNameContainingIgnoreCase(String name);
}
