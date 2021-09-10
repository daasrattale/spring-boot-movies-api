package io.xrio.movies.repository;

import io.xrio.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Elattar Saad
 * @version 1.0
 * @since 10/9/2021
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByName(String name);

}
