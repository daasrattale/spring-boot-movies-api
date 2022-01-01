package io.xrio.movies.controller.client;

import io.xrio.movies.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author : Elattar Saad
 * @version 1.0
 * @since 1/1/2022
 */
@FeignClient(name = "jsonplaceholder", url = "https://jsonplaceholder.typicode.com/posts")
public interface PostClient {


    @GetMapping
    List<PostDTO> getPosts();

}
