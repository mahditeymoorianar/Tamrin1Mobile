package edu.sharif.mpqueraapp.model;

import java.util.LinkedList;

public class Course {

    public static int courseId = 0;
    public int profId;
    public LinkedList<Integer> studentsIds;
    public LinkedList<Integer> homeworksIds;
    public int id;

    public Course(int profId) {
        this.profId = profId;
        this.id = courseId + 1;
        this.studentsIds = new LinkedList<>();
        this.homeworksIds = new LinkedList<>();
        courseId++;
    }
    public void addStudent(){

    }
}
