package com.niit.musicservice.repository;


import com.niit.musicservice.domain.Music;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicRepository extends MongoRepository<Music,String> {
}
