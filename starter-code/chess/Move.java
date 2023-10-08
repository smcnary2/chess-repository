package chess;

public class Move implements ChessMove {
    public ChessPosition startPosition;
    public ChessPosition endPosition;
    public ChessPiece.PieceType promotionPiece;
    public Move(ChessPosition startPosition, ChessPosition endPosition, ChessPiece.PieceType promotionPiece){
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.promotionPiece = promotionPiece;
    }
    @Override
    public ChessPosition getStartPosition() {


        return startPosition;
    }

    @Override
    public ChessPosition getEndPosition() {
        //row & column

        return endPosition;
    }

    @Override
    public ChessPiece.PieceType getPromotionPiece() {
        return null;
    }
}
