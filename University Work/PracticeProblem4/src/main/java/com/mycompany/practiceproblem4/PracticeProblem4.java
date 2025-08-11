
package com.mycompany.practiceproblem4;


public class PracticeProblem4 {

    public static void main(String[] args) {
        RegularUser u1 = new RegularUser("john_doe", "john_pic.png");
        BusinessAccount u2 = new BusinessAccount("tech_gadgets", "tech_logo.png", "Tech Gadgets Ltd.");
        Influencer u3 = new Influencer("fashion_star", "fashion_pic.png", 500000);

        // Regular User Actions
        u1.displayProfile();
        u1.postContent("Just enjoying a sunny day!");

        System.out.println();

        // Business Account Actions
        u2.displayProfile();
        u2.postContent("New smartphone launch tomorrow!");
        u2.promoteProduct("SmartX Pro Max");

        System.out.println();

        // Influencer Actions
        u3.displayProfile();
        u3.postContent("My latest fashion shoot is live!");
        u3.collaborateWithBrand("StyleHub");
    }
}