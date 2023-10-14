package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Game implements ChessGame{
    public ChessBoard board;
    public TeamColor team;

    public Collection<ChessMove> moves;
    public ChessMove lastMove;
    public Position kingForCheck;
    public boolean inCheck;
    public Game(){
        team = TeamColor.WHITE;
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
        TeamColor tmpcolor;

        moves = piece.pieceMoves(this.board, startPosition);
        //call isInCheck
        //simulate move on fake board
        Collection<ChessMove> movesPt2 = new HashSet<>();
        ChessBoard fakeBoard;
        boolean check = false;
        for (ChessMove m:
             moves) {
                fakeBoard = this.board;
                //check if move causes check
                Move tmp = new Move(new Position(m.getStartPosition().getRow(), m.getStartPosition().getColumn()), new Position(m.getEndPosition().getRow(), m.getEndPosition().getColumn()), m.getPromotionPiece());
                ChessPiece tmpPiece = this.board.getPiece(new Position(m.getEndPosition().getRow(), m.getEndPosition().getColumn()));
                fakeBoard.movePiece(tmp);//move piece back
                kingForCheck = null;
                check = this.isInCheck(piece.getTeamColor());
                tmp = new Move(new Position(m.getEndPosition().getRow(), m.getEndPosition().getColumn()), new Position(m.getStartPosition().getRow(), m.getStartPosition().getColumn()), m.getPromotionPiece());
                fakeBoard.movePiece(tmp);
                fakeBoard.addPiece(new Position(m.getEndPosition().getRow(), m.getEndPosition().getColumn()),tmpPiece);
                if(!check){//try to eliminate check change from checkmate to modify the board
                    movesPt2.add(m);// if you can't remove move
                }
                // add to 2nd list instead of removing
        }



        return movesPt2;
    }

    @Override
    public void makeMove(ChessMove move) throws InvalidMoveException {
         moves = this.validMoves(move.getStartPosition());
         //check if theres a promotion and switch out piece
        if(!(this.board.getPiece(move.getStartPosition()).getTeamColor().equals(team))){
            throw new InvalidMoveException();
        }

        //contains

            if (moves.contains(move)) {

                this.board.movePiece(move);
                if (this.board.getPiece(move.getStartPosition()) != null) {
                    this.board.addPiece(move.getStartPosition(), null);
                }

                ChessPiece tmp = null;
                if (move.getPromotionPiece() != null) {//check if there's a promotion
                    if (move.getPromotionPiece().equals(ChessPiece.PieceType.KING)) {
                        tmp = new Piece(team, ChessPiece.PieceType.KING);
                    } else if (move.getPromotionPiece().equals(ChessPiece.PieceType.KNIGHT)) {
                        tmp = new Piece(team, ChessPiece.PieceType.KNIGHT);
                    } else if (move.getPromotionPiece().equals(ChessPiece.PieceType.ROOK)) {
                        tmp = new Piece(team, ChessPiece.PieceType.ROOK);
                    } else if (move.getPromotionPiece().equals(ChessPiece.PieceType.BISHOP)) {
                        tmp = new Piece(team, ChessPiece.PieceType.BISHOP);
                    } else if (move.getPromotionPiece().equals(ChessPiece.PieceType.QUEEN)) {
                        tmp = new Piece(team, ChessPiece.PieceType.QUEEN);
                    }
                    this.board.addPiece(move.getEndPosition(), tmp);//get position of piece and change it to promotion piece
                }
            }else{
                throw new InvalidMoveException();
            }
            if(team.equals(TeamColor.WHITE)){
                team = TeamColor.BLACK;
            }else{
                team = TeamColor.WHITE;
            }


        //change turn

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
        //boolean killedKing = false;
        //kingForCheck = null;
        findKing(teamColor);//find king
        if(kingForCheck == null){
            System.out.println("hi");
        }
        for (int i = 1; i < 9; i++) {//use piece moves on all pieces
            for (int j = 1; j < 9; j++) {
                Position tmpP = new Position(i,j);
                ChessPiece tmp = board.getPiece(tmpP);
                if( tmp != null && tmp.getTeamColor() != teamColor){

                    moves = tmp.pieceMoves(this.board,tmpP);//PieceMoves
                    if(moves != null){
                        if((moves.contains(new Move(tmpP,kingForCheck, null))) || (moves.contains(new Move(tmpP,kingForCheck, ChessPiece.PieceType.QUEEN)))){
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
        ChessBoard fakeBoard ;
        ChessBoard tmpBoard = this.board;
        boolean check = this.isInCheck(teamColor);//call isInCheck
        //if true see if king can escape
            //use piece move on king
        if(check){//move this
            for (int i = 1; i < 9; i++) {
                for (int j = 1; j < 9; j++) {
                    Position tmp2 = new Position(i, j);
                    ChessPiece tmp3 = board.getPiece(tmp2);
                    if (tmp3 != null && tmp3.getTeamColor() != teamColor) {
                        moves = tmp3.pieceMoves(this.board, tmp2);//piece.piece moves
                        if (moves != null) {
                            for (ChessMove m :
                                    moves) {
                                //check all pieces moves not just king
                                fakeBoard = tmpBoard;
                                //check if move causes check
                                Move tmp = new Move(new Position(m.getStartPosition().getRow(), m.getStartPosition().getColumn()), new Position(m.getEndPosition().getRow(), m.getEndPosition().getColumn()), m.getPromotionPiece());
                                ChessPiece tmpPiece = fakeBoard.getPiece(new Position(m.getEndPosition().getRow(), m.getEndPosition().getColumn()));
                                fakeBoard.movePiece(tmp);//move piece back
                                check = this.isInCheck(team);
                                tmp = new Move(new Position(m.getEndPosition().getRow(), m.getEndPosition().getColumn()), new Position(m.getStartPosition().getRow(), m.getStartPosition().getColumn()), m.getPromotionPiece());
                                fakeBoard.movePiece(tmp);
                                fakeBoard.addPiece(new Position(m.getEndPosition().getRow(), m.getEndPosition().getColumn()),tmpPiece);

                            }
                            if (check) {
                                return true;
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }

        }
        return false;
    }

    @Override
    public boolean isInStalemate(TeamColor teamColor) {
        //same as checkmate but king is not in danger but any move will put the king in danger
        boolean check = this.isInCheck(teamColor);//call isInCheck
        //if true see if king can escape
        //use piece move on king
        if(!check){//move this
            for (int i = 1; i < 9; i++) {
                for (int j = 1; j < 9; j++) {
                    Position tmp2 = new Position(i, j);
                    ChessPiece tmp3 = board.getPiece(tmp2);
                    if (tmp3 != null && tmp3.getTeamColor() == teamColor) {
                        moves = tmp3.pieceMoves(this.board, tmp2);//piece.piece moves
                        if (moves != null) {
                            for (ChessMove m :
                                    moves) {
                                //check all pieces moves not just king
                                Move tmp = new Move(new Position(m.getStartPosition().getRow(), m.getStartPosition().getColumn()), new Position(m.getEndPosition().getRow(), m.getEndPosition().getColumn()), m.getPromotionPiece());
                                this.board.movePiece(tmp);//move piece back
                                check = this.isInCheck(teamColor);
                                tmp = new Move(new Position(m.getEndPosition().getRow(), m.getEndPosition().getColumn()), new Position(m.getStartPosition().getRow(), m.getStartPosition().getColumn()), m.getPromotionPiece());
                                this.board.movePiece(tmp);
                            }
                            if (check) {
                                return true;
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
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
