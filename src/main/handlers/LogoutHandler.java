package handlers;

import Services.UserService;
import requests.LogoutRequest;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class LogoutHandler  implements Route {
    final private Gson gson = new Gson();
    @Override
    public Object handle(Request request, Response response) throws Exception {
        LogoutRequest r = gson.fromJson(request.body(), LogoutRequest.class);
        UserService userService = new UserService();
        userService.logout(r);// create registerResponse and assign to value


        response.status();// you pass those error codes into here
        //then send to serivce
        return "{}";
    }
}
