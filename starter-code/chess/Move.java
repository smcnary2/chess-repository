package chess;

import java.util.Objects;

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
    public String toString() {
        return "Move{" +
                "startPosition=" + startPosition +
                ", endPosition=" + endPosition +
                ", promotionPiece=" + promotionPiece +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Move move)) return false;
        return Objects.equals(startPosition, move.startPosition) && Objects.equals(endPosition, move.endPosition) && promotionPiece == move.promotionPiece;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPosition, endPosition);
    }
}
