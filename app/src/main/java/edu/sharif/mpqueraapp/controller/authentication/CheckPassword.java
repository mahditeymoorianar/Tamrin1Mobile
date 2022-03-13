package edu.sharif.mpqueraapp.controller.authentication;



import java.util.LinkedList;
import edu.sharif.mpqueraapp.model.User;

public class CheckPassword {

    public static  <T extends User> boolean checkPass(String username, String password, LinkedList<T> users){

        for (T i: users) {
            if (i.password.equals(password) && i.username.equals(username)){
                return true;
            }
        }
        return false;
    }

}
