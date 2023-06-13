package com.example.springMongo.repository;

import com.example.springMongo.domain.Post;
import com.example.springMongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
