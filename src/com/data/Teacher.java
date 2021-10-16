package com.data;

public abstract class Teacher {


    private final String name;
    protected abstract float getBaseSalary();
    protected abstract String getType();
    public abstract String toString();

    public String getName(){
        return this.name;
    };
    protected abstract String getSalaryMultiplier();

    public Teacher(String name){
        this.name = name;
    }
}
