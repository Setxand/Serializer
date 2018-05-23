package com.customSerialization;

import com.customSerialization.logic.Serializer;
import com.customSerialization.logic.impl.SerializerImpl;
import com.customSerialization.serializeObject.Address;
import com.customSerialization.serializeObject.Person;

public class Application {
    public static void main(String[] args) {
        Address address = new Address("Groove st.","Los santos");
        Person person = new Person();
        person.setFirstName("Artem");
        person.setLastName("Boyko");
        person.setAddress(address);
        person.setAge(14);
        person.setGender("male");
        Serializer serializer = new SerializerImpl();
        System.out.println(serializer.serializeAddressToProps(person));

    }
}
