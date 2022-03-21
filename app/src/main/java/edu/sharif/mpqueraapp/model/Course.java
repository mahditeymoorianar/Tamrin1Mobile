package edu.sharif.mpqueraapp.model;

import java.util.HashMap;
import java.util.LinkedList;

public class Course {

    public static int lastCourseId = 0;
    public int profId;
    public LinkedList<Integer> studentsIds;
    public LinkedList<Integer> homeworksIds;
    public String courseName;
    public static LinkedList<Course> courses = new LinkedList<>();
    public static HashMap<Integer, Course> coursesIds = new HashMap<>();
    public static Course activeCourse;
    public int id;

    @Override
    public String toString() {
        return "Course{" +
                "profId=" + profId +
                ", studentsIds=" + studentsIds +
                ", homeworksIds=" + homeworksIds +
                ", courseName='" + courseName + '\'' +
                ", id=" + id +
                '}';
    }

    public Course(int profId, String courseName) {
        this.courseName = courseName;
        this.profId = profId;
        this.id = lastCourseId + 1;
        this.studentsIds = new LinkedList<>();
        this.homeworksIds = new LinkedList<>();
        lastCourseId++;
        coursesIds.put(lastCourseId, this);
        courses.add(this);
    }



    public static Integer name2id(String name){
        for (Course course : courses) {
            if (course.courseName.equals(name)){
                return course.id;
            }
        }
        return -1;
    }


}
