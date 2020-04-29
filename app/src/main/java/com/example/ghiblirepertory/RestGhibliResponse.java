package com.example.ghiblirepertory;

import java.util.List;

public class RestGhibliResponse {


    private String program;
    private List<Movies> movie_list;

    public List<Movies> getMovie_list() {
        return movie_list;
    }

    public String getProgram() {
        return program;
    }

}
