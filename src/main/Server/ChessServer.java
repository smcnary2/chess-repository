package Server;

import handlers.*;
import spark.*;

import java.util.*;


public class ChessServer {
    private ArrayList<String> names = new ArrayList<>();//what is this for

    public static void main(String[] args) {
        new ChessServer().run();
    }

    private void run() {
        // Specify the port you want the server to listen on
        Spark.port(8080);

        // Register a directory for hosting static files
        Spark.externalStaticFileLocation("web");

        // Register handlers for each endpoint using the method reference syntax
        /*
        Spark.post("/name/:name", this::addName);
        Spark.get("/name", this::listNames);
        Spark.delete("/name/:name", this::deleteName);


         */
        Spark.post("/user", (request, response) -> new RegisterHandler().handle(request, response));//do for each end point
        //clear Request
        //Spark.delete("/db",(request, response) -> new ClearHandler());//not complete
        //join game
        //Spark.post("/game", (request, response) -> new JoinGameHandler());
        //list games: get
        //Spark.get("/game", (request, response) -> new ListGamesHandler().handle(request,response));
        //login:get?
        //Spark.get("/session", ((request, response) -> new LoginHandler().handle(request,response)));
        //new game
        //Spark.post("/game", ((request, response) -> new NewGameHandler().handle(request,response)));
        //logout:delete
        //Spark.delete("/session", ((request, response) -> new LogoutHandler().handle(request,response)));

        Spark.init();
    }


}