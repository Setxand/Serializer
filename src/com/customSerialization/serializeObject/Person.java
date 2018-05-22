package com.customSerialization.serializeObject;

import java.io.Serializable;

public class Person implements Serializable{
    private String view;
    private String firstName;
    private String lastName;
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setJsonView(){
        this.view = "{\n\"firstName\" : \""+firstName+"\"" +
                "\"lastName\" : "+lastName+"" +
                "\"address\" : "+address+"\n}";
    }

    @Override
    public String toString() {
        return view;
    }
}
