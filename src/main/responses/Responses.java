package responses;

import Models.AuthData;
import dataAccess.AuthDAO;

public class Responses {
    private String message;
    private String authToken;
    private String username;


    //constructor
    public Responses() {
    }

    public String registerResponse(AuthData userAndToken) {//success response: { "username":"", "authToken":"" }
        authToken = userAndToken.getAuthToken();
        username = userAndToken.getUsername();
        return "username: " + username + ", authToken: " + authToken;
        //this feels right but, I don't know or do I return an obj.
    }


}
