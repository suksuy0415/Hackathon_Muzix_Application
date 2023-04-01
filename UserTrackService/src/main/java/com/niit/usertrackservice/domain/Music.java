package com.niit.usertrackservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Music {
    @Id
    private String musicId;
    private String musicName;
    private int yearOfRelease;
    private int rating;

    public Music() {
    }

    public Music(String musicId, String musicName, int yearOfRelease, int rating) {
        this.musicId = musicId;
        this.musicName = musicName;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
    }


    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
