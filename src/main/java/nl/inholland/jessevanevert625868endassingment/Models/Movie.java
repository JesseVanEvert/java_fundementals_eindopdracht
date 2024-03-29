package nl.inholland.jessevanevert625868endassingment.Models;

import javafx.beans.property.DoubleProperty;

import java.time.LocalDateTime;

public class Movie {
    private int movieId;
    private LocalDateTime start;
    private LocalDateTime end;
    private String title;
    private int seats;
    private double price;
    private int durationInMinutes;

    public Movie(int movieId, LocalDateTime start, LocalDateTime end, String title, int seats, double price, int durationInMinutes) {
        this.movieId = movieId;
        this.start = start;
        this.end = end;
        this.title = title;
        this.seats = seats;
        this.price = price;
        this.durationInMinutes = durationInMinutes;
    }

    public Movie() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}
