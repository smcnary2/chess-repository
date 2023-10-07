package chess;

public class Main {
    public static void main( String[]  args){
        Board2 boardGame1 = new Board2();
        Position testpos = new Position(1,2);
        ChessPiece test = boardGame1.getPiece(testpos);
        System.out.println(test);
    }
}
