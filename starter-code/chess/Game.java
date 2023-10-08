package chess;

import java.util.ArrayList;
import java.util.Collection;

public class Game implements ChessGame{
    public ChessBoard board;
    public TeamColor team;
    public Game(){
        this.board = board;

    }
    @Override
    public TeamColor getTeamTurn() {
        return null;
    }

    @Override
    public void setTeamTurn(TeamColor team)  {
        this.team = team;
    }

    @Override
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        ChessPiece piece = board.getPiece(startPosition);
        int row = startPosition.getRow();
        int column = startPosition.getColumn();
        TeamColor movePieceColor = piece.getTeamColor();

        ChessPiece.PieceType pieceType;
        if (piece.getPromotionPiece() == null){
            pieceType = piece.getPieceType();
        }
        else{
            pieceType = piece.getPromotionPiece();
        }
        switch (pieceType){
            case BISHOP:
                break;
            case KING:
                for (int r = ((row > 0) ? row-1 : 0); r <= ((row < 7) ? row+1 : 7); r++){ // all one space moves on board
                    for (int c = ((column > 0) ? column-1 : 0); c <= ((column < 7) ? column+1 : 7); c++) { // all one space moves on board
                        if (r != row || c != column){ // not the place it is in
                            ChessPiece occupant = board.getPiece(new Position(r,c));
                            if(occupant == null)
                                moves.add(new Move(startPosition,new Position(r,c), piece.getPromotionPiece()));
                            else{
                                if (movePieceColor != occupant.getTeamColor()){
                                    // capture piece
                                    moves.add(new Move(startPosition,new Position(r,c), piece.getPromotionPiece()));
                                }
                            }
                        }
                    }
                }
                return moves;
            case PAWN:
                break;
            case ROOK:
                break;
            case QUEEN:
                break;
            case KNIGHT:
                break;
        }
        return null;
    }

    @Override
    public void makeMove(ChessMove move) throws InvalidMoveException {
        Collection<ChessMove> moves = this.validMoves(move.getStartPosition());
        for (ChessMove m: moves){
            if (m.getEndPosition().equals(m.getEndPosition())){
                this.board.movePiece(move);
                break;
            }
        }
    }

    @Override
    public boolean isInCheck(TeamColor teamColor) {
        return false;
    }

    @Override
    public boolean isInCheckmate(TeamColor teamColor) {
        return false;
    }

    @Override
    public boolean isInStalemate(TeamColor teamColor) {
        return false;
    }

    @Override
    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    @Override
    public ChessBoard getBoard() {

        return this.board;
    }
}
