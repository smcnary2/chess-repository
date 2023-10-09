package chess;

public class Board implements ChessBoard{

    ChessPiece[][] newboard;
    //array that keeps track of peice position or make a mthod that iterates through board to find all pieces

    public Board(){
        //8x8 size
        //rkbkqbkr
        //pppppppp
        newboard = new ChessPiece[8][8];

    }
    @Override
    public void addPiece(ChessPosition position, ChessPiece piece) {//only touch when first start
        newboard[position.getRow()-1][position.getColumn()-1] = piece;
        //why is chess piece necessary for this funct. ask TA
    }

    @Override
    public ChessPiece getPiece(ChessPosition position) {
        // at this position in the array what piece
        return newboard[position.getRow()-1][position.getColumn()-1];
    }
    @Override
    public void movePiece(ChessMove move){
        int row = move.getStartPosition().getRow();
        int column = move.getStartPosition().getColumn();
        ChessPiece piece = newboard[row][column];
        newboard[row][column] = null;
        this.addPiece(move.getEndPosition(), piece);
    }

    @Override
    public void movePiece(ChessMove move){
        int row = move.getStartPosition().getRow();
        int column = move.getStartPosition().getColumn();
        ChessPiece piece = newboard[row-1][column-1];
        newboard[row-1][column-1] = null;
        this.addPiece(move.getEndPosition(), piece);
    }
    @Override
    public void resetBoard() {
        newboard = new Piece[8][8];
        addPiece(new Position(1,1), new Piece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK));
        addPiece(new Position(1,2),new Piece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT));
        addPiece(new Position(1,3),new Piece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP));
        addPiece(new Position(1,4), new Piece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.QUEEN));
        addPiece(new Position(1,5), new Piece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KING));
        addPiece(new Position(1,6), new Piece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP));
        addPiece(new Position(1,7),new Piece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT));
        addPiece(new Position(1,8), new Piece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK));
        for (int i = 1; i < 9; i++) {
            addPiece(new Position(2,i), new Piece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN));
        }
        for (int i = 1; i < 9; i++) {
            addPiece(new Position(7,i),new Piece(ChessGame.TeamColor.BLACK,ChessPiece.PieceType.PAWN));
        }
        addPiece(new Position(8,1), new Piece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK));
        addPiece(new Position(8,2),new Piece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT));
        addPiece(new Position(8,3),new Piece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP));
        addPiece(new Position(8,4), new Piece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN));
        addPiece(new Position(8,5), new Piece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KING));
        addPiece(new Position(8,6), new Piece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP));
        addPiece(new Position(8,7),new Piece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT));
        addPiece(new Position(8,8), new Piece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK));
        //array that holds captured pieces(dont create new objects or have garbage collector take it) or a flag
        //use get column get row
    }
}
