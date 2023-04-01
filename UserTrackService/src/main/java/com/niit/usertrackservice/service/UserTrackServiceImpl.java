package com.niit.usertrackservice.service;

import com.niit.rabbitmq.domain.UserDTO;
import com.niit.usertrackservice.config.Producer;
import com.niit.usertrackservice.domain.Music;
import com.niit.usertrackservice.domain.User;
import com.niit.usertrackservice.exception.MusicNotFoundException;
import com.niit.usertrackservice.exception.UserAlreadyExistsException;
import com.niit.usertrackservice.exception.UserNotFoundException;
import com.niit.usertrackservice.repository.UserTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class UserTrackServiceImpl implements UserTrackService {
    private UserTrackRepository userTrackRepository;
    @Autowired
    Producer producer;
    @Autowired
    public UserTrackServiceImpl(UserTrackRepository userTrackRepository) {
        this.userTrackRepository = userTrackRepository;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {

        UserDTO userdto=new UserDTO();
        userdto.setUserName(user.getUserName());
        userdto.setEmail(user.getEmail());
        userdto.setPassword(user.getPassword());
        if(userTrackRepository.findById(user.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        else{
            userTrackRepository.save(user);
            System.out.println("saved user in mongo");
            producer.sendMessageToRabbitMq(userdto);
        }
        return user;
    }

    @Override
    public User saveUserMusicToList(Music music, String email) throws UserNotFoundException {
        if(userTrackRepository.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        User user = userTrackRepository.findByEmail(email);
        if(user.getMusicList() == null)
        {
            user.setMusicList(Arrays.asList(music));
        }
        else {
            List<Music> musics = user.getMusicList();
            musics.add(music);
            user.setMusicList(musics);
        }
        return userTrackRepository.save(user);
    }

    @Override
    public User deleteUserMusicFromList(String email, String musicId) throws UserNotFoundException, MusicNotFoundException {
        boolean movieIdIsPresent = false;
        if(userTrackRepository.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        User user = userTrackRepository.findById(email).get();
        List<Music> movies = user.getMusicList();
        movieIdIsPresent = movies.removeIf(x->x.getMusicId().equals(musicId));
        if(!movieIdIsPresent)
        {
            throw new MusicNotFoundException();
        }
        user.setMusicList(movies);
        return userTrackRepository.save(user);
    }

    @Override
    public List<Music> getAllUserMusic(String email) throws UserNotFoundException {
        if(userTrackRepository.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        return userTrackRepository.findById(email).get().getMusicList();
    }


}
