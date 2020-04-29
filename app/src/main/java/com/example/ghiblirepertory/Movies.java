package com.example.ghiblirepertory;

public class Movies {
    private String id;
    private String title;
    private String intro;
    private String description;
    private String director;
    private String producer;
    private String movie_picture;
    private String background;

    public Movies(String id, String title, String intro, String description, String director, String producer, String movie_picture, String background) {
        this.id = id;
        this.title = title;
        this.intro = intro;
        this.description = description;
        this.director = director;
        this.producer = producer;
        this.movie_picture = movie_picture;
        this.background = background;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIntro() {
        return intro;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getMovie_picture() {
        return movie_picture;
    }

    public String getBackground() {
        return background;
    }
}
