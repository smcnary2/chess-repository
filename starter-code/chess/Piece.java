package chess;

import java.util.Collection;
import java.util.*;

public class Piece implements ChessPiece{

    ChessPiece.PieceType newpiece;
    ChessGame.TeamColor newteamcolor;


   // I might change this to an array.length() = 6 or just not a string
    //enum for type and color
    public Piece(ChessGame.TeamColor color,ChessPiece.PieceType i){
         newteamcolor = color;//set team color
         newpiece = i;//set piece type rkbkqp
    }
    @Override
    public ChessGame.TeamColor getTeamColor() {
        return newteamcolor;
    }

    @Override
    public ChessPiece.PieceType getPieceType() {//6 types of pieces
        return newpiece;
    }
    //override in classes for pieces
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        // a list of all moves made? ask TA dont understand instructions
        //give it a positon and give it a chess position and it will give a collection of possible moves
        return null;
    }
}
