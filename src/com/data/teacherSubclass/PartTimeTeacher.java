package com.data.teacherSubclass;

import com.data.Teacher;

public class PartTimeTeacher extends Teacher {
    private final String name;
    private final int hoursPerWeek;
    private final float salary;
    private final String type;

    public PartTimeTeacher(String name, int hoursPerWeek, float salary){
        this.name = name;
        this.hoursPerWeek = hoursPerWeek;
        this.salary = salary;
        this.type = "Part Time";
    }

    public String getName() {
        return name;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public float getSalary() {
        return salary;
    }

    public float getBaseSalary(){
        return hoursPerWeek * salary;
    }

    public String getType(){
        return this.type;
    }

    public String getSalaryMultiplier(){
        return this.hoursPerWeek + " Hours per week";
    }
}
