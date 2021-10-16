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
        System.out.println("teachers en main");
        System.out.println(teachers);
        ArrayList<Course> courses = DataInitialization.initializeCourseList(5, teachers, students);

        University university = new University(teachers, students, courses);

        System.out.println("Courses");
        System.out.println(university.getAllClassesAsString());


        System.out.println("-------------------");


        createNewCourseWithData(university, "nuevo", "Z 999", 3, new ArrayList<Integer>(){{add(2);add(3); add(4);}});
        System.out.println(university.getAllClassesAsString());

        System.out.println(university.getCourseGeneralInformationByIndex(6));

    }

    private static void printAllProfessorsWithItsData(University university){

        System.out.println(university.getAllTeachersAsString());
    }

    private static void printAllClasses(University university){
        System.out.println(university.getAllClassesAsString());
    }

    private static void printAClassDetails(University university, int index){
        System.out.println(university.getCourseGeneralInformationByIndex(index));
    }

    private static void createANewStudent(University university, String name, int age, int courseToAdd){
        university.addNewStudentAndAddToCourse(new Student(name, age), courseToAdd);
    }

    private static void createNewCourseWithData(University university ,String className, String room, int teacherIndex, ArrayList<Integer> studentsIds){
        university.createNewCourseWithData(className, room, teacherIndex, studentsIds);
    }

}
