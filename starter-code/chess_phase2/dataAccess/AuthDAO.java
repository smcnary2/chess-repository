package chess_phase2.dataAccess;
import chess_phase2.Models.Authtoken;
import chess_phase2.Models.User;
import chess_phase2.dataAccess.DataAccessException;

import java.util.HashMap;
import java.util.Map;

//I think it's done
public class AuthDAO {
    //give/remove authorization
    public static Map<String, Authtoken> token = new HashMap<>();

    //find authorization
    public String findAuth(String username)throws DataAccessException{
        for (int i = 0; i < token.size(); i++) {
            if(token.containsKey(username)){
                return username;
            }
        }
        return null; //returns Authtoken variable/data
    }

    public void delete(){
        if(token.containsKey()){
            token.remove();
        }
    }

    public void clear(){
        //deletes all instances
        token.clear();

    }

    //delete, insert, clear
    public void insert(Authtoken t, String username){
        //inserts the reandom string and username into map
        token.put(username, t);
    }
}
