package com.data;

import java.util.ArrayList;

public class UniversityClass {
    private final String name;
    private final String assignedRoom;
    private Teacher teacher;
    private ArrayList<Student> students;

    public UniversityClass(String name, String assignedRoom, Teacher teacher, ArrayList<Student> students) {
        this.name = name;
        this.assignedRoom = assignedRoom;
        this.teacher = teacher;
        this.students = students;

    }

    public String getName() {
        return name;
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

    public String getAllPeopleInClass() {
        StringBuilder allPeople = new StringBuilder();

        allPeople.append("Teacher: \n" +
                "\t this.teacher");

        allPeople.append("\n").append("=================STUDENTS============");

        for (Student student : students) {
            allPeople.append(student.getId()).append(" ").append(student.getName()).append("\n");
        }
        return allPeople.toString();
    }

    public int getSize(){
        return students.size();
    }

}

