package edu.sharif.mpqueraapp.model;

import java.util.LinkedList;

public class Student extends User{

    public String studentsId;
    public LinkedList<Integer> homeworkAnswers;

    public Student(String username, String password, String name, String lastName,String studentsId) {
        super(username, password, name, lastName);
        this.studentsId = studentsId;
        this.homeworkAnswers = new LinkedList<>();
    }


}
