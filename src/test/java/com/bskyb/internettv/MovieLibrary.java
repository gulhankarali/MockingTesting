package com.bskyb.internettv;

public class MovieLibrary {

    private String movieId;
    private String parentalControlLevel;

    public MovieLibrary(String movieId, String parentalControlLevel) {
        this.movieId = movieId;
        this.parentalControlLevel = parentalControlLevel;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getParentalControlLevel() {
        return parentalControlLevel;
    }

    public void setParentalControlLevel(String parentalControlLevel) {
        this.parentalControlLevel = parentalControlLevel;
    }
}
