package chess_phase2.Services;
import chess_phase2.dataAccess.DataAccessException;
import chess_phase2.dataAccess.UsersDAO;
import chess_phase2.requests.*;
public class UserService {//register user, login, logout
    UsersDAO pushRequest;
    public UserService(){
        pushRequest = new UsersDAO();
    }


    //register user: username, password, email
    public String registerUser(RegisterRequest newrequest) throws DataAccessException {
        pushRequest.insertUser(newrequest);
        //return result
        return null;
    }

    //login: username, password
    public String login(LoginRequests request) throws DataAccessException {
        pushRequest.findUser(request);
        //return result
        return null;
    }

    //logout: authorization token??
    public void logout(LogoutRequest r) throws DataAccessException{

    }
}
