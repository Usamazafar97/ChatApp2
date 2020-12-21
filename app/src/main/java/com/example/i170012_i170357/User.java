package com.example.i170012_i170357;

public class User {
    private String id;
    private String username;
    private String imageURL;
    private String phoneNumber;
    private String description;

    public User(String id, String username, String imageURL, String phoneNumber, String description) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public User(String id, String username, String imageURL) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
    }

    public User() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
