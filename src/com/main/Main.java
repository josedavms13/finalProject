package com.main;

import com.data.Course;
import com.data.Student;
import com.data.Teacher;
import com.data.University;
import com.data.utils.DataInitialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university = DataInitialization.initializeUniversity(5);

        boolean isRunning = true;

        int menuUserInput;
        System.out.println("WELCOME");

        while (isRunning) {
            System.out.println(
                    "Please type: \n" +
                            "1) To see all professors. \n" +
                            "2) To see all students. \n" +
                            "3) To see all courses. \n" +
                            "4) To create a new student and add it to a class \n" +
                            "5) To create a new class \n" +
                            "6) To see all classes taken by a student \n" +
                            "7) To exit the program \n"
            );

            menuUserInput = scanner.nextInt();

            switch (menuUserInput) {
                case 1:
                    printAllProfessorsWithItsData(university);
                    break;

                case 2:
                    printAllStudents(university);
                    break;

                case 3:
                    printAllClasses(university);
                    break;

                case 4:
                    createANewStudent(university);
                    break;

                case 5:
                    createNewCourseWithData(university);
                    break;

                case 6:
                    showClassesOfAStudent(university);

                case 7:
                    isRunning = false;
                    System.out.println("Program finished");
                    break;

                default:
                    showInvalidInputMessage();
                    break;
            }
        }
    }

    private static void printAllProfessorsWithItsData(University university) {

        System.out.println(university.getAllTeachersAsString());
    }

    private static void printAllStudents(University university) {
        System.out.println(university.getAllStudentAsString());
    }

    private static void printAllClasses(University university) {
        System.out.println(university.getAllClassesAsString());
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            int userSelection;
            System.out.println("Select one to see the details or type -1 to go back");
            userSelection = scanner.nextInt();
            if (userSelection > university.getCourseList().size() || userSelection < -1) {
                showInvalidInputMessage();
            } else if (userSelection == -1) {
                isRunning = false;
            } else {
                printAClassDetails(university, userSelection);
                isRunning = false;
            }
        }
    }

    private static void printAClassDetails(University university, int index) {
        System.out.println(university.getCourseGeneralInformationByIndex(index));
    }

    private static void createANewStudent(University university) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CREATING A NEW STUDENT");

        String studentName;
        int studentAge;
        int selectedCourse;

        boolean isRunning = true;


        System.out.println("Type the new student name");
        studentName = scanner.nextLine();
        System.out.println("Type the age");
        studentAge = scanner.nextInt();

        System.out.println("Select the course to add student in \n" + university.getAllClassesAsString());

        while (isRunning) {

            selectedCourse = scanner.nextInt();

            if (selectedCourse > university.getCourseList().size() || selectedCourse < 0) {
                showInvalidInputMessage();
            } else {
                university.addNewStudentAndAddToCourse(new Student(studentName, studentAge), selectedCourse);
                isRunning = false;
                System.out.println("Student added successfully");
            }
        }
    }

    private static void createNewCourseWithData(University university) {

        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        String className;
        String room;
        int teacherIndex;
        List<Integer> studentsIds;


        while (isRunning) {
            System.out.println("CREATING A NEW CLASS \n");
            System.out.println("Please type the class name");
            className = scanner.nextLine();

            System.out.println("Please type the classroom");
            room = scanner.nextLine();

            System.out.println("Type the Index (number) of the teacher\n" +
                    university.getAllTeachersAsString());
            teacherIndex = scanner.nextInt();

            System.out.println("Type the index of the students you want to add separated by a  \",\" " +
                    "\t For example: 1, 4, 5, 3");

            System.out.println(university.getAllStudentAsString());
            try {
                studentsIds = Arrays.stream(scanner.next().split(","))
                        .map(number -> Integer.valueOf(number))
                        .collect(Collectors.toList());
                university.createNewCourseWithData(className, room, teacherIndex, (ArrayList<Integer>) studentsIds);
                System.out.println("Course created successfully");
                isRunning = false;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid Numbers, be sure that a user with that ID exists");
            }
        }
    }


    private static void showClassesOfAStudent(University university) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("SHOWING CLASSES OF A STUDENT BY ID");

        boolean isRunning = true;
        int userMenuChoice;

        while (isRunning) {
            System.out.println("Please type the student's ID or type -1 to go back \n" + university.getAllStudentAsString());


            userMenuChoice = scanner.nextInt();

            if (userMenuChoice == -1) {
                isRunning = false;
            } else if (userMenuChoice < -1 || userMenuChoice > university.getStudentList().size()) {
                showInvalidInputMessage();
            } else {
                System.out.println(university.getCoursesByStudentIdAsString(userMenuChoice));
            }
        }
    }


    private static void showInvalidInputMessage() {
        System.out.println("Invalid input, please try again");
    }
}
