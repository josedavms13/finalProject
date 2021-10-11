package com.data;

import java.util.ArrayList;

public class UniversityClass {
    private final String name;
    private final String assignedRoom;

    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;

    public UniversityClass(String name, String assignedRoom, ArrayList<Teacher> teachers, ArrayList<Student> students) {
        this.name = name;
        this.assignedRoom = assignedRoom;
        this.teachers = teachers;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public String getAssignedRoom() {
        return assignedRoom;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public String getAllPeopleInClass() {
        StringBuilder allPeople = new StringBuilder();

        allPeople.append("=========TEACHERS========");

        for (Teacher teacher : teachers) {
            allPeople.append(teacher.name).append("  TYPE: ").append(teacher.getType()).append("\n");
        }

        allPeople.append("\n").append("=================STUDENTS============");

        for (Student student : students) {
            allPeople.append(student.getId()).append(" ").append(student.getName()).append("\n");
        }
        return allPeople.toString();
    }

}

