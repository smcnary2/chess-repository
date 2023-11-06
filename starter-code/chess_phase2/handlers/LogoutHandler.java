package chess_phase2.handlers;

import chess_phase2.Services.UserService;
import chess_phase2.requests.LogoutRequest;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class LogoutHandler  {//implements Route
    private Gson gson = new Gson();
    @Override
    public Object handle(Request request, Response response) throws Exception {
        LogoutRequest r = gson.fromJson(request.body(), LogoutRequest.class);
        UserService userService = new UserService();
        userService.logout(r);// create registerResponse and assign to value


        response.status();// you pass those error codes into here
        //then send to serivce
        gson.toJson(); //put what service returns in here
        return null;
    }
}
