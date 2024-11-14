package com.example.myapplication;

import java.io.Serializable;

public class Student implements Serializable {
    private String id;
    private String name;
    private String email;
    //default constructor
    public Student(){
        this.id="P001";
        this.name="Aye Aye";
        this.email="aaa@gmail.com";
    }
    //constructor
    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
