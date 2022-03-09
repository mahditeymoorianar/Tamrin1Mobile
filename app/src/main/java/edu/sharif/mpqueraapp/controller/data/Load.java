package edu.sharif.mpqueraapp.controller.data;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.LinkedList;

import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.model.Student;

public class Load {

    public static void loadUsers(SharedPreferences mPrefs){

        Type listType = new TypeToken<LinkedList<Student>>(){}.getType();
        Gson gson = new Gson();
        String json = mPrefs.getString("students", "");
        Student.students = gson.fromJson(json, listType);
        listType = new TypeToken<LinkedList<Professor>>(){}.getType();
        gson = new Gson();
        json = mPrefs.getString("professors", "");
        Professor.professors = gson.fromJson(json, listType);
        if (Professor.professors == null){
            Professor.professors = new LinkedList<>();
        }
        if (Student.students == null){
            Student.students = new LinkedList<>();
        }
    }

}
