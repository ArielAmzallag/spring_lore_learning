package com.palace_of_fantasy.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.palace_of_fantasy.model.Actor;
import com.palace_of_fantasy.model.Director;
import com.palace_of_fantasy.model.Genre;
import com.palace_of_fantasy.model.Movie;
import com.palace_of_fantasy.repository.ActorRepository;
import com.palace_of_fantasy.repository.DirectorRepository;
import com.palace_of_fantasy.repository.GenreRepository;
import com.palace_of_fantasy.repository.MovieRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(MovieRepository movieRepository,
                                      ActorRepository actorRepository,
                                      DirectorRepository directorRepository,
                                      GenreRepository genreRepository) {
        return args -> {
            // Create sample genres
            Genre sciFiGenre = new Genre(null, "Science Fiction", null, null, null);
            Genre fantasyGenre = new Genre(null, "Fantasy", null, null, null);
            Genre dystopianGenre = new Genre(null, "Dystopian", null, null, null);
            genreRepository.saveAll(Arrays.asList(sciFiGenre, fantasyGenre, dystopianGenre));

            // Create sample actors
            Actor actor1 = new Actor(null, "John Doe", "A versatile actor known for his roles in sci-fi and fantasy films.", null, null, null);
            Actor actor2 = new Actor(null, "Jane Smith", "An acclaimed actress with a background in theater and a passion for dystopian stories.", null, null, null);
            Actor actor3 = new Actor(null, "Michael Johnson", "A rising star in the world of cinema, known for his intense performances.", null, null, null);
            actorRepository.saveAll(Arrays.asList(actor1, actor2, actor3));

            // Create sample directors
            Director director1 = new Director(null, "Sarah Thompson", "A visionary director with a unique style that blends science fiction and arcane elements.", null, null, null);
            Director director2 = new Director(null, "David Wilson", "An experienced filmmaker who specializes in bringing dystopian worlds to life on the big screen.", null, null, null);
            directorRepository.saveAll(Arrays.asList(director1, director2));

            // Create sample movies
            Movie movie1 = new Movie(null, "The Neon Grimoire", "In the sprawling megacity of Neo-Avalon, a hidden tome known as the Neon Grimoire contains the secrets of techno-sorcery.", 2045, null, null, Arrays.asList(actor1, actor2), Arrays.asList(director1), Arrays.asList(sciFiGenre, fantasyGenre));
            Movie movie2 = new Movie(null, "The Bioforge Clans", "In the outskirts of Neo-Avalon, the Bioforge Clans have mastered the art of melding organic matter with arcane energies and advanced biotechnology.", 2047, null, null, Arrays.asList(actor2, actor3), Arrays.asList(director2), Arrays.asList(sciFiGenre, dystopianGenre));
            Movie movie3 = new Movie(null, "The Rust Sea Nomads", "Beyond the borders of Neo-Avalon lies the Rust Sea, navigated by tribes of scavengers known as the Rust Sea Nomads.", 2049, null, null, Arrays.asList(actor1, actor3), Arrays.asList(director1), Arrays.asList(sciFiGenre, dystopianGenre));
            movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3));
        };
    }
}