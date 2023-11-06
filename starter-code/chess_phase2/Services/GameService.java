package chess_phase2.Services;

import chess.ChessGame;
import chess_phase2.dataAccess.AuthDAO;
import chess_phase2.dataAccess.DataAccessException;
import chess_phase2.dataAccess.GameDAO;
import chess_phase2.requests.ListGamesRequest;
import chess_phase2.requests.NewGameRequest;

public class GameService {
    public GameDAO pushRequest;
    //new game, join game, list games
    public AuthDAO newToken;
    //listgames
    public String listGames(ListGamesRequest newrequest) throws DataAccessException {
        //can't add auth check until you fix listGamesReq
        pushRequest.findAllGames();
        return null;
    }

    //new Game: game name
    public void newGame(NewGameRequest request) throws DataAccessException{
        pushRequest.insertGame(request);
        //UUID.randomUUID().hashCode(); to generate game id
        //insert game??
    }

    //join game: player color, player name
    public void joinGame(ChessGame.TeamColor color, String name){
        //idk what to do for this one
    }
}
