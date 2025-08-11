
package com.mycompany.practiceproblem4;


public class BusinessAccount extends User implements ContentCreator, Advertiser {

    private String businessName;

    public BusinessAccount(String username, String profilePicture, String businessName) {
        super(username, profilePicture);
        this.businessName = businessName;
    }

    @Override
    public void postContent(String content) {
        System.out.println(businessName + " posted business content: " + content);
    }

    @Override
    public void promoteProduct(String productName) {
        System.out.println(businessName + " is promoting product: " + productName);
    }

    @Override
    public void displayProfile() {
        System.out.println("Business Account: " + username +
                " | Business Name: " + businessName +
                " | Profile Picture: " + profilePicture);
    }
}
