package Services;

import dataAccess.AuthDAO;
import dataAccess.GameDAO;
import dataAccess.UsersDAO;
import dataAcess.DataAccessException;

public class AuthService {
    public AuthDAO Authclear;
    public GameDAO Gameclear;
    public UsersDAO Userclear;

    public AuthService() {
        Authclear = new AuthDAO();
        Gameclear = new GameDAO();
        Userclear = new UsersDAO();
    }

    public void clear() throws DataAccessException {//i really dont know what this does
        Authclear.clear();
        Gameclear.clearGame();
        Userclear.clearAllUsers();
    }
}
