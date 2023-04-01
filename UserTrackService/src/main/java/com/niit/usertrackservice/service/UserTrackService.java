package com.niit.usertrackservice.service;

import com.niit.usertrackservice.domain.Music;
import com.niit.usertrackservice.domain.User;
import com.niit.usertrackservice.exception.MusicNotFoundException;
import com.niit.usertrackservice.exception.UserAlreadyExistsException;
import com.niit.usertrackservice.exception.UserNotFoundException;

import java.util.List;

public interface UserTrackService {
User registerUser(User user) throws UserAlreadyExistsException;
User saveUserMusicToList(Music movie, String email) throws UserNotFoundException;
User deleteUserMusicFromList(String email,String movieId) throws UserNotFoundException, MusicNotFoundException;
List<Music> getAllUserMusic(String email) throws UserNotFoundException;

}
