package chess;

import java.util.ArrayList;
import java.util.Collection;

public class Game implements ChessGame{
    public ChessBoard board;
    public TeamColor team;

    public Game(){

    }
    @Override
    public TeamColor getTeamTurn() {
        return null;
    }

    @Override
    public void setTeamTurn(TeamColor team) {
        this.team = team;
    }

    @Override
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        ChessPiece piece = this.board.getPiece(startPosition);
        return piece.pieceMoves(this.board, startPosition);
    }

    @Override
    public void makeMove(ChessMove move) throws InvalidMoveException {
//        ChessPiece piece = board.getPiece(move.getStartPosition());
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
