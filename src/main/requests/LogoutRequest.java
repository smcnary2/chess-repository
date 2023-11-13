package requests;

public class LogoutRequest {
    public int error;
    public String authtoken;

    public LogoutRequest(String authtoken) {
        this.authtoken = authtoken;
        error = 200;
    }

    public String getAuthtoken() {
        return authtoken;
    }
}
