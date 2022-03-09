package edu.sharif.mpqueraapp.controller.authentication;


import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.model.User;


public class CheckUsername {

    public static boolean checkUsernameStudents(String username){
        for (Student user : Student.students) {
            if (user.username.equals(username)) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkUsernameProfessors(String username){
        for (Professor user : Professor.professors) {
            if (user.username.equals(username)) {
                return true;
            }
        }
        return false;
    }

}
