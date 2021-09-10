package io.xrio.movies.controller.advice;

import io.xrio.movies.exception.MovieDuplicatedException;
import io.xrio.movies.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author : Elattar Saad
 * @version 1.0
 * @since 10/9/2021
 */
@ControllerAdvice
public class MovieControllerExceptionHandler {


    @ExceptionHandler(MovieNotFoundException.class)
    private ResponseEntity<?> handleMovieNotFoundException(MovieNotFoundException exception){
        String responseMessage = "The provided movie ["+exception.getMid()+"] is nowhere to be found.";
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(responseMessage);
    }

    @ExceptionHandler(MovieDuplicatedException.class)
    private ResponseEntity<?> handleMovieDuplicatedException(MovieDuplicatedException exception){
        String responseMessage = "The provided movie ["+exception.getMid()+"] is already existing.";
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(responseMessage);
    }
}
