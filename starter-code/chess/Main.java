package chess;

public class Main {
    public static void main( String[]  args){
        Board boardGame1 = new Board();
        Position testpos = new Position(4,4);
        ChessPiece testpiece = new Piece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
        boardGame1.addPiece(testpos,testpiece);
        ChessPiece test = boardGame1.getPiece(testpos);
        System.out.println(test);
    }
}
