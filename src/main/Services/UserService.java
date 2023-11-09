package Services;

import Models.AuthData;
import Models.User;
import dataAccess.AuthDAO;
import dataAcess.DataAccessException;
import dataAccess.UsersDAO;
import requests.LoginRequests;
import requests.LogoutRequest;
import requests.RegisterRequest;
import handlers.*;

import java.util.UUID;

public class UserService {//register user, login, logout
    UsersDAO pushToUserDAO;
    AuthDAO tokenDAO;

    public UserService() {
        pushToUserDAO = new UsersDAO();
        tokenDAO = new AuthDAO();
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
    public AuthData registerUser(RegisterRequest newrequest) throws DataAccessException {//has to return AuthToken??
        //create a message send back to handler
        if (newrequest.error == 200) {
            User newUser = new User(newrequest.getUser(), newrequest.getPassword(), newrequest.getEmail());
            pushToUserDAO.insertUser(newUser);
            AuthData t = new AuthData(UUID.randomUUID().toString(), newrequest.getUser());//creates a unique string for authtokin
            tokenDAO.insert(t);//is this where I'm supposed to create the authtoken
            return tokenDAO.findAuth(newrequest.getUser());
        }

        return null;
    }

    //login: username, password
    public String login(LoginRequests newrequest) throws DataAccessException {
        if (tokenDAO.findAuth(newrequest.getUser()) == null) {
            //401 error unauthorized
        }
        //500 error
        User newUser = new User(newrequest.getUser(), newrequest.getPassword());
        pushToUserDAO.findUser(newUser);
        //return response
        return null;
    }

    //logout: authorization token??
    public void logout(LogoutRequest r) throws DataAccessException {
        //idk how the response works yet
    }


}
