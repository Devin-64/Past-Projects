public class Bishop extends Piece {
    Position position = new Position(new byte[]{-1,-1,-1});
    private PieceTYPE type = PieceTYPE.BISHOP;

    public Bishop(byte[] position) {
        super(position);
    }

    public static void main(String[] args) {

    }
}
