
package com.example.tutorial.services;

import com.example.tutorial.converters.PostConverter;
import com.example.tutorial.repositories.PostRepository;
import com.example.tutorial.dtos.PostDTO;
import com.example.tutorial.entity.Post;
import com.example.tutorial.validators.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static org.springframework.http.RequestEntity.post;

@Service
public class PostService {
    
    @Autowired
    private PostRepository pRepository;
    @Autowired
    private PostConverter pConverter;
    
    public PostDTO createPublication(PostDTO pDTO){
        PostValidator.createPost(pDTO);
        Post post = pConverter.toEntity(pDTO);
        Post p = pRepository.save(post);
        PostDTO publicationResponse = pConverter.toDTO(p);
        return publicationResponse;
    }

    public List<PostDTO> getAllPublications(){
        List<Post> posts = pRepository.findAll();
        List<PostDTO> pDTO = pConverter.toDTO(posts);
        return pDTO;
    }
}
