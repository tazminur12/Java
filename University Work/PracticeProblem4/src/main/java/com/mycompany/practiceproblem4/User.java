
package com.mycompany.practiceproblem4;

public abstract class User {
    protected String username;
    protected String profilePicture;

    public User(String username, String profilePicture) {
        this.username = username;
        this.profilePicture = profilePicture;
    }

    public String getUsername() { return username; }
    public String getProfilePicture() { return profilePicture; }

    public abstract void displayProfile();
}
