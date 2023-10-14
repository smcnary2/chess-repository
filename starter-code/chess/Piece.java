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
        boolean capture = false;

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
                moveRow = pieceRow;
                moveColumn = pieceColumn;
                capture = false;
                rowInc = 1;
                colInc = -1;

                canMove = (moveRow < 8) && (moveColumn > 1);
                if (canMove) {
                    moveRow = moveRow + rowInc;
                    moveColumn = moveColumn + colInc;
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        capture = true;
                    }
                }
                while (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    canMove = (moveRow < 8) && (moveColumn > 1) && (!capture);
                    if (canMove) {
                        moveRow = moveRow + rowInc;
                        moveColumn = moveColumn + colInc;
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            capture = true;
                        }
                    }
                }
                // diagonal forward right
                moveRow = pieceRow;
                moveColumn = pieceColumn;
                capture = false;
                rowInc = 1;
                colInc = 1;

                canMove = (moveRow < 8) && (moveColumn < 8);
                if (canMove) {
                    moveRow = moveRow + rowInc;
                    moveColumn = moveColumn + colInc;
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        capture = true;
                    }
                }
                while (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    canMove = (moveRow < 8) && (moveColumn < 8) && (!capture);
                    if (canMove) {
                        moveRow = moveRow + rowInc;
                        moveColumn = moveColumn + colInc;
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            capture = true;
                        }
                    }
                }

                // diagonal back left
                moveRow = pieceRow;
                moveColumn = pieceColumn;
                capture = false;
                rowInc = -1;
                colInc = -1;

                canMove = (moveRow > 1) && (moveColumn > 1);
                if (canMove) {
                    moveRow = moveRow + rowInc;
                    moveColumn = moveColumn + colInc;
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        capture = true;
                    }
                }
                while (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    canMove = (moveRow > 1) && (moveColumn > 1) && (!capture);
                    if (canMove) {
                        moveRow = moveRow + rowInc;
                        moveColumn = moveColumn + colInc;
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            capture = true;
                        }
                    }
                }

                // diagonal back right
                moveRow = pieceRow;
                moveColumn = pieceColumn;
                capture = false;
                rowInc = -1;
                colInc = 1;

                canMove = (moveRow > 1) && (moveColumn < 8);
                if (canMove) {
                    moveRow = moveRow + rowInc;
                    moveColumn = moveColumn + colInc;
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        capture = true;
                    }
                }
                while (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    canMove = (moveRow > 1) && (moveColumn < 8) && (!capture);
                    if (canMove) {
                        moveRow = moveRow + rowInc;
                        moveColumn = moveColumn + colInc;
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            capture = true;
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
                if (this.newteamcolor == TeamColor.WHITE) {
                //single
                    moveRow = pieceRow + 1;
                    moveColumn = pieceColumn;
                    if ((moveRow >= 1) && (moveRow <= 8)) {
                        endPosition = new Position(moveRow, moveColumn);
                        //is position empty
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if ((occupant == null)) {
                            if ((moveRow == 1) || (moveRow == 8)){
                                moves.add(new Move(myPosition, endPosition, PieceType.QUEEN));
                                moves.add(new Move(myPosition, endPosition, PieceType.BISHOP));
                                moves.add(new Move(myPosition, endPosition, PieceType.ROOK));
                                moves.add(new Move(myPosition, endPosition, PieceType.KNIGHT));
                            }
                            else{
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                            }
                            //double
                            if (pieceRow == 2) {
                                moveRow = pieceRow + 2;
                                moveColumn = pieceColumn;
                                endPosition = new Position(moveRow, moveColumn);
                                //is position empty
                                occupant = (ChessPiece) board.getPiece(endPosition);
                                if (occupant == null) {
                                    moves.add(new Move(myPosition, new Position(moveRow, moveColumn), this.promotionPiece));
                                }
                            }
                        }
                    }
                //capture left
                    moveRow = pieceRow + 1;
                    moveColumn = pieceColumn - 1;
                    if ((moveRow >= 1) && (moveColumn >=1 ) && (moveRow <= 8) && (moveColumn <= 8)) {
                        //is opponent in position
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if ((occupant != null) && (occupant.getTeamColor() == TeamColor.BLACK)) {
                            if ((moveRow == 1) || (moveRow == 8)){
                                moves.add(new Move(myPosition, endPosition, PieceType.QUEEN));
                                moves.add(new Move(myPosition, endPosition, PieceType.BISHOP));
                                moves.add(new Move(myPosition, endPosition, PieceType.ROOK));
                                moves.add(new Move(myPosition, endPosition, PieceType.KNIGHT));
                            }
                            else{
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                            }
                        }
                    }
                //capture right
                    moveRow = pieceRow + 1;
                    moveColumn = pieceColumn + 1;
                    if ((moveRow >= 1) && (moveColumn >=1 ) && (moveRow <= 8) && (moveColumn <= 8)) {
                        //is opponent in position
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if ((occupant != null) && (occupant.getTeamColor() == TeamColor.BLACK)) {
                            if ((moveRow == 1) || (moveRow == 8)){
                                moves.add(new Move(myPosition, endPosition, PieceType.QUEEN));
                                moves.add(new Move(myPosition, endPosition, PieceType.BISHOP));
                                moves.add(new Move(myPosition, endPosition, PieceType.ROOK));
                                moves.add(new Move(myPosition, endPosition, PieceType.KNIGHT));
                            }
                            else{
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                            }
                        }
                    }
                } else if(this.newteamcolor == TeamColor.BLACK) {
                    //single
                    moveRow = pieceRow - 1;
                    moveColumn = pieceColumn;
                    if ((moveRow >= 1) && (moveRow <= 8)) {
                        endPosition = new Position(moveRow, moveColumn);
                        //is position empty
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if ((occupant == null)) {
                            if ((moveRow == 1) || (moveRow == 8)){
                                moves.add(new Move(myPosition, endPosition, PieceType.QUEEN));
                                moves.add(new Move(myPosition, endPosition, PieceType.BISHOP));
                                moves.add(new Move(myPosition, endPosition, PieceType.ROOK));
                                moves.add(new Move(myPosition, endPosition, PieceType.KNIGHT));
                            }
                            else{
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                            }
                            //double
                            if (pieceRow == 7) {
                                moveRow = pieceRow - 2;
                                moveColumn = pieceColumn;
                                endPosition = new Position(moveRow, moveColumn);
                                //is position empty
                                occupant = (ChessPiece) board.getPiece(endPosition);
                                if (occupant == null) {
                                    moves.add(new Move(myPosition, new Position(moveRow, moveColumn), this.promotionPiece));
                                }
                            }
                        }
                    }
                    //capture left
                    moveRow = pieceRow - 1;
                    moveColumn = pieceColumn - 1;
                    if ((moveRow >= 1) && (moveColumn >=1 ) && (moveRow <= 8) && (moveColumn <= 8)) {
                        //is opponent in position
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if ((occupant != null) && (occupant.getTeamColor() == TeamColor.WHITE)) {
                            if ((moveRow == 1) || (moveRow == 8)){
                                moves.add(new Move(myPosition, endPosition, PieceType.QUEEN));
                                moves.add(new Move(myPosition, endPosition, PieceType.BISHOP));
                                moves.add(new Move(myPosition, endPosition, PieceType.ROOK));
                                moves.add(new Move(myPosition, endPosition, PieceType.KNIGHT));
                            }
                            else{
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                            }
                        }
                    }
                    //capture right
                    moveRow = pieceRow - 1;
                    moveColumn = pieceColumn + 1;
                    if ((moveRow >= 1) && (moveColumn >=1 ) && (moveRow <= 8) && (moveColumn <= 8)) {
                        //is opponent in position
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if ((occupant != null) && (occupant.getTeamColor() == TeamColor.WHITE)) {
                            if ((moveRow == 1) || (moveRow == 8)){
                                moves.add(new Move(myPosition, endPosition, PieceType.QUEEN));
                                moves.add(new Move(myPosition, endPosition, PieceType.BISHOP));
                                moves.add(new Move(myPosition, endPosition, PieceType.ROOK));
                                moves.add(new Move(myPosition, endPosition, PieceType.KNIGHT));
                            }
                            else{
                                moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                            }
                        }
                    }
                }
                return moves;
            case ROOK:
                //forwards
                moveRow = pieceRow;
                moveColumn = pieceColumn;
                capture = false;
                rowInc = 1;
                canMove = (moveRow < 8);
                if (canMove) {
                    moveRow = moveRow + rowInc;// TEST
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        capture = true;
                    }
                }
                while (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    canMove = (moveRow < 8) && (!capture);
                    if (canMove) {
                        moveRow = moveRow + rowInc;// TEST
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            capture = true;
                        }
                    }
                }
                // backwards
                moveRow = pieceRow;
                moveColumn = pieceColumn;
                capture = false;
                rowInc = -1;
                canMove = (moveRow > 1);
                if (canMove) {
                    moveRow = moveRow + rowInc;
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        capture = true;
                    }
                }
                while (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    canMove = (moveRow > 1) && (!capture);
                    if (canMove) {
                        moveRow = moveRow + rowInc;
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            capture = true;
                        }
                    }
                }
                // left
                moveRow = pieceRow;
                moveColumn = pieceColumn;
                capture = false;
                colInc = -1;
                canMove = (moveColumn > 1);
                if (canMove) {
                    moveColumn = moveColumn + colInc;
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        capture = true;
                    }
                }
                while (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    canMove = (moveColumn > 1) && (!capture);
                    if (canMove) {
                        moveColumn = moveColumn + colInc;
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            capture = true;
                        }
                    }
                }
                // right
                moveRow = pieceRow;
                moveColumn = pieceColumn;
                capture = false;
                colInc = 1;
                canMove = (moveColumn < 8);
                if (canMove) {
                    moveColumn = moveColumn + colInc;
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        capture = true;
                    }
                }
                while (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    canMove = (moveColumn < 8) && (!capture);
                    if (canMove) {
                        moveColumn = moveColumn + colInc;
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            capture = true;
                        }
                    }
                }
                return moves;
            case QUEEN:
                //forwards
                moveRow = pieceRow;
                moveColumn = pieceColumn;
                capture = false;
                rowInc = 1;
                canMove = (moveRow < 8);
                if (canMove) {
                    moveRow = moveRow + rowInc;// TEST
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        capture = true;
                    }
                }
                while (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    canMove = (moveRow < 8) && (!capture);
                    if (canMove) {
                        moveRow = moveRow + rowInc;// TEST
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            capture = true;
                        }
                    }
                }
                // backwards
                moveRow = pieceRow;
                moveColumn = pieceColumn;
                capture = false;
                rowInc = -1;
                canMove = (moveRow > 1);
                if (canMove) {
                    moveRow = moveRow + rowInc;
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        capture = true;
                    }
                }
                while (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    canMove = (moveRow > 1) && (!capture);
                    if (canMove) {
                        moveRow = moveRow + rowInc;
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            capture = true;
                        }
                    }
                }
                // left
                moveRow = pieceRow;
                moveColumn = pieceColumn;
                capture = false;
                colInc = -1;
                canMove = (moveColumn > 1);
                if (canMove) {
                    moveColumn = moveColumn + colInc;
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        capture = true;
                    }
                }
                while (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    canMove = (moveColumn > 1) && (!capture);
                    if (canMove) {
                        moveColumn = moveColumn + colInc;
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            capture = true;
                        }
                    }
                }
                // right
                moveRow = pieceRow;
                moveColumn = pieceColumn;
                capture = false;
                colInc = 1;
                canMove = (moveColumn < 8);
                if (canMove) {
                    moveColumn = moveColumn + colInc;
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        capture = true;
                    }
                }
                while (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    canMove = (moveColumn < 8) && (!capture);
                    if (canMove) {
                        moveColumn = moveColumn + colInc;
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            capture = true;
                        }
                    }
                }
                // diagonal forward left
                //row appears to always be 4 off, col is just wrong
                moveRow = pieceRow;
                moveColumn = pieceColumn;
                capture = false;
                rowInc = 1;
                colInc = -1;

                canMove = (moveRow < 8) && (moveColumn > 1);
                if (canMove) {
                    moveRow = moveRow + rowInc;
                    moveColumn = moveColumn + colInc;
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        capture = true;
                    }
                }
                while (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    canMove = (moveRow < 8) && (moveColumn > 1) && (!capture);
                    if (canMove) {
                        moveRow = moveRow + rowInc;
                        moveColumn = moveColumn + colInc;
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            capture = true;
                        }
                    }
                }
                // diagonal forward right
                moveRow = pieceRow;
                moveColumn = pieceColumn;
                capture = false;
                rowInc = 1;
                colInc = 1;

                canMove = (moveRow < 8) && (moveColumn < 8);
                if (canMove) {
                    moveRow = moveRow + rowInc;
                    moveColumn = moveColumn + colInc;
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        capture = true;
                    }
                }
                while (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    canMove = (moveRow < 8) && (moveColumn < 8) && (!capture);
                    if (canMove) {
                        moveRow = moveRow + rowInc;
                        moveColumn = moveColumn + colInc;
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            capture = true;
                        }
                    }
                }

                // diagonal back left
                moveRow = pieceRow;
                moveColumn = pieceColumn;
                capture = false;
                rowInc = -1;
                colInc = -1;

                canMove = (moveRow > 1) && (moveColumn > 1);
                if (canMove) {
                    moveRow = moveRow + rowInc;
                    moveColumn = moveColumn + colInc;
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        capture = true;
                    }
                }
                while (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    canMove = (moveRow > 1) && (moveColumn > 1) && (!capture);
                    if (canMove) {
                        moveRow = moveRow + rowInc;
                        moveColumn = moveColumn + colInc;
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            capture = true;
                        }
                    }
                }

                // diagonal back right
                moveRow = pieceRow;
                moveColumn = pieceColumn;
                capture = false;
                rowInc = -1;
                colInc = 1;

                canMove = (moveRow > 1) && (moveColumn < 8);
                if (canMove) {
                    moveRow = moveRow + rowInc;
                    moveColumn = moveColumn + colInc;
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                        capture = true;
                    }
                }
                while (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                    canMove = (moveRow > 1) && (moveColumn < 8) && (!capture);
                    if (canMove) {
                        moveRow = moveRow + rowInc;
                        moveColumn = moveColumn + colInc;
                        endPosition = new Position(moveRow, moveColumn);
                        occupant = (ChessPiece) board.getPiece(endPosition);
                        if (occupant != null) {
                            canMove = !(this.newteamcolor == occupant.getTeamColor());
                            capture = true;
                        }
                    }
                }
                return moves;
            case KNIGHT:
                //f2 l1
                moveRow = pieceRow+2;
                moveColumn = pieceColumn-1;
                canMove = (moveRow >= 1) && (moveColumn >= 1) && (moveRow <= 8) && (moveColumn <= 8);
                if (canMove) {
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());

                    }
                }
                if (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                }

                //f2 r1
                moveRow = pieceRow+2;
                moveColumn = pieceColumn+1;
                canMove = (moveRow >= 1) && (moveColumn >= 1) && (moveRow <= 8) && (moveColumn <= 8);
                if (canMove) {
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                if (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                }
                //f1 l2
                moveRow = pieceRow+1;
                moveColumn = pieceColumn-2;
                canMove = (moveRow >= 1) && (moveColumn >= 1) && (moveRow <= 8) && (moveColumn <= 8);
                if (canMove) {
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                if (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                }

                //f1 r2
                moveRow = pieceRow+1;
                moveColumn = pieceColumn+2;
                canMove = (moveRow >= 1) && (moveColumn >= 1) && (moveRow <= 8) && (moveColumn <= 8);
                if (canMove) {
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                if (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                }
                //b2 l1
                moveRow = pieceRow-2;
                moveColumn = pieceColumn-1;
                canMove = (moveRow >= 1) && (moveColumn >= 1) && (moveRow <= 8) && (moveColumn <= 8);
                if (canMove) {
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                if (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                }
                //b2 r1
                moveRow = pieceRow-2;
                moveColumn = pieceColumn+1;
                canMove = (moveRow >= 1) && (moveColumn >= 1) && (moveRow <= 8) && (moveColumn <= 8);
                if (canMove) {
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                if (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                }
                //b1 l2
                moveRow = pieceRow-1;
                moveColumn = pieceColumn-2;
                canMove = (moveRow >= 1) && (moveColumn >= 1) && (moveRow <= 8) && (moveColumn <= 8);
                if (canMove) {
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
                    }
                }
                if (canMove) {
                    moves.add(new Move(myPosition, endPosition, this.promotionPiece));
                }
                //b1 r2
                moveRow = pieceRow-1;
                moveColumn = pieceColumn+2;
                canMove = (moveRow >= 1) && (moveColumn >= 1) && (moveRow <= 8) && (moveColumn <= 8);
                if (canMove) {
                    endPosition = new Position(moveRow, moveColumn);
                    occupant = (ChessPiece) board.getPiece(endPosition);
                    if (occupant != null) {
                        canMove = !(this.newteamcolor == occupant.getTeamColor());
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
