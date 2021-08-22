package com.example.codefellowship.Repository;

import com.example.codefellowship.Model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Integer> {
    public Post findById(Integer id);
}
