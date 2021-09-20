package io.xrio.movies.model;

import javax.persistence.Embeddable;

/**
 * @author : Elattar Saad
 * @version 1.0
 * @since 20/9/2021
 */
@Embeddable
public class Info {

    private String name;
    private String type;
    private Long duration;
    private Long releaseYear;
}
