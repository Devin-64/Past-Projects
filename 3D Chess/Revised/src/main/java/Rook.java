public class Rook extends Piece {
    Position position = new Position(new byte[]{-1,-1,-1});
    private PieceTYPE type = PieceTYPE.ROOK;

    public Rook(byte[] position) {
        super(position);
    }

    public static void main(String[] args) {

    }
}
