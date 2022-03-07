package edu.sharif.mpqueraapp.model;

public class Professor extends User{
    public String university;

    public Professor(String username, String password, String name, String lastName, String university) {
        super(username, password, name, lastName);
        this.university = university;
    }
}
