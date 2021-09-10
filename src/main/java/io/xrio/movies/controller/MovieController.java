package io.xrio.movies.controller;

import io.xrio.movies.exception.MovieDuplicatedException;
import io.xrio.movies.exception.MovieNotFoundException;
import io.xrio.movies.model.Movie;
import io.xrio.movies.service.MovieService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Elattar Saad
 * @version 1.0
 * @since 10/9/2021
 */
@RestController
@RequestMapping("movie")
@Data
public class MovieController {

    final MovieService movieService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Movie movie) throws MovieDuplicatedException {
        if (movie == null)
            return ResponseEntity.badRequest().body("The provided movie is not valid");
        return ResponseEntity.ok().body(movieService.save(movie));
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody Movie movie) throws MovieNotFoundException {
        if (movie == null)
            return ResponseEntity.badRequest().body("The provided movie is not valid");
        return ResponseEntity.ok().body(movieService.update(movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws MovieNotFoundException {
        if (id == null)
            return ResponseEntity.badRequest().body("The provided movie's id is not valid");
        return ResponseEntity.ok().body("Movie [" + movieService.delete(id) + "] deleted successfully.");
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(movieService.findAll());
    }

}
