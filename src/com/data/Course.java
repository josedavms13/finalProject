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

    public String getCourseTeacher() {
        return
                teacher.getName() + " || "+ teacher.getType();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }



    public String getAllStudentsAsString(){
        StringBuilder output = new StringBuilder();

        for(Student student : students){
            output.append("\t -> ").append(student).append("\n");
        }

        return output.toString();
    }

    public String getClassAsString(){
        return this.className.toUpperCase(Locale.ROOT) + " => Teacher: " + teacher.getName() + " || Number of students: " + getSize();
    }

    public boolean findStudentInCourse(int studentId){
        return students.stream().anyMatch(student -> {
            return student.getId() == studentId;
        });
    }


    public boolean addStudent(Student student){
        students.add(student);
        return true;
    }


    public int getSize(){
        return students.size();
    }

}

