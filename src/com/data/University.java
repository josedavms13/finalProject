package com.data;

import java.util.ArrayList;

public class University {
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<UniversityClass> universityClasses;

    public University(ArrayList<Teacher> teachers, ArrayList<Student> students, ArrayList<UniversityClass> universityClasses) {
        this.teachers = teachers;
        this.students = students;
        this.universityClasses = universityClasses;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<UniversityClass> getUniversityClasses() {
        return universityClasses;
    }
}
