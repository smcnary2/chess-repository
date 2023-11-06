package requests;

import Models.User;
import Models.WebGame;

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
