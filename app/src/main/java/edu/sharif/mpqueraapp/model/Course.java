package edu.sharif.mpqueraapp.model;

import java.util.LinkedList;

public class Course {
    public static int id = 0;
    public int profId;
    public LinkedList<Integer> studentsIds;
    public LinkedList<Integer> homeworksIds;


    public Course(int profId) {
        this.profId = profId;
        this.studentsIds = new LinkedList<>();
        this.homeworksIds = new LinkedList<>();
    }
}
