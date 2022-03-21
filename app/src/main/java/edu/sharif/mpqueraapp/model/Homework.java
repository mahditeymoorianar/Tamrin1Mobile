package edu.sharif.mpqueraapp.model;

import java.util.HashMap;
import java.util.LinkedList;

public class Homework{
    public static int lastHomeworkId = 0;
    public String title;
    public String description;
    public int courseId;
    public LinkedList<Integer> answersIds;
    public int id;
    public static LinkedList<Homework> homeworks = new LinkedList<>();
    public static HashMap<Integer, Homework> homeworksIds = new HashMap<>();

    public Homework(int courseId) {
        this.courseId = courseId;
        title = "untitled";
        description = "No description";
        this.answersIds = new LinkedList<>();
        this.id = lastHomeworkId + 1;
        lastHomeworkId ++;
        Course.coursesIds.get(courseId).homeworksIds.add(this.id);
        homeworksIds.put(id, this);
        homeworks.add(this);
    }

    public Homework(int courseId, String title) {
        this.courseId = courseId;
        this.title = title;
        description = "No description";
        this.answersIds = new LinkedList<>();
        this.id = lastHomeworkId + 1;
        lastHomeworkId ++;
        Course.coursesIds.get(courseId).homeworksIds.add(this.id);
        homeworksIds.put(id, this);
        homeworks.add(this);
    }

    public Homework(int courseId, String title, String description) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.answersIds = new LinkedList<>();
        this.id = lastHomeworkId + 1;
        lastHomeworkId ++;
        Course.coursesIds.get(courseId).homeworksIds.add(this.id);
        homeworksIds.put(id, this);
        homeworks.add(this);
    }

    public static void addAnswer(int studentId, int homeworkId, String answer){
        HomeworkAnswer homeworkAnswer = new HomeworkAnswer(studentId, homeworkId, answer);
        // Load homework with homeworkId id
        // Update answersIds List
        // Save the progress
    }

    public static Homework getHomeworkById(Integer id){
        for (Homework homework : homeworks) {
            if (homework.id == id){
                return homework;
            }
        }
        return null;
    }

    public static Integer name2id(String title){
        for (Homework homework : homeworks) {
            if (homework.title.equals(title)){
                return homework.id;
            }
        }
        return -1;
    }

    public HomeworkAnswer getStudentsAnswer(int studentId) {
        for (Integer answerId :
                answersIds) {
            if (HomeworkAnswer.answersIds.get(answerId).studentId == studentId) {
                return HomeworkAnswer.answersIds.get(answerId);
            }
        }
        return null;
    }

}
