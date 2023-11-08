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

    @Override
    public Object handle(Request request, Response response) throws Exception {
        int error;
        RegisterRequest r = gson.fromJson(request.body(), RegisterRequest.class);
        UserService userService = new UserService();
        if (r.getUser().isEmpty() || r.getPassword().isEmpty() || r.getEmail().isEmpty()) {//check if request has valid fields
            response.status(400);//400 error bad request
        }
        for (User x :
                placeholder.findAllUsers()) {
            if (x.getUsername().equals(r.getUser())) {
                response.status(403);//403 error already taken

            }
            if (x.getEmail().equals(r.getEmail())) {
                response.status(403);//403 error already taken
            }
        }
        registerResponse = new Responses();
        // create registerResponse and assign to value
        //then send to serivce
        response.status(200);//what is this for??
        //return gson.toJson();//put what service returns in here
        //return message if error code
        return registerResponse.registerResponse(userService.registerUser(r));
    }
}
