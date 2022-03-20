package edu.sharif.mpqueraapp.controller.mainPage;

import static edu.sharif.mpqueraapp.controller.authentication.CheckUsername.checkUsernameProfessors;

import edu.sharif.mpqueraapp.model.Course;
import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.model.User;

public class CourseController {


    public static String createNewCourseCheck(String profUsername, String courseName){

        if (!checkUsernameProfessors(profUsername)) {

            return "This Username Does Not Exist!";
        }

        if (Professor.getProf(profUsername).hasCourse(courseName)) {
            return "You have a course with this name already!";
        }

        Course.activeCourse = Professor.getProf(profUsername).addNewCourse(courseName);
        System.out.println("new added course : " + Course.activeCourse.toString());

        return "success";
    }
}
