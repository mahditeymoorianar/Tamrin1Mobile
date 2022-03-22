package edu.sharif.mpqueraapp.model;

import android.util.Log;

import java.io.IOException;
import java.util.LinkedList;

import edu.sharif.mpqueraapp.controller.data.Save;
import edu.sharif.mpqueraapp.view.authentication.AuthActivity;

public class Student extends User{

    public String studentsId;
    public LinkedList<Integer> homeworkAnswers;
    public static LinkedList<Student> students = new LinkedList<>();
    public static Student activeStudent;


    public Student(String username, String password, String name, String lastName,String studentsId) {
        super(username, password, name, lastName);
        this.studentsId = studentsId;
        this.homeworkAnswers = new LinkedList<>();
        students.add(this);
        try {
            Save.saveStudents(AuthActivity.mPrefs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Student getStudent(String username){
        for (Student student : students) {
            if (student.username.equals(username)){
                return student;
            }
        }
        return null;
    }

    public static Student getStudentById(int id) {
        for (Student student : students) {
            if (student.id == id)
                return student;
        }
        return null;
    }
}
