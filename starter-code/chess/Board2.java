package chess;

public class Board2 implements ChessBoard{
    ChessPiece[][] newboard;
    //array that keeps track of peice position or make a mthod that iterates through board to find all pieces

    public Board2(){
        //8x8 size
        //rkbkqbkr
        //pppppppp
        newboard = new ChessPiece[8][8];
        resetBoard();

    }
    @Override
    public void addPiece(ChessPosition position, ChessPiece piece) {//only touch when first start
        newboard[position.getRow()][position.getColumn()] = piece;
        //why is chess piece necessary for this funct. ask TA
    }

    @Override
    public ChessPiece getPiece(ChessPosition position) {
        // at this position in the array what piece
        return null;
    }

    @Override
    public void resetBoard() {
        newboard = new ChessPiece[8][8];
        addPiece(new Position(0,0), new Piece(Piece.TeamColor.WHITE, Piece.PieceTypes.ROOK));
        addPiece(new Position(0,1),new Piece(Piece.TeamColor.WHITE, Piece.PieceTypes.KNIGHT));
        addPiece(new Position(0,2),new Piece(Piece.TeamColor.WHITE, Piece.PieceTypes.BISHOP));
        addPiece(new Position(0,3), new Piece(Piece.TeamColor.WHITE, Piece.PieceTypes.KING));
        addPiece(new Position(0,4), new Piece(Piece.TeamColor.WHITE, Piece.PieceTypes.QUEEN));
        addPiece(new Position(0,5), new Piece(Piece.TeamColor.WHITE, Piece.PieceTypes.BISHOP));
        addPiece(new Position(0,6),new Piece(Piece.TeamColor.WHITE, Piece.PieceTypes.KNIGHT));
        addPiece(new Position(0,7), new Piece(Piece.TeamColor.WHITE, Piece.PieceTypes.ROOK));
        for (int i = 0; i < 5; i++) {
            addPiece(new Position(2,i), new Piece(Piece.TeamColor.WHITE, Piece.PieceTypes.PAWN));
        }
        for (int i = 0; i < 5; i++) {
            addPiece(new Position(6,i),new Piece(Piece.TeamColor.BLACK,Piece.PieceTypes.PAWN));
        }
        addPiece(new Position(7,0), new Piece(Piece.TeamColor.BLACK, Piece.PieceTypes.ROOK));
        addPiece(new Position(7,1),new Piece(Piece.TeamColor.BLACK, Piece.PieceTypes.KNIGHT));
        addPiece(new Position(7,2),new Piece(Piece.TeamColor.BLACK, Piece.PieceTypes.BISHOP));
        addPiece(new Position(7,3), new Piece(Piece.TeamColor.BLACK, Piece.PieceTypes.KING));
        addPiece(new Position(7,4), new Piece(Piece.TeamColor.BLACK, Piece.PieceTypes.QUEEN));
        addPiece(new Position(7,5), new Piece(Piece.TeamColor.BLACK, Piece.PieceTypes.BISHOP));
        addPiece(new Position(7,6),new Piece(Piece.TeamColor.BLACK, Piece.PieceTypes.KNIGHT));
        addPiece(new Position(7,7), new Piece(Piece.TeamColor.BLACK, Piece.PieceTypes.ROOK));
        //array that holds captured pieces(dont create new objects or have garbage collector take it) or a flag
        //use get column get row
    }
}
