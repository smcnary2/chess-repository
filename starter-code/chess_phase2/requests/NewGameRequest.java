package chess_phase2.requests;

import chess_phase2.Models.User;
import chess_phase2.Models.WebGame;

public class NewGameRequest {
    //unsure what to do here
    public WebGame newGame;// dont understand specs and I think I'm doing this wrong
    public String gameName;
    NewGameRequest(int id, boolean color, String gn, User user){

    }

    public WebGame getGame(){
        return newGame;
    }
}
