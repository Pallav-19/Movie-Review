package com.movie.movie.users.services;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movie.movie.users.models.User;
@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
  public Optional<User> findByName(String name);
}
