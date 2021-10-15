package com.data.utils;

import com.data.Course;
import com.data.Student;
import com.data.Teacher;
import com.data.teacherSubclass.FullTimeTeacher;
import com.data.teacherSubclass.PartTimeTeacher;

import java.util.ArrayList;

public class DataInitialization {
    public static ArrayList<Teacher> initializeTeachers() {

        ArrayList<Teacher> teachers = new ArrayList<Teacher>();

        teachers.add(new PartTimeTeacher("Pedro", 20, 74000F));
        teachers.add(new FullTimeTeacher("Oscar", 8, 80000F));
        teachers.add(new PartTimeTeacher("Juan", 40, 45000F));
        teachers.add(new FullTimeTeacher("Felipe", 10, 80000F));
        teachers.add(new FullTimeTeacher("Carol", 10, 100000F));
        teachers.add(new PartTimeTeacher("Pablo", 38, 60000F));

        return teachers;
    }

    public static ArrayList<Student> initializeStudents() {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Jose", 30));
        students.add(new Student("Geronimo", 25));
        students.add(new Student("Pedro", 22));
        students.add(new Student("Pablo", 24));
        students.add(new Student("Erik", 26));
        students.add(new Student("Roberto", 28));
        students.add(new Student("Gustavo", 28));
        students.add(new Student("Jimena", 28));
        students.add(new Student("Victor", 28));

        return students;
    }


    /**
     * @param numberOfClassesToCreate <b>Must be an integer between 4 and 6</b>
     * @param teachers                Receives an initialized list of Teachers
     * @param students                Receives an initialized list of Students
     * @return List of courses initialized
     */

    public static ArrayList<Course> initializeCourseList(int numberOfClassesToCreate, ArrayList<Teacher> teachers, ArrayList<Student> students) {

        ArrayList<Course> courseList = new ArrayList<>();

        ArrayList<Student> studentPool;;


        ArrayList<Student> studentsToIndex = new ArrayList<>();
        String[] classNames = {"Math", "Biology", "Chemistry", "Spanish", "Geometry", "Arts"};
        String[] classRooms = {"B-12", "B-5", "A-10", "C-8", "B-10", "A-1"};

        int indexOfStudentFromPool;
        int teachersIndex;

        for (int a = 0; a < numberOfClassesToCreate ; a++) {

            studentPool = (ArrayList<Student>) students.clone();
            for (int i = 0; i < (int) Math.floor(Math.random() * 4) + 4; i++) {

                indexOfStudentFromPool = (int) Math.floor(Math.random() * studentPool.size());
                studentsToIndex.add(studentPool.remove(indexOfStudentFromPool));
            }
            teachersIndex = (int)Math.floor(Math.random() * teachers.size());
            courseList.add(new Course(classNames[a], classRooms[a], teachers.remove(teachersIndex), studentsToIndex));
            studentsToIndex = new ArrayList<>();
        }


        return courseList;
    }
}
