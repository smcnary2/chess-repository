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
        return endPosition;
    }

    @Override
    public ChessPiece.PieceType getPromotionPiece() {
        return promotionPiece;
    }

    @Override
    public boolean equals(ChessMove move){
        boolean s_equal = this.startPosition.equals(move.getStartPosition());
        boolean e_equal = this.endPosition.equals(move.getEndPosition());
        boolean p_equal = this.promotionPiece == move.getPromotionPiece();

        return s_equal && e_equal && p_equal;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
