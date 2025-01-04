import ;

public enum PieceTYPE { //DONE
    PAWN, KNIGHT, ROOK, BISHOP, QUEEN, KING, PIECE;
}

public abstract class Piece extends Position {
    Position position = new Position(new byte[]{-1,-1,-1});
    public Piece(Position position) { super(position); }

    public Position getPosition(){ return position; }
    public byte[] getPosition (byte num) { return getCoordinates(); }

    public void setPosition(Position position){ }

    public Position move(Piece piece, Position position){ /** Returns Code that immediately fails*/
        return new Position(new byte [] {-1,-1,-1});
    }

    public boolean edge(){
        return false;
    }

}
