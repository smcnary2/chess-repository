package chess_phase2.requests;
import chess_phase2.Models.User;
import chess_phase2.dataAccess.AuthDAO;

public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    public RegisterRequest(String n, String pw, String e){
       username = n;
       password = pw;
       email = e;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUser() {
        return username;
    }
}
