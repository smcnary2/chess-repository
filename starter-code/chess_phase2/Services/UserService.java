package chess_phase2.Services;
import chess_phase2.Models.Authtoken;
import chess_phase2.Models.User;
import chess_phase2.dataAccess.AuthDAO;
import chess_phase2.dataAccess.DataAccessException;
import chess_phase2.dataAccess.UsersDAO;
import chess_phase2.requests.*;

import java.util.UUID;

public class UserService {//register user, login, logout
    UsersDAO pushRequest;
    AuthDAO newToken;
    public UserService(){
        pushRequest = new UsersDAO();
    }

    /*
                verify authtoken
                go through request obj and make sure they gave all the fields/error trap and send back an error code
                does the user exists, if they do send a bad request
                if not create a new user obj
                insert a new auth token
                return register response
             */
    //register user: username, password, email
    public String registerUser(RegisterRequest newrequest) throws DataAccessException {

        if(newrequest.getUser().isEmpty() || newrequest.getPassword().isEmpty() || newrequest.getEmail().isEmpty()) {//check if request has valid fields
            //400 error bad request
        }
        for (User x:
             pushRequest.findAllUsers()) {
            if (x.getUsername().equals(newrequest.getUser())){
               //403 error already taken
            }
            if(x.getEmail().equals(newrequest.getEmail())){
                //403 error already taken
            }
            //do I check password
        }
        //what is a 500 error
        User newUser = new User(newrequest.getUser(), newrequest.getPassword(), newrequest.getEmail());
        pushRequest.insertUser(newUser);
        Authtoken t = new Authtoken(UUID.randomUUID().toString(), newrequest.getUser());//creates a unique string for authtokin
        newToken.insert(t);//is this where I'm supposed to create the authtoken

        return null;
    }

    //login: username, password
    public String login(LoginRequests newrequest) throws DataAccessException {
        if(newToken.findAuth(newrequest.getUser()) == null){
            //401 error unauthorized
        }
        //500 error
        User newUser = new User(newrequest.getUser(), newrequest.getPassword());
        pushRequest.findUser(newUser);
        //return response
        return null;
    }

    //logout: authorization token??
    public void logout(LogoutRequest r) throws DataAccessException{
        //idk how the response works yet
    }



}
