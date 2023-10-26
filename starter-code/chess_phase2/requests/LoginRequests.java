package chess_phase2.requests;

import chess_phase2.Models.User;

public class LoginRequests {
    //make one for each endpoint
    //have no clue??
    public LoginRequests(String u, String pw){//my idea is to create a new user put it as a loginRequest obj then push it to Dao and compare the new user obj to the database user obj
        User newUser = new User(u,pw);
    }
    //phase 3
    //constructor
    // getters &setters
}
