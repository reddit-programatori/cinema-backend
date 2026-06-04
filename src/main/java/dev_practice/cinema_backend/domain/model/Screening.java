package dev_practice.cinema_backend.domain.model;

import java.util.Date;

public class Screening {

    private long id;
    private String cinema;
    private Date date;
    private Movie movie;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCinema() {
        return cinema;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screening(long id, String cinema, Date date, Movie movie) {
        this.id = id;
        this.cinema = cinema;
        this.date = date;
        this.movie = movie;
    }
}
