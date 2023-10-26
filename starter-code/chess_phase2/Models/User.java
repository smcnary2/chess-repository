package chess_phase2.Models;

public class User {
    String username;
    String password;
    String email;
    public User(String n, String pw, String e){
        username = n;
        password = pw;
        email = e;
    }
    public User(String n, String pw){
        username = n;
        password = pw;
    }
}
