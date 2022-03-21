package edu.sharif.mpqueraapp.controller.data;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.LinkedList;

import edu.sharif.mpqueraapp.model.Course;
import edu.sharif.mpqueraapp.model.Homework;
import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.model.User;

public class Load {

    public static void loadUsers(SharedPreferences mPrefs){

        Type listType = new TypeToken<LinkedList<Student>>(){}.getType();
        Gson gson = new Gson();
        String json = mPrefs.getString("students", "");
        Student.students = gson.fromJson(json, listType);

//        gson = new Gson();
//        listType = new TypeToken<LinkedList<Integer>>(){}.getType();
//        String studentLastId = mPrefs.getString("StudentId", "");
//        Student.lastId = Integer.parseInt(gson.fromJson(studentLastId, listType));

        listType = new TypeToken<LinkedList<Professor>>(){}.getType();
        gson = new Gson();
        json = mPrefs.getString("professors", "");
        Professor.professors = gson.fromJson(json, listType);

//        gson = new Gson();
//        listType = new TypeToken<LinkedList<Integer>>(){}.getType();
//        String professorLastId = mPrefs.getString("ProfessorId", "");
//        Professor.lastId = Integer.parseInt(gson.fromJson(professorLastId, listType));

        if (Professor.professors == null){
            Professor.professors = new LinkedList<>();
        }
        if (Student.students == null){
            Student.students = new LinkedList<>();
        }


        Log.d(Professor.professors.size()+"", "loadUsers: ");

    }

    public static void loadCourses(SharedPreferences mPrefs) {
        Type listType = new TypeToken<LinkedList<Course>>(){}.getType();
        Gson gson = new Gson();
        String json = mPrefs.getString("courses", "");
        Course.courses = gson.fromJson(json, listType);

//        gson = new Gson();
//        listType = new TypeToken<LinkedList<Integer>>(){}.getType();
//        String courseLastId = mPrefs.getString("CourseId", "");
//        Course.courseId = Integer.parseInt(gson.fromJson(courseLastId, listType));

        if (Course.courses == null){
            Course.courses = new LinkedList<>();
        }

        for (Course course : Course.courses) {
            Course.coursesIds.put(course.id, course);
        }

    }


    public static void loadHomeworks(SharedPreferences mPrefs) {
        Type listType = new TypeToken<LinkedList<Homework>>(){}.getType();
        Gson gson = new Gson();
        String json = mPrefs.getString("homeworks", "");
        Homework.homeworks = gson.fromJson(json, listType);

//        gson = new Gson();
//        listType = new TypeToken<LinkedList<Integer>>(){}.getType();
//        String studentLastId = mPrefs.getString("HomeworkId", "");
//        Homework.homeworkId = Integer.parseInt(gson.fromJson(studentLastId, listType));

        if (Homework.homeworks == null){
            Homework.homeworks = new LinkedList<>();
        }

        for (Homework homework : Homework.homeworks) {
            Homework.homeworksIds.put(homework.id, homework);
        }
    }

}
