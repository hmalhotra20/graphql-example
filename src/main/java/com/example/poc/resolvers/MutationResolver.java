package com.example.poc.resolvers;

import com.example.poc.domain.Post;
import com.example.poc.domain.User;
import com.example.poc.model.CreatePostInput;
import com.example.poc.repository.PostRepository;
import com.example.poc.repository.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Slf4j
@Transactional
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    public Post createPost(CreatePostInput createPostInput) {
        Optional<User> user = userRepository.findById(createPostInput.getAuthorId());
        Post post = new Post();
        post.setContent(createPostInput.getContent());
        post.setTitle(createPostInput.getTitle());
        post.setAuthor(user.get());
        postRepository.save(post);
        return post;
    }

    public User createUser(String userName, String email) {
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }

}
