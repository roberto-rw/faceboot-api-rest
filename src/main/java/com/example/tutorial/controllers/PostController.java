package com.example.tutorial.controllers;

import com.example.tutorial.dtos.PostDTO;
import com.example.tutorial.dtos.UserDTO;
import com.example.tutorial.services.PostService;
import com.example.tutorial.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService pService;

    @PostMapping(value = "/post")
    public ResponseEntity<WrapperResponse<PostDTO>> createPost(@RequestBody PostDTO pDTO){
        PostDTO post = pService.createPublication(pDTO);
        WrapperResponse<PostDTO>response = new WrapperResponse<>("Publicacion creada",post);
        return response.createResponse(HttpStatus.CREATED);
    }

    @GetMapping(value = "/post")
    public ResponseEntity<WrapperResponse<List<PostDTO>>> getAllPosts(){
        List<PostDTO> posts = pService.getAllPublications();
        WrapperResponse<List<PostDTO>>response = new WrapperResponse<>("Publicaciones consultadas",posts);
        return response.createResponse(HttpStatus.OK);
    }
}
