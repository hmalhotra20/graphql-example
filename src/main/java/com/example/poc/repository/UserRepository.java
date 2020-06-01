package com.example.poc.repository;

import com.example.poc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select distinct u from User u left join fetch u.posts")
    List<User> findWithPosts();

}
