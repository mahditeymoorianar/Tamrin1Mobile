package edu.sharif.mpqueraapp.model;

import java.io.IOException;
import java.util.LinkedList;

import edu.sharif.mpqueraapp.controller.data.Save;
import edu.sharif.mpqueraapp.view.authentication.AuthActivity;

public class Professor extends User{

    public String university;
    public static LinkedList<Professor> professors = new LinkedList<>();
    public static Professor activeProf;

    public Professor(String username, String password, String name, String lastName, String university) {
        super(username, password, name, lastName);
        this.university = university;
        professors.add(this);
        try {
            Save.saveProfessors(AuthActivity.mPrefs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Professor getProf(String username){
        for (Professor professor : professors) {
            if (professor.username.equals(username)){
                return professor;
            }
        }
        return null;
    }


    public static Professor getProfById(Integer id){
        for (Professor professor : professors) {
            if (professor.id == id){
                 return professor;
            }
        }
        return null;
    }


    public boolean hasCourse(String courseName) {
        System.out.println(courses);
        System.out.println(Course.coursesIds);
        for (Integer courseId : courses) {
            if(Course.coursesIds.get(courseId) != null){
                if (Course.coursesIds.get(courseId).courseName.equals(courseName)) {
                    return true;
                }
            }
        }
        return false;
    }
}
