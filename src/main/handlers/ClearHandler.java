package handlers;

import Services.AuthService;
import com.google.gson.Gson;
import requests.ClearRequest;
import spark.Request;
import spark.Response;
import spark.Route;

public class ClearHandler implements Route {
    private Gson gson = new Gson();


    public Object handle(Request request, Response response) throws Exception {
        ClearRequest r = gson.fromJson(request.body(), ClearRequest.class);

        AuthService authService = new AuthService();

        authService.clear();
        // create registerResponse and assign to value
        //then send to serivce
        response.status(200);
        //return gson.toJson();//put what service returns in here
        return null;
    }
}
