package com.example.poc.resolvers;

import com.example.poc.domain.User;
import com.example.poc.repository.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
@Transactional
public class UserResolver implements GraphQLQueryResolver {

    @Autowired
    UserRepository userRepository;

    public List<User> users()  {
        return userRepository.findAll();
    }

    public List<User> usersWithPosts()  {
        return userRepository.findWithPosts();
    }
}
