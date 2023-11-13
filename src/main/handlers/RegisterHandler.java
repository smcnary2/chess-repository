package handlers;

import Models.User;
import Services.UserService;
import dataAccess.UsersDAO;
import requests.RegisterRequest;
import com.google.gson.Gson;
import responses.Responses;
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
    public Responses registerResponse;
    public UsersDAO placeholder;// i dont like this but I dont know how to do it different

    public RegisterHandler() {
        placeholder = new UsersDAO();
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        RegisterRequest r = gson.fromJson(request.body(), RegisterRequest.class);
        r.error = 200;
        UserService userService = new UserService();
        if (r.getUser().isEmpty() || r.getPassword().isEmpty() || r.getEmail().isEmpty()) {//check if request has valid fields
            // 400 error bad request
            r.error = 400;
        }

        for (User x :
                placeholder.findAllUsers()) {
            if (x.getUsername().equals(r.getUser())) {
                //403 error already taken
                r.error = 403;
            }
            if (x.getEmail().equals(r.getEmail())) {
                //403 error already taken
                r.error = 403;
            }
        }

        registerResponse = new Responses();
        // create registerResponse and assign to value
        //then send to serivce
        response.status(r.error);
        //return gson.toJson();//put what service returns in here
        //return message if error code

        return gson.toJson(registerResponse.registerResponse(userService.registerUser(r)));
    }
}
