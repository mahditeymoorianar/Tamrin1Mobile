package edu.sharif.mpqueraapp.controller.authentication;

import static edu.sharif.mpqueraapp.controller.authentication.CheckPassword.checkPass;
import static edu.sharif.mpqueraapp.controller.authentication.CheckUsername.checkUsernameProfessors;
import static edu.sharif.mpqueraapp.controller.authentication.CheckUsername.checkUsernameStudents;

import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.model.User;

public class AuthController {


    public static String loginCheck(String username, String password, String sOrP){
        if (sOrP.equals("s")){
            if (checkPass(username, password, Student.students)){
                Student.activeStudent = Student.getStudent(User.usernameToId(username));
                return "s";
            }
            else{
                if (!checkUsernameStudents(username)){
                    return "This Username Does Not Exist!";

                }
            }
            return "Password and Username Does Not Match!";
        }
        else{
            if (checkPass(username, password, Professor.professors)){
                Professor.activeProf = Professor.getProf(User.usernameToId(username));
                return "p";
            }
            else{
                if (!checkUsernameProfessors(username)){
                    return "This Username Does Not Exist!";

                }
            }
            return "Password and Username Does Not Match!";
        }
    }


    public static String SignInCheck(String username, String password, String confirmPassword,
                                     String name, String lastname, String specific, int type){
        if (checkUsernameStudents(username) || checkUsernameProfessors(username)){
            return "This Username Already Exists!";
        }
        else if (password.equals(confirmPassword)){
            switch (type){
                case 0 :
                    Student.activeStudent = new Student(username, password, name, lastname, specific);

                case 1:
                    Professor.activeProf = new Professor(username, password, name, lastname, specific);
            }
            return "";
        }

        return "Password not Confirmed!";
    }

}
