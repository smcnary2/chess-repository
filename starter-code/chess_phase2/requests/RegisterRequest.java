package chess_phase2.requests;
import chess_phase2.Models.User;
public class RegisterRequest {
    User newUser;
    public RegisterRequest(String n, String pw, String e){
        newUser = new User(n, pw, e);
    }
    public User getUser(){
        return newUser;
    }

}
