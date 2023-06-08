package com.springboot.SpringMongoDB.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "persons")
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private int age;
    private String address;

    public Person(String firstname, String lastname, int age, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.address = address;
    }
}
