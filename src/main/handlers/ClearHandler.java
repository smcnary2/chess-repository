package handlers;

import Services.AuthService;
import com.google.gson.Gson;
import dataAccess.UsersDAO;
import requests.ClearRequest;
import responses.Responses;
import spark.Request;
import spark.Response;
import spark.Route;


public class ClearHandler implements Route {
    private Gson gson = new Gson();
    private Responses clearResponse;
    private UsersDAO data;

    public ClearHandler() {
        data = new UsersDAO();
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        ClearRequest r = gson.fromJson(request.body(), ClearRequest.class);
        r = new ClearRequest();
        r.error = 200;
        AuthService authService = new AuthService();

        authService.clear(r);
        if (!(data.databaseIsEmpty())) {
            r.error = 500;
        }
        // create registerResponse and assign to value
        //then send to serivce
        response.status(r.error);
        //return gson.toJson();//put what service returns in here
        clearResponse = new Responses();

        return gson.toJson(clearResponse.returnMessage(r.error));
    }
}
