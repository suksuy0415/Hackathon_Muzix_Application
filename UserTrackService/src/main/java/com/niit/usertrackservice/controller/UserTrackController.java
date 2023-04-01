package com.niit.usertrackservice.controller;

import com.niit.usertrackservice.domain.Music;
import com.niit.usertrackservice.domain.User;
import com.niit.usertrackservice.exception.MusicNotFoundException;
import com.niit.usertrackservice.exception.UserAlreadyExistsException;
import com.niit.usertrackservice.exception.UserNotFoundException;
import com.niit.usertrackservice.service.UserTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin

@RestController
@RequestMapping("/api/v2/")
public class UserTrackController {
private UserTrackService userTrackService;
private ResponseEntity<?> responseEntity;
@Autowired
    public UserTrackController(UserTrackService userTrackService) {
        this.userTrackService = userTrackService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
    try {
        responseEntity =  new ResponseEntity<>(userTrackService.registerUser(user), HttpStatus.CREATED);
    }
    catch(UserAlreadyExistsException e)
    {
        throw new UserAlreadyExistsException();
    }
    return responseEntity;
    }
    @PostMapping("/user/music/{email}")
    public ResponseEntity<?> saveUserMovieToList(@RequestBody Music movie, @PathVariable String email) throws UserNotFoundException {
    try {
        responseEntity = new ResponseEntity<>(userTrackService.saveUserMusicToList(movie, email), HttpStatus.CREATED);
    }
    catch (UserNotFoundException e)
    {
        throw new UserNotFoundException();
    }
    return responseEntity;
    }
    @GetMapping("/user/musics/{email}")
    public ResponseEntity<?> getAllUserMoviesFromList(@PathVariable String email) throws UserNotFoundException {
    try{
        responseEntity = new ResponseEntity<>(userTrackService.getAllUserMusic(email), HttpStatus.OK);
    }catch(UserNotFoundException e)
    {
        throw new UserNotFoundException();
    }
       return responseEntity;
    }
    @DeleteMapping("/user/{email}/{musicId}")
    public ResponseEntity<?> deleteUserProductFromList(@PathVariable String email,@PathVariable String musicId)
            throws UserNotFoundException, MusicNotFoundException
    {
        try {
            responseEntity = new ResponseEntity<>(userTrackService.deleteUserMusicFromList(email, musicId), HttpStatus.OK);
        } catch (UserNotFoundException | MusicNotFoundException m) {
            throw new MusicNotFoundException();
        }
        return responseEntity;
    }
}

