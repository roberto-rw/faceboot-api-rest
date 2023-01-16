package com.example.tutorial.controllers;

import com.example.tutorial.dtos.CommentDTO;
import com.example.tutorial.services.CommentService;
import com.example.tutorial.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/comment")
    public ResponseEntity<WrapperResponse<CommentDTO>> createComment(@RequestBody CommentDTO commentDTO){
        CommentDTO cDTO = commentService.createComment(commentDTO);
        WrapperResponse<CommentDTO> response = new WrapperResponse<>("Comentario creado",cDTO);
        return response.createResponse(HttpStatus.CREATED);
    }
}
