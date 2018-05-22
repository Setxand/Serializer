package com.customSerialization;

import com.customSerialization.serializeObject.Address;
import com.customSerialization.serializeObject.Person;

public class Application {
    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("Petro");
        person.setLastName("Matt");
        person.setAddress(new Address("Lukasha","Lviv"));
        person.setJsonView();

        System.out.println(person);
    }
}
