package chess_phase2.handlers;

import chess_phase2.Services.GameService;
import chess_phase2.requests.NewGameRequest;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class NewGameHandler implements Route {
    private Gson gson = new Gson();
    @Override
    public Object handle(Request request, Response response) throws Exception {
        NewGameRequest r = gson.fromJson(request.body(), NewGameRequest.class);//why no happy
        GameService userService = new GameService();
        userService.newGame(r);// create registerResponse and assign to value


        response.status();// you pass those error codes into here
        //then send to serivce
        gson.toJson(); //put what service returns in here what does that mean and how does that look?!?!
        return null;
    }
}
