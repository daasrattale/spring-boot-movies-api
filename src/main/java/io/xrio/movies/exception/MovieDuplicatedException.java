package io.xrio.movies.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Elattar Saad
 * @version 1.0
 * @since 10/9/2021
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class MovieDuplicatedException extends Exception{

    /**
     * The duplicated movie's id
     */
    private Long mid;

}
