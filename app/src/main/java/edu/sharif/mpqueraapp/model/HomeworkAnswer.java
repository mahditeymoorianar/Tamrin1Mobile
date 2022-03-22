package edu.sharif.mpqueraapp.model;

import java.util.HashMap;
import java.util.LinkedList;

public class HomeworkAnswer {

    public static int homeworkAnswerId = 0;
    public static HashMap<Integer, HomeworkAnswer> answersIds = new HashMap<Integer, HomeworkAnswer>();
    public static LinkedList<HomeworkAnswer> homeworkAnswers = new LinkedList<>();
    public String answer;
    public int studentId;
    public int homeworkId;
    public int id;
    public int grade;

    public HomeworkAnswer(int studentId, int homeworkId, String answer){
        this.studentId = studentId;
        this.homeworkId = homeworkId;
        this.answer = answer;
        this.id = homeworkAnswerId + 1;
        homeworkAnswerId ++;
        this.grade = -1;
        answersIds.put(id, this);
        Homework.getHomeworkById(homeworkId).answersIds.add(this.id);
        homeworkAnswers.add(this);
        answersIds.put(this.id, this);
    }

    public void delete() {
        Homework.getHomeworkById(homeworkId).answersIds.remove(this.id);
    }


    @Override
    public String toString() {
        return "HomeworkAnswer{" +
                "answer='" + answer + '\'' +
                ", studentId=" + studentId +
                ", homeworkId=" + homeworkId +
                ", id=" + id +
                ", grade=" + grade +
                '}';
    }
}
