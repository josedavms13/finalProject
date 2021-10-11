package com.data;

import com.data.teacherSubclass.FullTimeTeacher;
import com.data.teacherSubclass.PartTimeTeacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class University {
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>() {};
    private ArrayList<Student> students;
    private ArrayList<UniversityClass> universityClasses;

    public University(ArrayList<Teacher> teachers, ArrayList<Student> students, ArrayList<UniversityClass> universityClasses) {
        this.teachers = teachers;
        this.students = students;
        this.universityClasses = universityClasses;
    }

    public University(){
        teachers.add(new PartTimeTeacher("Pedro", 20, 74000F));
        teachers.add(new FullTimeTeacher("Oscar", 8, 80000F));
        teachers.add(new PartTimeTeacher("Juan", 40, 45000F));
        teachers.add(new FullTimeTeacher("Felipe", 10, 80000F));
        teachers.add(new FullTimeTeacher("Carol", 10, 100000F));
        teachers.add(new PartTimeTeacher("Pablo", 38, 60000F));
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
