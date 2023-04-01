package com.niit.musicservice.controller;


import com.niit.musicservice.domain.Music;
import com.niit.musicservice.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3")
public class MusicController {


    private MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;

    }
    @PostMapping("/music")
    public ResponseEntity<?> saveUser(@RequestBody Music music)  {
        return new ResponseEntity<>(musicService.saveUser(music), HttpStatus.CREATED);
    }
}
