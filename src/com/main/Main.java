package com.main;

import com.data.Course;
import com.data.Student;
import com.data.Teacher;
import com.data.University;
import com.data.utils.DataInitializator;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList <Student> students = DataInitializator.initializeStudents();
        ArrayList<Teacher> teachers = DataInitializator.initializeTeachers();
        ArrayList<Course> courses = DataInitializator.initializeCourseList(5, teachers, students);

        University university = new University(teachers, students, courses);


        System.out.println(university.getAParticularClassAsString(2));

    }
}
