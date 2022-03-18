package edu.sharif.mpqueraapp.model;

import java.io.IOException;
import java.util.LinkedList;

import edu.sharif.mpqueraapp.controller.data.Save;
import edu.sharif.mpqueraapp.view.authentication.AuthActivity;

public class User {

    public static LinkedList<User> users = new LinkedList<>();

    public static int lastId = 0;
    public String username;
    public String password;
    public String name;
    public String lastName;
    public LinkedList<Integer> courses;
    public int id;

    public User(String username, String password, String name, String lastName){
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.id = lastId + 1;
        lastId++;
        this.courses = new LinkedList<>();
    }


    public static Integer usernameToId(String username){
        for (User user : users) {
            if (user.username.equals(username)){
                return user.id;
            }
        }
        return -1;
    }

    public void addNewCourse(String courseName) {
        Course newCourse = new Course(this.id, courseName);
        courses.add(newCourse.id);

        try {
            Save.saveProfessors(AuthActivity.mPrefs);
            Save.saveCourses(AuthActivity.mPrefs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
