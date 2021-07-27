package com.harry.datbase.model;
// CONTACT MEANS ONE ROW;
public class contact {
    private int id;
    private String name;
    private String phone_number;

    public contact(String name, String phone_number) {
        // if will manage by the database, I will give only name and phone number
        this.name = name;
        this.phone_number = phone_number;
    }

    // manlo kisi se id bhi dedi.
    public contact(int id,String name, String phone_number) {
        // if will manage by the database, I will give only name and phone number
        this.id=id;
        this.name = name;
        this.phone_number = phone_number;
    }

    // koi koi kush bhi pass ni krta, tab bhi object bn jail
    public contact() {
    }


    // setter method;
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }


    // getter method;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }
}
