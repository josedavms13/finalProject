package com.data;

import com.data.teacherSubclass.FullTimeTeacher;
import com.data.teacherSubclass.PartTimeTeacher;

import java.util.ArrayList;
import java.util.Locale;

public class University {
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Student> students = new ArrayList<Student>();
    public ArrayList<Course> courseList = new ArrayList<Course>();

    public University() {
        teachersInitialization();
        studentsInitialization();
        coursesListInitialization();
    }


    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }


    //region INITIALIZATION METHODS
    private void teachersInitialization() {
        teachers.add(new PartTimeTeacher("Pedro", 20, 74000F));
        teachers.add(new FullTimeTeacher("Oscar", 8, 80000F));
        teachers.add(new PartTimeTeacher("Juan", 40, 45000F));
        teachers.add(new FullTimeTeacher("Felipe", 10, 80000F));
        teachers.add(new FullTimeTeacher("Carol", 10, 100000F));
        teachers.add(new PartTimeTeacher("Pablo", 38, 60000F));
    }

    private void studentsInitialization() {
        students.add(new Student("Jose", 30));
        students.add(new Student("Geronimo", 25));
        students.add(new Student("Pedro", 22));
        students.add(new Student("Pablo", 24));
        students.add(new Student("Erik", 26));
        students.add(new Student("Roberto", 28));
        students.add(new Student("Gustavo", 28));
        students.add(new Student("Jimena", 28));
        students.add(new Student("Victor", 28));
    }

    private void coursesListInitialization() {

        int numberOfClassesToCreate = 4;


        ArrayList<Student> studentsToIndex = new ArrayList<>();
        String [] classNames = {"Math", "Biology", "Chemistry", "Spanish"};
        String [] classRooms = {"B-12", "B-5", "A-10", "C-8"};
        int studentRandomPicker;
        int teachersIndex;

        for (int i = 0; i < numberOfClassesToCreate; i++) {

            // Inserts randomly between 4 and 8 students
            for (int a = 0; a < (int)Math.floor(Math.random() * 4) + 4; a++) {
                studentRandomPicker = (int) Math.floor(Math.random() * students.size());
                studentsToIndex.add(students.get(studentRandomPicker));
            }

            teachersIndex = (int) Math.floor(Math.random() * teachers.size());
            System.out.println("studentsToIndex");
            System.out.println(studentsToIndex);
            this.courseList.add(new Course(classNames[i], classRooms[i], teachers.get(teachersIndex), studentsToIndex ));
            studentsToIndex = new ArrayList<>();
        }

    }
    //endregion



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

    public String getAParticularClassAsString(int index){

        return " == " + courseList.get(index).toString().toUpperCase(Locale.ROOT) + " CLASS == \n" +
                courseList.get(index).getClassAsString();
    }








}
