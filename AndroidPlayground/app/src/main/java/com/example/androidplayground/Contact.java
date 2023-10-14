package com.example.androidplayground;

public class Contact {
    private int profileImage;
    private String name;
    private String message;

    public Contact(int profileImage, String name, String message) {
        this.profileImage = profileImage;
        this.name = name;
        this.message = message;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
