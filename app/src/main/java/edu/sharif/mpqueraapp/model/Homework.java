package edu.sharif.mpqueraapp.model;

import java.util.LinkedList;

public class Homework{

    public static int homeworkId = 0;
    public int courseId;
    public LinkedList<Integer> answersIds;
    public int id;

    public Homework(int courseId) {
        this.courseId = courseId;
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
