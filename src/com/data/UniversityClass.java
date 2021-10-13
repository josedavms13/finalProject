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

    /*public String getWholeClassAsStringByIndex(int index){

        return ""
    }*/

    public String getAllStudentsAsString(){
        StringBuilder output = new StringBuilder();

        for(Student student : students){
            output.append("\t -> ").append(student.getName()).append("\n");
        }


        return output.toString();
    }

    public String getClassAsString(){

        return className.toLowerCase(Locale.ROOT) + "TEACHER: " + teacher.getName() + " Size: " + getSize();
    }


    public int getSize(){
        return students.size();
    }

}

