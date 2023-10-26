package chess_phase2.dataAccess;
import chess_phase2.Models.User;
import chess_phase2.Services.UserService;
import chess_phase2.dataAccess.DataAccessException;

import chess_phase2.requests.LoginRequests;
import chess_phase2.requests.RegisterRequest;

import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
    //save to a list not using database yet
    List<User> databasePlaceholder;

    public UsersDAO(){
        databasePlaceholder = new ArrayList<>();
    }
    // insert user
    public void insertUser(RegisterRequest newrequest)throws DataAccessException {
        //do I error trap for valid user
        databasePlaceholder.add(newrequest.getUser());
    }
    //find user
    public String findUser(LoginRequests newrequest) throws DataAccessException{
        return null;
    }
    //find all users
    public void findAllUsers()throws DataAccessException{

    }
    //remove user
    public void removeUser()throws DataAccessException{

    }
}
