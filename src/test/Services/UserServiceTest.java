package Services;

import Models.AuthData;
import Models.User;
import dataAccess.AuthDAO;
import dataAccess.UsersDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import requests.LoginRequests;
import requests.LogoutRequest;
import requests.RegisterRequest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void registerUser() {
        var userService = new UserService();

        var req = new RegisterRequest("joe", "pw", "joe@joe.com");
        var res = Assertions.assertDoesNotThrow(() -> userService.registerUser(req));

        Assertions.assertEquals("joe", res.getUsername());
        //dont have to check for empty strings already checks in TA tests
    }

    @Test
// won't pass unless register passes
    void loginUser() {
        var userService = new UserService();


        var createUser = new RegisterRequest("joe", "pw", "joe@joe.com");
        Assertions.assertDoesNotThrow(() -> userService.registerUser(createUser));
        var req = new LoginRequests("joe", "pw");
        var res = Assertions.assertDoesNotThrow(() -> userService.login(req));

        Assertions.assertEquals("joe", res.getUsername());
    }

    @Test
    void logoutUser() {//won't work unless register works
        var userService = new UserService();


        var createUser = new RegisterRequest("joe", "pw", "joe@joe.com");
        var token = Assertions.assertDoesNotThrow(() -> userService.registerUser(createUser));
        var req = new LogoutRequest(token.getAuthToken());
        Assertions.assertDoesNotThrow(() -> userService.logout(req));
        //not sure how to make this work
    }

    //you need to make a clear test still


}