package dataAccess;

import Models.User;
import dataAcess.DataAccessException;

import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
    //save to a list not using database yet
    List<User> databasePlaceholder;

    public UsersDAO() {
        databasePlaceholder = new ArrayList<>();
    }

    public void insertUser(User newUser) throws DataAccessException {// insert user
        databasePlaceholder.add(newUser);
    }

    //find user
    public User findUser(User newUser) throws DataAccessException {
        for (User x :
                databasePlaceholder) {
            if (x.getUsername().equals(newUser.getUsername())) {
                if (x.getPassword().equals(newUser.getPassword())) {
                    return x;//what am I supposed to return here
                }
            }
        }
        return null;
    }

    //find all users
    public List<User> findAllUsers() throws DataAccessException {
        return databasePlaceholder;//is this safe
    }

    public void clearAllUsers() {
        for (User i :
                databasePlaceholder) {
            databasePlaceholder.remove(i);
        }

    }

    //remove user
    public void removeUser() throws DataAccessException {//is that right
        /*
        User user = findUser();
        if(user != null){
            databasePlaceholder.remove(user);
        }

         */

    }
}
