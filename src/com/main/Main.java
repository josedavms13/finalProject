package com.main;

import com.data.Course;
import com.data.Student;
import com.data.Teacher;
import com.data.University;
import com.data.utils.DataInitialization;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList <Student> students = DataInitialization.initializeStudents();
        ArrayList<Teacher> teachers = DataInitialization.initializeTeachers();
        ArrayList<Course> courses = DataInitialization.initializeCourseList(5, teachers, students);

        University university = new University(teachers, students, courses);


        System.out.println(university.getAllStudentAsString());
        university.getCoursesByStudentId(2)
                .forEach(course -> System.out.println(course.getClassName()));

    }
}
