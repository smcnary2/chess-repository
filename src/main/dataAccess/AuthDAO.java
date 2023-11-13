package dataAccess;

import Models.AuthData;
import dataAcess.DataAccessException;

import java.util.HashMap;
import java.util.Map;

//I think it's done
public class AuthDAO {
    //give/remove authorization
    public static Map<String, AuthData> token = new HashMap<>();

    //find authorization
    public AuthData findAuth(String authtoken) throws DataAccessException {
        return token.get(authtoken);//returns Authtoken variable/data
    }


    public void delete(String user) {
        token.remove(user);
        // remove key or replace the authorization?
    }

    public void clear() {
        //deletes all instances
        token.clear();

    }

    //delete, insert, clear
    public void insert(AuthData t) {
        //inserts the reandom string and username into map
        token.put(t.getAuthToken(), t);
        System.out.print(1);
    }

    public AuthData setAuthtoken(AuthData auth, String username) {

        return token.replace(username, auth);
    }
}
