package chess;

public class Main {
    public static void main( String[]  args){
       Game game1 = new Game();
       ChessBoard board = game1.getBoard();
       ChessPosition position1= new Position(5,4);
       Piece pieceKing = new Piece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KING);
       board.addPiece(position1, pieceKing);

    }
}
