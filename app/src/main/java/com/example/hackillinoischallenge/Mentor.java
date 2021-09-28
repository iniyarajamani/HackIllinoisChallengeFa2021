package com.example.hackillinoischallenge;

public class Mentor {
    private String firstName;
    private String lastName;
    private String profile;
    private String description;

    public Mentor(String firstName, String lastName, String profile, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profile = profile;
        this.description = description;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
