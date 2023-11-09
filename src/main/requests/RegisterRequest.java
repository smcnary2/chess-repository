package requests;

public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    public int error;

    public RegisterRequest(String n, String pw, String e) {
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
