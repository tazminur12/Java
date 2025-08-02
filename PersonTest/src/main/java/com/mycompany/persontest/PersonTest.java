

package com.mycompany.persontest;

public class PersonTest {
    public static void main(String[] args) {
       
        Person p1 = new Person();

        p1.setName("Tazminur Rahman Tanim");
        p1.setAge(25);
        p1.setGender("Male");
        p1.setAddress("Mohammmadpur, Dhaka");

        System.out.println("Name: " + p1.getName());
        System.out.println("Age: " + p1.getAge());
        System.out.println("Gender: " + p1.getGender());
        System.out.println("Address: " + p1.getAddress());
    }
}
