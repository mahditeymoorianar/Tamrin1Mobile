package edu.sharif.mpqueraapp.model;

import java.util.HashMap;
import java.util.LinkedList;

public class Course {

    public static int courseId = 0;
    public int profId;
    public LinkedList<Integer> studentsIds;
    public LinkedList<Integer> homeworksIds;
    public String courseName;
    public static LinkedList<Course> courses = new LinkedList<>();
    public static HashMap<Integer, Course> coursesIds = new HashMap<>();
    public int id;

    public Course(int profId, String courseName) {
        this.courseName = courseName;
        this.profId = profId;
        this.id = courseId + 1;
        this.studentsIds = new LinkedList<>();
        this.homeworksIds = new LinkedList<>();
        courseId++;
        coursesIds.put(courseId, this);
        courses.add(this);
    }



    public void addStudent(){

    }
}
