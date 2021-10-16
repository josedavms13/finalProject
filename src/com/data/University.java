package com.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class University {
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<Course> courseList;

    public University(ArrayList<Teacher> teachers, ArrayList<Student> students, ArrayList<Course> courseList) {
        this.teachers = teachers;
        this.students = students;
        this.courseList = courseList;

    }

    /**
     * @return
     * <b>String</b>
     * A prepared to print String with the list of teachers and their details
     */
    public String getAllTeachersAsString() {
        StringBuilder output = new StringBuilder();
        output.append(" == TEACHERS == \n");
        int teacherIndex = 0;
        for (Teacher teacher : teachers) {
            output.append("\t index: ").append(teacherIndex).append(" -> ").append(teacher.getName()).append(" || ").append(teacher.getType()).append(" || Salary: ").append(teacher.getBaseSalary()).append(" || ").append(teacher.getSalaryMultiplier()).append("\n");
            teacherIndex++;
        }
        return output.toString();
    }


    public String getAllClassesAsString() {
        StringBuilder output = new StringBuilder();
        output.append(" == CLASSES == \n");
        for (int i = 0; i < this.courseList.size(); i++) {
            output.append(i + 1).append(") ").append(courseList.get(i).getClassAsString()).append(" Room: ").append(courseList.get(i).getAssignedRoom()).append("\n");
        }
        return output.toString();
    }


    public String getCourseGeneralInformationByIndex(int input) {
        int index = input - 1;
        return " == " + courseList.get(index).getClassName().toUpperCase(Locale.ROOT) + " CLASS == \n" +
                "TEACHER: \n"+
                courseList.get(index).getCourseTeacher() +
                "\n STUDENTS: \n"+
                courseList.get(index).getAllStudentsAsString();
    }


    public String getAllStudentAsString() {
        StringBuilder output = new StringBuilder();
        output.append("STUDENTS \n");
        int studentIndex = 0;
        for (Student student : students) {
            output.append("\t").append("index :").append(studentIndex).append(" -> ").append(student.getWholeInformation()).append("\n");
            studentIndex++;
        }
        return output.toString();
    }


    public List<String> getCoursesByStudentIdAsStringList(int studentId) {
        return
                courseList.stream()
                        .filter(course -> course.findStudentInCourse(studentId))
                        .map(course -> course.getClassAsString())
                        .collect(Collectors.toList());
    }


    public boolean addNewStudentAndAddToCourse(Student student, int courseIndex){

        if(courseIndex <= courseList.size()){
            this.students.add(student);
            return courseList.get(courseIndex).addStudent(student);
        }else
            return false;
    }

    public void createNewCourseWithData(String className, String room ,int teacherIndex, ArrayList<Integer> studentsIds){

        ArrayList<Student> studentsToAdd = new ArrayList<>();

        for (Integer studentId : studentsIds){
            studentsToAdd.add(
                    students.stream()
                            .filter(student -> student.getId() == studentId)
                            .collect(Collectors.toList())
                            .get(0)
            );
        }

        courseList.add(new Course(className, room, teachers.get(teacherIndex), studentsToAdd));
    }


    public boolean createNewTeacher(Teacher teacher){
        teachers.add(teacher);
        return true;
    }

    /**
     *
     * @param className
     * @param room
     * @param teacher
     * @param students
     * @return
     */
    public boolean createNewCourse(String className, String room, Teacher teacher, ArrayList<Student> students){
        courseList.add(new Course(className, room, teacher, students));
        return true;
    }

}
