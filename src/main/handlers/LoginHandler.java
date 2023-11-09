package handlers;

import Services.UserService;
import dataAccess.AuthDAO;
import requests.LoginRequests;
import com.google.gson.Gson;
import responses.Responses;
import spark.Request;
import spark.Response;
import spark.Route;

public class LoginHandler implements Route {
    private Gson gson = new Gson();
    public Responses registerResponse;

    @Override
    public Object handle(Request request, Response response) throws Exception {
        LoginRequests r = gson.fromJson(request.body(), LoginRequests.class);
        UserService userService = new UserService();
        userService.login(r);// create registerResponse and assign to value

        registerResponse = new Responses();
        response.status(r.error);// you pass those error codes into here
        //then send to serivce
        // gson.toJson(); //put what service returns in here
        return gson.toJson(registerResponse.registerResponse(userService.login(r)));
    }
}
