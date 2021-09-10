package io.xrio.movies.service;

import io.xrio.movies.exception.MovieDuplicatedException;
import io.xrio.movies.exception.MovieNotFoundException;
import io.xrio.movies.model.Movie;

import java.util.List;

/**
 * @author : Elattar Saad
 * @version 1.0
 * @since 10/9/2021
 */
public interface MovieService {

    Movie save(Movie movie) throws MovieDuplicatedException;
    Movie update(Movie movie) throws MovieNotFoundException;
    Long delete(Long id) throws MovieNotFoundException;
    List<Movie> findAll();

}
