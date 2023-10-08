package chess;
import chess.ChessGame.TeamColor;
import java.util.Collection;
public class Piece implements ChessPiece {


    TeamColor newteamcolor;
    PieceType promotionPiece;


    PieceType newpiece;
   // I might change this to an array.length() = 6 or just not a string
    //enum for type and color
    public Piece(TeamColor color,PieceType i){
         newteamcolor = color;//set team color
         newpiece = i;//set piece type rkbkqp
    }

    public PieceType getPromotionPiece(){
        return this.promotionPiece;
    }

    public void setPromotionPiece(Piece.PieceType promotionPiece){
        this.promotionPiece = promotionPiece;
    }
    @Override
    public TeamColor getTeamColor() {//ChessGame.TeamColor
        return newteamcolor;
    }

    @Override
    public PieceType getPieceType() {//6 types of pieces
        return newpiece;
    }

//override in classes for pieces
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        //give it a positon and give it a chess position and it will give a collection of possible moves

        return null;
    }
}
