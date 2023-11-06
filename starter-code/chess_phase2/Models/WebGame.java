package chess_phase2.Models;

import chess.*;

public class WebGame {
    int gameID;
    String whiteUsername;
    String blackUsername;
    String gameName;
    ChessGame game;
    public WebGame(int id, boolean color, String gn, User user){
        game = new Game();// did I do that right
        gameID = id;//random number
        gameName = gn;
        //players join game dont assign colors until DAO

    }

    public int getGameID() {
        return gameID;
    }
}
