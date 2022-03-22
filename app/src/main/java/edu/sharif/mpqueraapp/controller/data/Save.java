package edu.sharif.mpqueraapp.controller.data;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;

import edu.sharif.mpqueraapp.model.Course;
import edu.sharif.mpqueraapp.model.Homework;
import edu.sharif.mpqueraapp.model.HomeworkAnswer;
import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.model.User;

public class Save {
    static GsonBuilder gsonBuilder = new GsonBuilder();
    public static Gson gson = gsonBuilder.setPrettyPrinting().create();

    public static void saveStudents(SharedPreferences mPrefs) throws IOException {

        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Student.students);
        prefsEditor.putString("students", json);

        String lastUserId = gson.toJson(User.lastId);
        prefsEditor.putString("lastUserId", lastUserId);

        prefsEditor.commit();
    }
    public static void saveProfessors(SharedPreferences mPrefs) throws IOException {
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Professor.professors);
        prefsEditor.putString("professors", json);

        String lastUserId = gson.toJson(User.lastId);
        prefsEditor.putString("lastUserId", lastUserId);

        prefsEditor.commit();
    }

    public static void saveCourses(SharedPreferences mPrefs) throws IOException {
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Course.courses);
        prefsEditor.putString("courses", json);

        String lastCourseId = gson.toJson(Course.lastCourseId);
        prefsEditor.putString("lastCourseId", lastCourseId);

        prefsEditor.commit();
    }

    public static void saveHomeworks(SharedPreferences mPrefs) throws IOException {
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Homework.homeworks);
        prefsEditor.putString("homeworks", json);

        String lastHomeworkId = gson.toJson(Homework.lastHomeworkId);
        prefsEditor.putString("lastHomeworkId", lastHomeworkId);

        prefsEditor.commit();
    }

    public static void saveHomeworksAnswers(SharedPreferences mPrefs) throws IOException {
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(HomeworkAnswer.homeworkAnswers);
        prefsEditor.putString("homeworkAnswers", json);

        String lastHomeworkAnswerId = gson.toJson(HomeworkAnswer.homeworkAnswerId);
        prefsEditor.putString("lastHomeworkAnswerId", lastHomeworkAnswerId);

        prefsEditor.commit();
    }

}
