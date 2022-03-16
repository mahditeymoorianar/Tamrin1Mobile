package edu.sharif.mpqueraapp.model;

import java.util.LinkedList;

public class Homework{
    // TODO : to add deadline
    public static int homeworkId = 0;
    public String title;
    public String description;
    public int courseId;
    public LinkedList<Integer> answersIds;
    public int id;

    public Homework(int courseId) {
        this.courseId = courseId;
        title = "untitled";
        description = "No description";
        this.answersIds = new LinkedList<>();
        this.id = homeworkId + 1;
        homeworkId ++;
    }

    public Homework(int courseId, String title) {
        this.courseId = courseId;
        this.title = title;
        description = "No description";
        this.answersIds = new LinkedList<>();
        this.id = homeworkId + 1;
        homeworkId ++;
    }

    public Homework(int courseId, String title, String description) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.answersIds = new LinkedList<>();
        this.id = homeworkId + 1;
        homeworkId ++;
    }

    public static void addAnswer(int studentId, int homeworkId, String answer){
        HomeworkAnswer homeworkAnswer = new HomeworkAnswer(studentId, homeworkId, answer);
        // Load homework with homeworkId id
        // Update answersIds List
        // Save the progress
    }

}
