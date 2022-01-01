package io.xrio.movies.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author : Elattar Saad
 * @version 1.0
 * @since 1/1/2022
 */
@Data
public class PostDTO {

    private Long id;
    private Long userId;
    private String title;
    private String body;



}
