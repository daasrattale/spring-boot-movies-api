package io.xrio.movies.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Long id;
    private String name;
    private String type;
    private Long duration;
    private Long releaseYear;

}
