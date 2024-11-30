package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    int course;
    double gpa; // средний балл
    List<String> courses;

    public Student(String name, int course, double gpa) {
        this.name = name;
        this.course = course;
        this.gpa = gpa;
    }

    public void add(String courseName){
        if(courses == null){
            this.courses = new ArrayList<>();
            courses.add(courseName);
        }else{
            courses.add(courseName);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}