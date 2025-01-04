
//import Revised.src.main.java.*;

public abstract class Piece {

    public enum PieceTYPE {
        PAWN, KNIGHT, ROOK, BISHOP, QUEEN, KING;
    }

    Position position;
    public Piece(byte [] coordinates) { this(new Position(coordinates)); }
    public Piece(Position position){ this.position = position; }
  

    public Position getPosition(){ return position; }
    //public byte[] getPosition (byte num) { return getCoordinates(); }

    public void setPosition(Position position){ }

    public Position move(Piece piece, Position position){ /** Returns Code that immediately fails*/
        return new Position(new byte [] {-1,-1,-1});
    }

    public boolean edge(){
        return false;
    }

}