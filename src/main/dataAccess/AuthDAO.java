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
    public String findAuth(String username) throws DataAccessException {
        for (int i = 0; i < token.size(); i++) {
            if (token.containsKey(username)) {
                return username;
            }
        }
        return null; //returns Authtoken variable/data
    }

    public void delete() {
//        if(token.containsKey()){
//            token.remove();
//        }
    }

    public void clear() {
        //deletes all instances
        token.clear();

    }

    //delete, insert, clear
    public void insert(AuthData t) {
        //inserts the reandom string and username into map
        token.put(t.getUsername(), t);
    }
}
