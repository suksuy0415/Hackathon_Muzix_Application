package com.niit.musicservice.service;


import com.niit.musicservice.domain.Music;
import com.niit.musicservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MusicServiceImpl implements MusicService{


    private MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository){ this.musicRepository = musicRepository;}
    @Override
    public Music saveUser(Music music) {
        return musicRepository.save(music);
    }
}
