package com.example.fahmiramadhani.rundays;

public class Race {
    private String raceTitle, raceLocation, raceCategory, raceDate;

    public Race() {
    }

    public Race(String raceTitle, String raceLocation, String raceCategory, String raceDate) {
        this.raceTitle = raceTitle;
        this.raceLocation = raceLocation;
        this.raceCategory = raceCategory;
        this.raceDate = raceDate;
    }

    public String getRaceTitle() {
        return raceTitle;
    }

    public void setRaceTitleTitle(String title) {
        this.raceTitle = title;
    }

    public String getRaceLocation() {
        return raceLocation;
    }

    public void setRaceLocation(String location) {this.raceLocation = location;}

    public String getRaceCategory() {
        return raceCategory;
    }

    public void setRaceCategory(String category) {
        this.raceCategory = category;
    }

    public String getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(String date) {
        this.raceDate = date;
    }
}
