package io.xrio.movies.service.impl;

import io.xrio.movies.exception.MovieDuplicatedException;
import io.xrio.movies.exception.MovieNotFoundException;
import io.xrio.movies.model.Movie;
import io.xrio.movies.repository.MovieRepository;
import io.xrio.movies.service.MovieService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Elattar Saad
 * @version 1.0
 * @since 10/9/2021
 */
@Service
@Data
public class MovieServiceImpl implements MovieService {

    final MovieRepository movieRepository;

    @Override
    public Movie save(Movie movie) throws MovieDuplicatedException {
        Movie movieFromDB = movieRepository.findById(movie.getId()).orElse(null);
        if (movieFromDB != null)
            throw new MovieDuplicatedException(movie.getId());
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Movie movie) throws MovieNotFoundException {
        Movie movieFromDB = movieRepository.findById(movie.getId()).orElse(null);
        if (movieFromDB == null)
            throw new MovieNotFoundException(movie.getId());
        movie.setId(movieFromDB.getId());
        return movieRepository.save(movie);
    }

    @Override
    public Long delete(Long id) throws MovieNotFoundException {
        Movie movieFromDB = movieRepository.findById(id).orElse(null);
        if (movieFromDB == null)
            throw new MovieNotFoundException(id);
        movieRepository.delete(movieFromDB);
        return id;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

}
