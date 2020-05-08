package com.example.ghiblirepertory.presentation.model;

import java.util.List;

public class RestGhibliResponse {

    private String name;
    private List<com.example.ghiblirepertory.presentation.model.movies> movies;

    public List<movies> getMovies() {

        return movies;
    }

}
