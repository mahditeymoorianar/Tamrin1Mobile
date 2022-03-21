package edu.sharif.mpqueraapp.controller.data;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;

import edu.sharif.mpqueraapp.model.Course;
import edu.sharif.mpqueraapp.model.Homework;
import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.model.Student;

public class Save {
    static GsonBuilder gsonBuilder = new GsonBuilder();
    public static Gson gson = gsonBuilder.setPrettyPrinting().create();

    public static void saveStudents(SharedPreferences mPrefs) throws IOException {

        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Student.students);
        prefsEditor.putString("students", json);
//        String studentId = gson.toJson(Student.lastId);
//        prefsEditor.putString("StudentId", studentId);
        prefsEditor.commit();
    }
    public static void saveProfessors(SharedPreferences mPrefs) throws IOException {
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Professor.professors);
        prefsEditor.putString("professors", json);
//        String professorId = gson.toJson(Professor.lastId);
//        prefsEditor.putString("ProfessorId", professorId);
        prefsEditor.commit();
    }

    public static void saveCourses(SharedPreferences mPrefs) throws IOException {
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Course.courses);
        prefsEditor.putString("courses", json);
//        String courseId = gson.toJson(Course.courseId);
//        prefsEditor.putString("CourseId", courseId);
        prefsEditor.commit();
    }

    public static void saveHomeworks(SharedPreferences mPrefs) throws IOException {
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Homework.homeworks);
        prefsEditor.putString("homeworks", json);
//        String homeworkId = gson.toJson(Homework.homeworkId);
//        prefsEditor.putString("HomeworkId", homeworkId);
        prefsEditor.commit();
    }

}
