package io.xrio.movies.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author : Elattar Saad
 * @version 1.0
 * @since 10/9/2021
 */
@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull(message = "Id must not be null")
    private Long id;

    @NotBlank(message = "Name must not be blank")
    private String name;
    @NotBlank(message = "Type must not be blank")
    private String type;
    @Min(value = 1, message = "Movies are mainly more than a minute")
    @Max(value = 300, message = "Movies are less than 5 hours")
    private Long duration;
    @NotNull(message = "Release year must not be null")
    private Long releaseYear;

}
