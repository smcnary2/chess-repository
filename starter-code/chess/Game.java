package chess;

import java.util.ArrayList;
import java.util.Collection;

public class Game implements ChessGame{
    public ChessBoard board;
    public TeamColor team;

    public Collection<ChessMove> moves;
    public ChessMove lastMove;
    public Position kingForCheck;
    public boolean inCheck;
    public Game(){
        inCheck = false;
    }
    @Override
    public TeamColor getTeamTurn() {//done
        return team;
    }

    @Override
    public void setTeamTurn(TeamColor team)  {//done
        this.team = team;
    }

    @Override
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        ChessPiece piece = this.board.getPiece(startPosition);
        if(inCheck){

        }

        return piece.pieceMoves(this.board, startPosition);
    }

    @Override
    public void makeMove(ChessMove move) throws InvalidMoveException {
         moves = this.validMoves(move.getStartPosition());
        for (ChessMove m: moves){
            if (m.getEndPosition().equals(move.getEndPosition())){
                this.board.movePiece(move);
                lastMove = move;
                //change turn
                if(this.isInCheck(team)){
                    //ischeck = true
                    if(this.isInCheckmate(team)){
                        //game end??
                    }
                } else if (this.isInStalemate(team)) {
                    //end game
                }
                break;
            }
        }
    }

    public void findKing(TeamColor teamColor){
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                Position tmpP = new Position(i,j);
                ChessPiece tmp = board.getPiece(tmpP);
              if(tmp != null && tmp.getPieceType().equals(ChessPiece.PieceType.KING)&& tmp.getTeamColor() == teamColor){
                  kingForCheck = tmpP;
              }
            }
        }
    }
    @Override
    public boolean isInCheck(TeamColor teamColor) {
        //check final move can kill king
        boolean killedKing = false;
        findKing(teamColor);//find king

            for (int i = 1; i < 9; i++) {//use piece moves on all pieces
                for (int j = 1; j < 9; j++) {
                    Position tmpP = new Position(i,j);
                    ChessPiece tmp = board.getPiece(tmpP);
                    if( tmp != null && tmp.getTeamColor() == teamColor){
                        validMoves(tmpP);
                        if(moves != null){
                            if(moves.contains(new Move(kingForCheck,tmpP, null))){
                                return true;
                            }

                        }

                    }
                }
            }

            // see if end position is where king is

        //
        return false;
    }

    @Override
    public boolean isInCheckmate(TeamColor teamColor) {
        //check final move can kill king
            boolean check = this.isInCheckmate(teamColor);//call isInCheck
        //if true see if king can escape
            //use piece move on king
        validMoves(kingForCheck);//use piece moves on all pieces
        for (ChessMove m:
             moves) {

        }
        return false;
    }

    @Override
    public boolean isInStalemate(TeamColor teamColor) {
        //idk how this works now
        return false;
    }

    @Override
    public void setBoard(ChessBoard board) {//done
        this.board = board;
    }

    @Override
    public ChessBoard getBoard() {//done
        return this.board;
    }
}
