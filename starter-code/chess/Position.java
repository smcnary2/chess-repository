package chess;
//its done
public class Position implements ChessPosition{
    public int row;// maybe 2 arrays (row & column) of all the positions and then just return coordinates
    public int column;
    //only holds row and column position
    // an object for each chess piece
    //get end position from user
    /*
    4x8 array
    location of pieces:
    rkbkqbkr
    pppppppp
    pppppppp
    rkbkqbkr
     */

    public Position(int r, int c){// this now creates an object so that the other methods work
        row = r;
        column = c;
        //how will you know what piece it is?? new parameter?
        //is this even a good idea?? talk to TA tomorrow about this and github
    }
    @Override
    public int getRow() {// should there be a parameter?? no
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(ChessPosition p){
        return this.column == p.getColumn() && this.row == p.getRow();
    }
}
