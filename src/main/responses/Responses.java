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

    public String returnMessage(int error) {
        if (error == 200) {
            return "request approved";
        }
        return "request failed";
    }

    public AuthData registerResponse(AuthData userAndToken) {//success response: { "username":"", "authToken":"" }
        System.out.println(userAndToken.getAuthToken());
        return userAndToken;
        //this feels right but, I don't know or do I return an obj.
    }

    public AuthData loginResponse(AuthData userAndToken) {

        System.out.println(userAndToken.getAuthToken());
        return userAndToken;
    }


}
