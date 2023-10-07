package chess;

import java.util.Collection;

public class Piece implements ChessPiece{


    TeamColor newteamcolor;

    enum TeamColor {
        WHITE,
        BLACK
    }
     public enum PieceTypes {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }
    PieceTypes newpiece;
   // I might change this to an array.length() = 6 or just not a string
    //enum for type and color
    public Piece(TeamColor color,PieceTypes i){
         newteamcolor = color;//set team color
         newpiece = i;//set piece type rkbkqp
    }
    @Override
    public TeamColor getTeamColor() {//ChessGame.TeamColor
        return newteamcolor;
    }

    @Override
    public PieceTypes getPieceType() {//6 types of pieces //changed it to return piece types instead of piece type because of error
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
