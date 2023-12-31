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
            return tokenDAO.findAuth(t.getAuthToken());
        }

        return null;
    }

    //login: username, password
    public AuthData login(LoginRequests newrequest) throws DataAccessException {

        if (tokenDAO.findAuth(newrequest.getUser()) != null) {
            newrequest.error = 401; //401 error unauthorized
            return new AuthData("already logged in", "unauthorized");
        }

        User newUser = new User(newrequest.getUser(), newrequest.getPassword());

        if (pushToUserDAO.findUser(newUser) == null) {
            newrequest.error = 500;
            return new AuthData("cannot find User", "invalid field");
        }
        newrequest.error = 200;
        AuthData t = new AuthData(UUID.randomUUID().toString(), newrequest.getUser());
        tokenDAO.insert(t);
        //return response
        return tokenDAO.findAuth(newrequest.getUser());
    }

    //logout: authorization token??
    public void logout(LogoutRequest r) throws DataAccessException {
        if (tokenDAO.findAuth(r.getAuthtoken()) == null) {
            r.error = 401;//error 401 unauthorized
        } else {
            r.error = 200;
            tokenDAO.delete(r.getAuthtoken());
        }

    }


}
