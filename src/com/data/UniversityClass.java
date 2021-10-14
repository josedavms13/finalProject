package com.data;

import java.util.ArrayList;
import java.util.Locale;

public class UniversityClass {
    private final String className;
    private final String assignedRoom;
    private Teacher teacher;
    private ArrayList<Student> students;

    public UniversityClass(String name, String assignedRoom, Teacher teacher, ArrayList<Student> students) {
        this.className = name;
        this.assignedRoom = assignedRoom;
        this.teacher = teacher;
        this.students = students;

        System.out.println(students);

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





    public String getClassAsString(){

        return className.toLowerCase(Locale.ROOT) + "TEACHER: " + teacher.getName() + " Size: " + getSize();
    }


    public int getSize(){
        return students.size();
    }

}

