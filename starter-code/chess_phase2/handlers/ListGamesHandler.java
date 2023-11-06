package chess_phase2.handlers;

import chess_phase2.Services.GameService;
import chess_phase2.requests.ListGamesRequest;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

public class ListGamesHandler {
    private Gson gson = new Gson();
    @Override
    public Object handle(Request request, Response response) throws Exception {
        ListGamesRequest r = gson.fromJson(request.body(), ListGamesRequest.class);
        GameService gameService = new GameService();
        gameService.listGames(r);// create registerResponse and assign to value


        response.status();// you pass those error codes into here
        //then send to serivce
        gson.toJson(); //put what service returns in here
        return null;
    }
}
