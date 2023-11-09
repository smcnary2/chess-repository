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
    public AuthData findAuth(String username) throws DataAccessException {
        return token.get(username);//returns Authtoken variable/data

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
        //System.out.print(1);
    }
}
