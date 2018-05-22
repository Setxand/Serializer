package com.customSerialization.serializeObject;

public class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    @Override
    public String toString() {
        return "{\n\"street\" : \""+street+"\"" +
                "\"city\" : \""+city+"\"\n}";
    }
}
