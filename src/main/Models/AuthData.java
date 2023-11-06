package Models;

public class AuthData {
    String authToken;
    String username;

    public AuthData(String token, String name) {
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
