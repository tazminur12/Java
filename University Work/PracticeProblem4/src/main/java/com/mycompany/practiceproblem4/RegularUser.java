
package com.mycompany.practiceproblem4;

public class RegularUser extends User implements ContentCreator {

    public RegularUser(String username, String profilePicture) {
        super(username, profilePicture);
    }

    @Override
    public void postContent(String content) {
        System.out.println(username + " posted: " + content);
    }

    @Override
    public void displayProfile() {
        System.out.println("Regular User: " + username +
                " | Profile Picture: " + profilePicture);
    }
}
