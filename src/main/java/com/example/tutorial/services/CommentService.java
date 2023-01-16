package com.example.tutorial.services;

import com.example.tutorial.converters.CommentConverter;
import com.example.tutorial.dtos.CommentDTO;
import com.example.tutorial.dtos.UserDTO;
import com.example.tutorial.entity.Comment;
import com.example.tutorial.entity.Post;
import com.example.tutorial.entity.User;
import com.example.tutorial.exceptions.ValidateServiceException;
import com.example.tutorial.repositories.CommentRepository;
import com.example.tutorial.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository cRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentConverter cConverter;

    @Transactional
    public CommentDTO createComment(CommentDTO commentDTO){
        //Verifica la existencia de la publicacion
        Post post = verifyPost(commentDTO);

        //Se guarda el comentario con su respectiva publicacion
        Comment comment = cConverter.toEntity(commentDTO);
        comment.setPost(post);
        Comment c = cRepository.save(comment);
        CommentDTO cDTO = cConverter.toDTO(c);
        return cDTO;
    }

    public Post verifyPost(CommentDTO commentDTO){
        //Obtienes el id de la publicacion a la que pertenece el comentario
        //antes de convertir el comentario en un DTO
        Long idPost = commentDTO.getIdPost();

        //Se verifica la existencia de la publicacion
        Post post = postRepository.findById(idPost).orElse(null);
        if(post==null) throw new ValidateServiceException("La publicacion del comentario no existe");
        return post;
    }

}
