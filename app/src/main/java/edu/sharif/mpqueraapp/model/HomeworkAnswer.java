package edu.sharif.mpqueraapp.model;

public class HomeworkAnswer {

    public static int homeworkAnswerId = 0;
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
        Homework.getHomeworkById(homeworkId).answersIds.add(this.id);
    }

    public void delete() {
        Homework.getHomeworkById(homeworkId).answersIds.remove(this);
    }



}
