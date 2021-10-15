package com.data;

import com.data.teacherSubclass.FullTimeTeacher;
import com.data.teacherSubclass.PartTimeTeacher;

import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class University {
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Course> courseList = new ArrayList<>();

    public University(ArrayList<Teacher> teachers, ArrayList<Student> students, ArrayList<Course> courseList) {
        this.teachers = teachers;
        this.students = students;
        this.courseList = courseList;
    }

    /**
     *
     * @return A prepared to print String with the list of teachers and their details
     */
    public String getAllTeachersAsString(){
        StringBuilder output = new StringBuilder();
        output.append(" == TEACHERS == \n");
        for (Teacher teacher: teachers){
            output.append("\t -> ").append(teacher.getName()).append(" || ").append(teacher.getType()).append(" || Salary: ").append(teacher.getBaseSalary()).append(" || ").append(teacher.getSalaryMultiplier()).append("\n");
        }
        return output.toString();
    }


    public String getAllClassesAsString(){
        StringBuilder output = new StringBuilder();
        output.append(" == CLASSES == \n");

        for (int i = 0; i < this.courseList.size(); i++) {
            output.append(i+1).append(") ").append(courseList.get(i).getClassAsString()).append("\n");
        }

        return output.toString();
    }


    public String getCourseGeneralInformationByIndex(int input){
        int index = input - 1;
        return " == " + courseList.get(index).getClassName().toUpperCase(Locale.ROOT) + " CLASS == \n" +
                courseList.get(index).getClassAsString() + "\n" +
                courseList.get(index).getAllStudentsAsString();
    }

    public String getAllStudentAsString(){
        StringBuilder output = new StringBuilder();
        output.append("STUDENTS \n");
        for(Student student : students){
            output.append(student.getWholeInformation()).append("\n");
        }
        return output.toString();
    }


    public void getCoursesByStudentId(int studentId){

        Stream<Student> a;
         Student theOne;

        a = students.stream().filter(student -> student.getId() == studentId);

        Student b = a.collect(Collectors.toList()).get(0);
        System.out.println(b.getName());


    }







}
