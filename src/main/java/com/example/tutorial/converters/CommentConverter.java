package com.example.tutorial.converters;

import com.example.tutorial.dtos.CommentDTO;
import com.example.tutorial.dtos.PostDTO;
import com.example.tutorial.dtos.UserDTO;
import com.example.tutorial.entity.Comment;
import com.example.tutorial.entity.Post;
import com.example.tutorial.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CommentConverter extends AbstractConverter<Comment, CommentDTO>{
    @Autowired
    private UserConverter userConverter;
    @Override
    public CommentDTO toDTO(Comment comment) {
        UserDTO userDTO = userConverter.toDTO(comment.getUser());
        return new CommentDTO(comment.getId(), comment.getDate().toString(),
                    comment.getText(), comment.getImage(), userDTO, comment.getPost().getId());
    }

    @Override
    public Comment toEntity(CommentDTO commentDTO) {
        User user = userConverter.toEntity(commentDTO.getUser());
        return new Comment(commentDTO.getId(), LocalDate.parse(commentDTO.getDate()),
                            commentDTO.getText(), commentDTO.getImage(), user, null);
    }

}
