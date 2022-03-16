package edu.sharif.mpqueraapp.controller.authentication;

import static edu.sharif.mpqueraapp.controller.authentication.CheckPassword.checkPass;
import static edu.sharif.mpqueraapp.controller.authentication.CheckUsername.checkUsernameProfessors;
import static edu.sharif.mpqueraapp.controller.authentication.CheckUsername.checkUsernameStudents;
import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.model.Student;


public class AuthController {


    public static String loginCheck(String username, String password, String sOrP){
        if (sOrP.equals("s")){
            if (checkPass(username, password, Student.students)){
                Student.activeStudent = Student.getStudent(username);
                return "s";
            }
            else{
                if (!checkUsernameStudents(username)){
                    return "This Username Does Not Exist!";
                }
            }
        }
        else{
            if (checkPass(username, password, Professor.professors)){
                Professor.activeProf = Professor.getProf(username);
                return "p";
            }
            else{
                if (!checkUsernameProfessors(username)){
                    return "This Username Does Not Exist!";

                }
            }
        }
        return "Password and Username Does Not Match!";
    }

    public static String SignUpCheck(String username, String password, String confirmPassword,
                                     String name, String lastname, String specific, int type){
        if (checkUsernameStudents(username) || checkUsernameProfessors(username)){
            return "This Username Already Exists!";
        }
        else if (password.equals(confirmPassword)){
            if (type == 0){
                Student.activeStudent = new Student(username, password, name, lastname, specific);
            }
            else{
                Professor.activeProf = new Professor(username, password, name, lastname, specific);
            }
            return "";
        }

        return "Password not Confirmed!";
    }

}
