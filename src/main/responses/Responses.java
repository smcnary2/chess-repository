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

    public AuthData registerResponse(AuthData userAndToken, int error) {//success response: { "username":"", "authToken":"" }
        return userAndToken;
        //this feels right but, I don't know or do I return an obj.
    }


}
