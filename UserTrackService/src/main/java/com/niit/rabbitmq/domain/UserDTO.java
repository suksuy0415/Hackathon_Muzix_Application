package com.niit.rabbitmq.domain;

import com.niit.usertrackservice.domain.Music;

import java.util.List;

public class UserDTO {
    private String email;
    private String userName;
    private String password;
    private String phoneNumber;
    private List<Music> movieList;

    public UserDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Music> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Music> movieList) {
        this.movieList = movieList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
