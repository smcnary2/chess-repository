package chess_phase2.Models;

public class Authtoken {
    String authToken;
    String username;
    Authtoken(String token, String name){
        authToken = token;
        username = name;

    }

    public String getUsername() {
        return username;
    }

    public String getAuthToken() {
        return authToken;
    }
}
