package chess_phase2.handlers;

import chess_phase2.Services.UserService;
import chess_phase2.requests.RegisterRequest;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

/*
{
“username” : “username
}
 */

public class RegisterHandler implements Route {
    private Gson gson = new Gson();
    @Override
    public Object handle(Request request, Response response) throws Exception {
        RegisterRequest r = gson.fromJson(request.body(), RegisterRequest.class);
        UserService userService = new UserService();
        userService.registerUser(r);// create registerResponse and assign to value

        //then send to serivce
        response.status();//what is this for??
        return gson.toJson();//put what service returns in here
    }
}
