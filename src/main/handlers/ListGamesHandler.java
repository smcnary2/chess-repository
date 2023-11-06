package handlers;

import Services.GameService;
import requests.ListGamesRequest;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class ListGamesHandler implements Route {
    final private Gson gson = new Gson();

    @Override
    public Object handle(Request request, Response response) throws Exception {
        ListGamesRequest r = gson.fromJson(request.body(), ListGamesRequest.class);
        GameService gameService = new GameService();
        gameService.listGames(r);// create registerResponse and assign to value


        response.status();// you pass those error codes into here
        //then send to serivce
        //    gson.toJson(); //put what service returns in here
        return null;
    }
}
