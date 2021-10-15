package com.data.teacherSubclass;

import com.data.Teacher;

public class FullTimeTeacher extends Teacher {
    private final String type;
    private final int yearsOfExperience;
    private final float salary;

    public FullTimeTeacher(String name, int yearsOfExperience, float salary){
        super(name);
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
        this.type = "Full Time";
    }


    public float getBaseSalary(){
        return salary * (yearsOfExperience + (yearsOfExperience / 10F));
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public float getSalary() {
        return salary;
    }

    public String getType() {
        return this.type;
    }

    public String getSalaryMultiplier(){
        return yearsOfExperience + " Years of Experience";
    }
}
