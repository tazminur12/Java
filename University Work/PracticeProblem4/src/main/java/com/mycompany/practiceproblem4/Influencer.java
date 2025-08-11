
package com.mycompany.practiceproblem4;

public class Influencer extends User implements ContentCreator, BrandCollaborator {

    private int followers;

    public Influencer(String username, String profilePicture, int followers) {
        super(username, profilePicture);
        this.followers = followers;
    }

    @Override
    public void postContent(String content) {
        System.out.println(username + " (Influencer) posted: " + content);
    }

    @Override
    public void collaborateWithBrand(String brandName) {
        System.out.println(username + " is collaborating with brand: " + brandName);
    }

    @Override
    public void displayProfile() {
        System.out.println("Influencer: " + username +
                " | Followers: " + followers +
                " | Profile Picture: " + profilePicture);
    }
}

