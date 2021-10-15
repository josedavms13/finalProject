package com.data;

public class Student {
    private static int lastId;
    private final String name;
    private final int age;
    private final int id;

    public Student(String name, int age){
        this.name = name;
        this.age = age;

        this.id = lastId;
        lastId++;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWholeInformation(){
        return "ID = " + this.id + " Name: " + this.name + " Age: " + this.age;
    }
}
