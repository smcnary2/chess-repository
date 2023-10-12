package chess;
import chess.ChessGame.TeamColor;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Piece implements ChessPiece {


    TeamColor newteamcolor;
    PieceType promotionPiece;

    PieceType pieceType;



    PieceType newpiece;
   // I might change this to an array.length() = 6 or just not a string
    //enum for type and color
    public Piece(TeamColor color,PieceType i){
        newteamcolor = color;//set team color
        pieceType = i;//set piece type rkbkqp
    }
    @Override
    public TeamColor getTeamColor() {//ChessGame.TeamColor
        return newteamcolor;
    }

    @Override
    public PieceType getPieceType() {//6 types of pieces
        return pieceType;
    }
    public PieceType getPromotionPiece(){
        return this.promotionPiece;
    }

    public void setPromotionPiece(Piece.PieceType promotionPiece){
        this.promotionPiece = promotionPiece;
    }
//override in classes for pieces
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        // a list of all moves made? ask TA dont understand instructions
        //give it a positon and give it a chess position and it will give a collection of possible moves
        Set<ChessMove> moves = new HashSet<ChessMove>();
        int pieceRow = myPosition.getRow();
        int pieceColumn = myPosition.getColumn();
        ChessPosition endPosition = new Position(pieceRow, pieceColumn);
        int moveRow = pieceRow;
        int moveColumn = pieceColumn;
        boolean canMove;
        ChessPiece occupant;
        int rowInc = 0;
        int colInc = 0;
        int tmprow = myPosition.getRow();;
        int tmpcol = myPosition.getColumn();

        ChessPiece.PieceType pieceType;
        if (this.promotionPiece == null) {
            pieceType = this.pieceType;
        } else {
            pieceType = this.promotionPiece;
        }

        switch (pieceType) {
            case BISHOP:
                // diagonal forward left
                //row appears to always be 4 off, col is just wrong
                rowInc = 1;
                colInc = -1;

                canMove = (moveRow < 8) && (moveColumn > 1);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                while (canMove) {
                    moveRow = moveRow + rowInc;
                    moveColumn = moveColumn + colInc;
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));

                    canMove = (moveRow < 8) && (moveColumn > 1);
                    if (canMove) {
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            if(this.newteamcolor != occupant.getTeamColor()){
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                                canMove = false;
                            }
                        }
                    }
                }
                moveRow = tmprow;
                moveColumn = tmpcol;

                // diagonal forward right
                rowInc = 1;
                colInc = 1;

                canMove = (moveRow < 8) && (moveColumn < 8);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                while (canMove) {
                    moveRow = moveRow + rowInc;
                    moveColumn = moveColumn + colInc;
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));

                    canMove = (moveRow < 8) && (moveColumn < 8);
                    if (canMove) {
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            if(this.newteamcolor != occupant.getTeamColor()){
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                                canMove = false;
                            }
                        }
                    }
                }

                moveRow = tmprow;
                moveColumn = tmpcol;
                // diagonal back left
                rowInc = -1;
                colInc = -1;

                canMove = (moveRow > 1) && (moveColumn > 1);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                while (canMove) {
                    moveRow = moveRow + rowInc;
                    moveColumn = moveColumn + colInc;
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));

                    canMove = (moveRow > 1) && (moveColumn > 1);
                    if (canMove) {
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            if(this.newteamcolor != occupant.getTeamColor()){
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                                canMove = false;
                            }
                        }
                    }
                }

                moveRow = tmprow;
                moveColumn = tmpcol;
                // diagonal back right
                rowInc = -1;
                colInc = 1;

                canMove = (moveRow > 1) && (moveColumn < 8);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                while (canMove) {
                    moveRow = moveRow + rowInc;
                    moveColumn = moveColumn + colInc;
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));

                    canMove = (moveRow > 1) && (moveColumn < 8);
                    if (canMove) {
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            if(this.newteamcolor != occupant.getTeamColor()){

                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                                canMove = false;
                            }
                        }
                    }
                }
                return moves;
            case KING:
                for (int r = ((pieceRow > 1) ? pieceRow - 1 : 1); r <= ((pieceRow < 8) ? pieceRow + 1 : 8); r++) { // all one space moves on board
                    for (int c = ((pieceColumn > 1) ? pieceColumn - 1 : 1); c <= ((pieceColumn < 8) ? pieceColumn + 1 : 8); c++) { // all one space moves on board
                        if (r != pieceRow || c != pieceColumn) { // not the place it is in
                            occupant = board.getPiece(new Position(r, c));
                            if (occupant == null)
                                moves.add(new Move(myPosition, new Position(r, c), this.promotionPiece));
                            else {
                                if (newteamcolor != occupant.getTeamColor()) {
                                    //capture piece
                                    moves.add(new Move(myPosition, new Position(r, c), this.promotionPiece));
                                }
                            }
                        }
                    }
                }
                return moves;
            case PAWN:
                //check color
                moveRow = tmprow;
                moveColumn = tmpcol;
                if (this.newteamcolor == TeamColor.WHITE) {
                    if (pieceRow == 2) {//move 2
                        rowInc = 2;
                        endPosition = new Position(moveRow + rowInc, moveColumn);
                        moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    }
                    //forwards
                    rowInc = 1;
                    endPosition = new Position(moveRow + rowInc, moveColumn);
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    //diagonal 2
                    //right
                    moveRow = tmprow;
                    moveColumn = tmpcol;
                    colInc = 1;
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = board.getPiece(endPosition);
                    canMove = ((occupant != null) && (occupant.getTeamColor() == TeamColor.BLACK));
                    if (canMove) {
                        moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    }
                    //left

                    colInc = -1;
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = board.getPiece(endPosition);
                    canMove = ((occupant != null) && (occupant.getTeamColor() == TeamColor.BLACK));
                    if (canMove) {
                        moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    }
                    moveRow = tmprow;
                    moveColumn = tmpcol;
                } else if(this.newteamcolor == TeamColor.BLACK) {
                    if (pieceRow == 7) {//move 2
                        rowInc = -2;
                        endPosition = new Position(moveRow + rowInc, moveColumn);
                        moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    }
                    //forwards

                    rowInc = -1;
                    endPosition = new Position(moveRow + rowInc, moveColumn);
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    //diagonal 2
                    //right

                    colInc = -1;
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = board.getPiece(endPosition);
                    canMove = ((occupant != null) && (occupant.getTeamColor() == TeamColor.WHITE));
                    if (canMove) {
                        moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    }
                    //left
                    moveRow = tmprow;
                    moveColumn = tmpcol;
                    colInc = 1;
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = board.getPiece(endPosition);
                    canMove = ((occupant != null) && (occupant.getTeamColor() == TeamColor.WHITE));
                    if (canMove) {
                        moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    }
                }
                return moves;
            case ROOK:
                //row and col are calcuated incorrectly??
                //col off by one
                moveRow = tmprow;
                moveColumn = tmpcol;
                rowInc = 1;

                canMove = (moveRow < 8);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                while (canMove) {
                    moveRow = moveRow + rowInc;
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));

                    canMove = (moveRow < 8);
                    if (canMove) {
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            if(this.newteamcolor != occupant.getTeamColor()){
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                                canMove = false;
                            }
                        }
                    }
                }
                moveRow = tmprow;
                moveColumn = tmpcol;
                // backwards
                rowInc = -1;

                canMove = (moveRow > 1);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                while (canMove) {
                    moveRow = moveRow + rowInc;
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));

                    canMove = (moveRow > 1);
                    if (canMove) {
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            if(this.newteamcolor != occupant.getTeamColor()){
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                                canMove = false;
                            }
                        }
                    }
                }
                // left
                moveRow = tmprow;
                moveColumn = tmpcol;
                colInc = -1;

                canMove = (moveColumn > 1);
                if (canMove) {
                    endPosition = new Position(moveRow, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                while (canMove) {
                    moveColumn = moveColumn + colInc;
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));

                    canMove = (moveColumn > 1);
                    if (canMove) {
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            if(this.newteamcolor != occupant.getTeamColor()){
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                                canMove = false;
                            }
                        }
                    }
                }
                // right
                moveRow = tmprow;
                moveColumn = tmpcol;
                colInc = 1;

                canMove = (moveColumn < 8);
                if (canMove) {
                    endPosition = new Position(moveRow, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                while (canMove) {
                    moveColumn = moveColumn + colInc;
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));

                    canMove = (moveColumn < 8);
                    if (canMove) {
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            if(this.newteamcolor != occupant.getTeamColor()){
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                                canMove = false;
                            }
                        }
                    }
                }
                return moves;
            case QUEEN:
                //forward
                //missing coordinates in moves
                moveRow = tmprow;
                moveColumn = tmpcol;
                rowInc = 1;

                canMove = (moveRow < 8);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                while (canMove) {
                    moveRow = moveRow + rowInc;
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));

                    canMove = (moveRow < 8);
                    if (canMove) {
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            if(this.newteamcolor != occupant.getTeamColor()){
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                                canMove = false;
                            }
                        }
                    }
                }
                moveRow = tmprow;
                moveColumn = tmpcol;
                // backwards
                rowInc = -1;

                canMove = (moveRow > 1);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                while (canMove) {
                    moveRow = moveRow + rowInc;
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));

                    canMove = (moveRow > 1);
                    if (canMove) {
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            if(this.newteamcolor != occupant.getTeamColor()){
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                                canMove = false;
                            }
                        }
                    }
                }
                // left
                moveRow = tmprow;
                moveColumn = tmpcol;
                colInc = -1;

                canMove = (moveColumn > 1);
                if (canMove) {
                    endPosition = new Position(moveRow, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                while (canMove) {
                    moveColumn = moveColumn + colInc;
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));

                    canMove = (moveColumn > 1);
                    if (canMove) {
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            if(this.newteamcolor != occupant.getTeamColor()){
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                                canMove = false;
                            }
                        }
                    }
                }
                // right
                moveRow = tmprow;
                moveColumn = tmpcol;
                colInc = 1;

                canMove = (moveColumn < 8);
                if (canMove) {
                    endPosition = new Position(moveRow, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                while (canMove) {
                    moveColumn = moveColumn + colInc;
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));

                    canMove = (moveColumn < 8);
                    if (canMove) {
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            if(this.newteamcolor != occupant.getTeamColor()){
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                                canMove = false;
                            }
                        }
                    }
                }

                // diagonal forward left
                moveRow = tmprow;
                moveColumn = tmpcol;
                rowInc = 1;
                colInc = -1;

                canMove = (moveRow < 8) && (moveColumn > 1);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                while (canMove) {
                    moveRow = moveRow + rowInc;
                    moveColumn = moveColumn + colInc;
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));

                    canMove = (moveRow < 8) && (moveColumn > 1);
                    if (canMove) {
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            if(this.newteamcolor != occupant.getTeamColor()){
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                                canMove = false;
                            }
                        }
                    }
                }
                moveRow = tmprow;
                moveColumn = tmpcol;

                // diagonal forward right
                rowInc = 1;
                colInc = 1;

                canMove = (moveRow < 8) && (moveColumn < 8);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                while (canMove) {
                    moveRow = moveRow + rowInc;
                    moveColumn = moveColumn + colInc;
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));

                    canMove = (moveRow < 8) && (moveColumn < 8);
                    if (canMove) {
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            if(this.newteamcolor != occupant.getTeamColor()){
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                                canMove = false;
                            }
                        }
                    }
                }

                moveRow = tmprow;
                moveColumn = tmpcol;
                // diagonal back left
                rowInc = -1;
                colInc = -1;

                canMove = (moveRow > 1) && (moveColumn > 1);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                while (canMove) {
                    moveRow = moveRow + rowInc;
                    moveColumn = moveColumn + colInc;
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));

                    canMove = (moveRow > 1) && (moveColumn > 1);
                    if (canMove) {
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            if(this.newteamcolor != occupant.getTeamColor()){
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                                canMove = false;
                            }
                        }
                    }
                }

                moveRow = tmprow;
                moveColumn = tmpcol;
                // diagonal back right
                rowInc = -1;
                colInc = 1;

                canMove = (moveRow > 1) && (moveColumn < 8);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                while (canMove) {
                    moveRow = moveRow + rowInc;
                    moveColumn = moveColumn + colInc;
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));

                    canMove = (moveRow > 1) && (moveColumn < 8);
                    if (canMove) {
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            if(this.newteamcolor != occupant.getTeamColor()){

                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                                canMove = false;
                            }
                        }
                    }
                }
                return moves;
            case KNIGHT:
                //f2 l1
                moveRow = tmprow;
                moveColumn = tmpcol;
                rowInc = 2;
                colInc = -1;
                canMove = (moveRow < 8) && (moveColumn > 1);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        if(this.newteamcolor != occupant.getTeamColor()){
                            moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                            canMove = false;
                        }
                    }
                }
                if (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                }

                //right 1
                moveRow = tmprow;
                moveColumn = tmpcol;
                colInc = 1;
                canMove = (moveRow < 8) && (moveColumn < 8);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        if(this.newteamcolor != occupant.getTeamColor()){
                            moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                            canMove = false;
                        }
                    }
                }
                if (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                }
                //back 2
                //left1
                moveRow = tmprow;
                moveColumn = tmpcol;
                rowInc = -2;
                colInc = -1;
                canMove = (moveRow > 1) && (moveColumn > 1);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        if(this.newteamcolor != occupant.getTeamColor()){
                            moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                            canMove = false;
                        }
                    }
                }
                if (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                }
                //right1
                moveRow = tmprow;
                moveColumn = tmpcol;
                colInc = 1;
                canMove = (moveRow > 1) && (moveColumn < 8);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        if(this.newteamcolor != occupant.getTeamColor()){
                            moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                            canMove = false;
                        }
                    }
                }
                if (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                }

                //left 2
                //forward1
                moveRow = tmprow;
                moveColumn = tmpcol;
                colInc = -2;
                rowInc = 1;
                canMove = (moveRow < 8) && (moveColumn > 1);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                if (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                }
                //back 1
                moveRow = tmprow;
                moveColumn = tmpcol;
                rowInc = -1;
                canMove = (moveRow > 1) && (moveColumn > 1);
                if (canMove) {
                    endPosition = new Position(moveRow + rowInc, moveColumn + colInc);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        if(this.newteamcolor != occupant.getTeamColor()){
                            moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                            canMove = false;
                        }
                    }
                }
                if (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                }

                return moves;
        }
        return null;
    }


}
