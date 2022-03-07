package edu.sharif.mpqueraapp.model;

import java.util.LinkedList;

public class User {

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
        this.id = lastId++;
        this.courses = new LinkedList<>();
    }

}
