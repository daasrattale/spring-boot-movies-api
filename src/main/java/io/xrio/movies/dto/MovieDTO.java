package io.xrio.movies.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author : Elattar Saad
 * @version 1.0
 * @since 20/9/2021
 */
@Data
public class MovieDTO {

    @NotNull(message = "Id must not be null")
    private Long id;

    @NotBlank(message = "Name must not be blank")
    private String infoName;
    @NotBlank(message = "Type must not be blank")
    private String infoType;
    @Min(value = 1, message = "Movies are mainly more than a minute")
    @Max(value = 300, message = "Movies are less than 5 hours")
    private Long infoDuration;
    @NotNull(message = "Release year must not be null")
    private Long infoReleaseYear;

}
