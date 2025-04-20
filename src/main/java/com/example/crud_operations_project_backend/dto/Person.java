package com.example.crud_operations_project_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String id;
    private String name;
    private String email;
    private String age;

    public Person(){
        super();
    }

    public Person(String id, String name, String email, String age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
