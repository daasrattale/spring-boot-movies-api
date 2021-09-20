package io.xrio.movies.controller;

import io.xrio.movies.dto.MovieDTO;
import io.xrio.movies.exception.MovieDuplicatedException;
import io.xrio.movies.exception.MovieNotFoundException;
import io.xrio.movies.model.Movie;
import io.xrio.movies.service.MovieService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<?> save(@Valid @RequestBody Movie movie) throws Exception {
        if (movie == null)
            return ResponseEntity.badRequest().body("The provided movie is not valid");
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.save(movie));
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@Valid @RequestBody Movie movie) throws Exception {
        if (movie == null)
            return ResponseEntity.badRequest().body("The provided movie is not valid");
        return ResponseEntity.ok().body(movieService.update(movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        if (id == null)
            return ResponseEntity.badRequest().body("The provided movie's id is not valid");
        return ResponseEntity.ok().body("Movie [" + movieService.delete(id) + "] deleted successfully.");
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(movieService.findAll());
    }

}
