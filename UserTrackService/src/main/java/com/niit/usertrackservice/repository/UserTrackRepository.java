package com.niit.usertrackservice.repository;

import com.niit.usertrackservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface UserTrackRepository extends MongoRepository<User,String> {
    User findByEmail(String email);
}
