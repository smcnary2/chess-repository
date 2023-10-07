package chess;

public class Board_dep implements ChessBoard{
    //extend piece for get piece method
    ChessPiece[][] newboard;
    //array that keeps track of peice position or make a mthod that iterates through board to find all pieces

    public Board_dep(){
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

        int color = 1;
        int piece;
        for (int k = 0; k < 8;) {
            System.out.print('\n');
            if(k == 6 || k == 1){
                piece = 6;
            }else{
                piece= 0;
            }
            for (int i = 0; i < 8; i++) {
                if(piece <5 && i<5){
                    piece++;
                }
                if(piece == 5 && i > 4){
                    piece--;
                }
                if(piece <= 4 && i >4){
                    piece--;
                }
                //addPiece(new Position(k,i),new Piece(color,piece));//this loop may not work for piece
                System.out.print(piece);
                //if I make type an array in postion then this loop still works, but that doesnt mean its a good idea
            }
            if(k == 1){
                k=6;
                color = 0;
            }else{
                k++;
            }
        }

        //array that holds captured pieces(dont create new objects or have garbage collector take it) or a flag
        //use get column get row
    }
}
