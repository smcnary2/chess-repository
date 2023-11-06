package dataAcess;

/**
 * Indicates there was an error connecting to the database
 */
//do not modify
public class DataAccessException extends Exception{
    public DataAccessException(String message) {
        super(message);
    }
}
