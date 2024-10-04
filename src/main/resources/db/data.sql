INSERT INTO movies (title, description, release_year) VALUES
('The Neon Grimoire', 'In the sprawling megacity of Neo-Avalon, a hidden tome known as the Neon Grimoire contains the secrets of techno-sorcery.', 2045),
('The Bioforge Clans', 'In the outskirts of Neo-Avalon, the Bioforge Clans have mastered the art of melding organic matter with arcane energies and advanced biotechnology.', 2047),
('The Rust Sea Nomads', 'Beyond the borders of Neo-Avalon lies the Rust Sea, navigated by tribes of scavengers known as the Rust Sea Nomads.', 2049);

INSERT INTO actors (name, bio) VALUES
('John Doe', 'A versatile actor known for his roles in sci-fi and fantasy films.'),
('Jane Smith', 'An acclaimed actress with a background in theater and a passion for dystopian stories.'),
('Michael Johnson', 'A rising star in the world of cinema, known for his intense performances.');

INSERT INTO directors (name, bio) VALUES
('Sarah Thompson', 'A visionary director with a unique style that blends science fiction and arcane elements.'),
('David Wilson', 'An experienced filmmaker who specializes in bringing dystopian worlds to life on the big screen.');

INSERT INTO genres (name) VALUES
('Science Fiction'),
('Fantasy'),
('Dystopian');

INSERT INTO movie_actors (movie_id, actor_id) VALUES
(1, 1),
(1, 2),
(2, 2),
(2, 3),
(3, 1),
(3, 3);

INSERT INTO movie_directors (movie_id, director_id) VALUES
(1, 1),
(2, 2),
(3, 1);

INSERT INTO movie_genres (movie_id, genre_id) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 3),
(3, 1),
(3, 3);