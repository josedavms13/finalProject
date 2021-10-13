package com.data;

import com.data.teacherSubclass.FullTimeTeacher;
import com.data.teacherSubclass.PartTimeTeacher;

import java.util.ArrayList;
import java.util.Locale;

public class University {
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<UniversityClass> universityClasses = new ArrayList<UniversityClass>();

    public University(ArrayList<Teacher> teachers, ArrayList<Student> students, ArrayList<UniversityClass> universityClasses) {
        this.teachers = teachers;
        this.students = students;
        this.universityClasses = universityClasses;
    }

    public University() {
        teachersInitialization();
        studentsInitialization();
        universityClassesInitialization();
    }


    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<UniversityClass> getUniversityClasses() {
        return universityClasses;
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

    private void universityClassesInitialization() {

        // Crete 4 different university with random teachers and random students
        ArrayList<Student> studentsToIndex = new ArrayList<>();
        String [] classNames = {"Math", "Biology", "Chemistry", "Spanish"};
        String [] classRooms = {"B-12", "B-5", "A-10", "C-8"};
        int studentIndex;
        int teachersIndex;
        for (int i = 0; i <4; i++) {
            for (int a = 0; a < 5; a++) {
                studentIndex = (int) Math.floor(Math.random() * students.size());
                studentsToIndex.add(students.get(studentIndex));
            }

            teachersIndex = (int) Math.floor(Math.random() * teachers.size());

            universityClasses.add(new UniversityClass(classNames[i], classRooms[i], teachers.get(teachersIndex), studentsToIndex ));
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



        return output.toString();
    }

    public String getAParticularClassAsString(int index){

        return " == " + universityClasses.get(index).toString().toUpperCase(Locale.ROOT) + " CLASS == \n" +
                universityClasses.get(index).getClassAsString();
    }








}
