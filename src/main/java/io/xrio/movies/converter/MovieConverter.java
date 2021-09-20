package io.xrio.movies.converter;

import io.xrio.movies.dto.MovieDTO;
import io.xrio.movies.model.Movie;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author : Elattar Saad
 * @version 1.0
 * @since 20/9/2021
 */
@Component
public class MovieConverter extends AbstractConverter<Movie, MovieDTO> {

    private final ModelMapper modelMapper;

    public MovieConverter(ModelMapper modelMapper) {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        this.modelMapper = modelMapper;
    }

    @Override
    public Movie convertToDM(MovieDTO movieDTO) {
        return modelMapper.map(movieDTO, Movie.class);
    }

    @Override
    public MovieDTO convertToDTO(Movie movie) {
        return modelMapper.map(movie, MovieDTO.class);
    }
}
