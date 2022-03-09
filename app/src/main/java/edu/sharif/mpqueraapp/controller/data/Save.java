package edu.sharif.mpqueraapp.controller.data;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;

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
        prefsEditor.commit();
    }
    public static void saveProfessors(SharedPreferences mPrefs) throws IOException {
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Professor.professors);
        prefsEditor.putString("professors", json);
        prefsEditor.commit();
    }

}
