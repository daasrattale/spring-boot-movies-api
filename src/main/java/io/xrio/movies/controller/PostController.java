package io.xrio.movies.controller;

import io.xrio.movies.controller.client.PostClient;
import io.xrio.movies.dto.PostDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Elattar Saad
 * @version 1.0
 * @since 1/1/2022
 */
@RestController
@RequestMapping("post")
@AllArgsConstructor
public class PostController {

    final PostClient postClient;

    @GetMapping
    public List<PostDTO> getPosts(){
        return postClient.getPosts();
    }


}
