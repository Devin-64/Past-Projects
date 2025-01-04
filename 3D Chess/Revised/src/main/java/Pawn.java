public class Pawn extends Piece {
    Position position = new Position(new byte[]{-1,-1,-1});
    private PieceTYPE type = PieceTYPE.PAWN;

    public Pawn (Position position) { super(position); }

    //TODO Override Pawn movement when piece in position too attack

    public static void main (String[] args) {

    }
}
