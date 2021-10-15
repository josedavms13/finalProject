package com.data;

import java.util.ArrayList;
import java.util.Locale;

public class Course {
    private final String className;
    private final String assignedRoom;
    private final Teacher teacher;
    private final ArrayList<Student> students;

    public Course(String name, String assignedRoom, Teacher teacher, ArrayList<Student> students) {
        this.className = name;
        this.assignedRoom = assignedRoom;
        this.teacher = teacher;
        this.students = students;

//        System.out.println("students in course");
//        System.out.println(students);
    }

    public String getClassName() {
        return className;
    }

    public String getAssignedRoom() {
        return assignedRoom;
    }

    public String getTeacher() {
        return teacher.getName();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }



    public String getAllStudentsAsString(){
        StringBuilder output = new StringBuilder();

        for(Student student : students){
            output.append("\t -> ").append(student.getName()).append("\n");
        }


        return output.toString();
    }

    public String getClassAsString(){
        System.out.println(students);
        return className.toUpperCase(Locale.ROOT) + " => Teacher: " + teacher.getName() + " || Number of students: " + getSize();
    }



    public int getSize(){
        return students.size();
    }

}

