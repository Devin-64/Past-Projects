public class Queen extends Piece {
    Position position = new Position(new byte[]{-1,-1,-1});
    private PieceTYPE type = PieceTYPE.QUEEN;

    public Queen(byte[] position) {
        super(position);
    }

    public static void main(String[] args) {

    }
}
