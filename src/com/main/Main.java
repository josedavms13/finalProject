package com.main;

import com.data.Teacher;
import com.data.University;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        University university = new University();

        System.out.println(university.getAllClassesAsString());
    }
}
