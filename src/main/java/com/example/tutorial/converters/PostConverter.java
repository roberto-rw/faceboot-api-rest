
package com.example.tutorial.converters;

import com.example.tutorial.dtos.CommentDTO;
import com.example.tutorial.dtos.PostDTO;
import com.example.tutorial.dtos.UserDTO;
import com.example.tutorial.entity.Post;
import com.example.tutorial.entity.User;
import java.time.LocalDate;
import java.util.List;

import com.example.tutorial.exceptions.NoDataFoundException;
import com.example.tutorial.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostConverter extends AbstractConverter<Post, PostDTO>{

    @Autowired
    private UserConverter userConverter;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentConverter commentConverter;
    
    @Override
    public PostDTO toDTO(Post p) {
        List<CommentDTO> commentsDTO = null;
        if(p.getComments() != null){
             commentsDTO = commentConverter.toDTO(p.getComments());
        }
        return new PostDTO(p.getId(),p.getUser().getUsername(), p.getUser().getId(), p.getDate().toString(), p.getText(), p.getImage(), commentsDTO);
    }

    @Override
    public Post toEntity(PostDTO dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new NoDataFoundException("Usuario de la publicacion no encontrado"));
        return new Post(dto.getId(), user, LocalDate.now(), dto.getText(), dto.getImage());
    }
    
}
