package chess_phase2.dataAccess;
import chess.Game;
import chess_phase2.Models.WebGame;
import chess_phase2.dataAccess.DataAccessException;
import chess_phase2.requests.NewGameRequest;

import java.util.ArrayList;
import java.util.List;

public class GameDAO {
    List<WebGame> listOfGames;
    public GameDao(){
        listOfGames = new ArrayList<>();
    }
    public void insertGame(NewGameRequest r)throws DataAccessException{
        //add game to list idk how that works
        listOfGames.add(r.getGame());
    }
    //find
    public Game findGame()throws DataAccessException{// am I supposed to haev this
        for (WebGame x:
             listOfGames) {
            if (x.getGameID() == )
        }
        return null;
    }
    //findAll
    public List<WebGame> findAllGames()throws DataAccessException{
        return listOfGames;// am I supposed to return this formatted
    }

    //I have no clue what I'm supposed to do with the rest of the methods

    //claimSpot
    public boolean claimColor()throws DataAccessException{
        return false;
    }
    //updateGame
    public void updateGame()throws DataAccessException{

    }
    //Remove
    public void removeGame()throws DataAccessException{
        if(findGame() != null){
            listOfGames.remove();
        }

    }
    //clear
    public void clearGame()throws DataAccessException{

    }
}
