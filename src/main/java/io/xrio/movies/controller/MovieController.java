package io.xrio.movies.controller;

import io.xrio.movies.converter.MovieConverter;
import io.xrio.movies.dto.MovieDTO;
import io.xrio.movies.service.MovieService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    final MovieConverter movieConverter;

    @PostMapping("/")
    public ResponseEntity<?> save(@Valid @RequestBody MovieDTO movieDTO) throws Exception {
        if (movieDTO == null)
            return ResponseEntity.badRequest().body("The provided movie is not valid");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(movieConverter.convertToDTO(movieService.save(movieConverter.convertToDM(movieDTO))));
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@Valid @RequestBody MovieDTO movieDTO) throws Exception {
        if (movieDTO == null)
            return ResponseEntity.badRequest().body("The provided movie is not valid");
        return ResponseEntity
                .ok()
                .body(movieConverter.convertToDTO(movieService.update(movieConverter.convertToDM(movieDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        if (id == null)
            return ResponseEntity.badRequest().body("The provided movie's id is not valid");
        return ResponseEntity.ok().body("Movie [" + movieService.delete(id) + "] deleted successfully.");
    }

    @GetMapping("/")
    public ResponseEntity<List<MovieDTO>> findAll() {
        return ResponseEntity.ok().body(movieConverter.convertToDTOs(movieService.findAll()));
    }

}
