package Services;

import Models.AuthData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import requests.RegisterRequest;

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
    void loginUser() {

    }


}