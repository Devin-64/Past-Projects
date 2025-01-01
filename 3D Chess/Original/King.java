public class King extends Piece {
    Position position = new Position(new byte[]{-1,-1,-1});
    private PieceTYPE type = PieceTYPE.KING;


    public King(byte[] position) {
        super(position);
    }

    public static void main(String[] args) {

    }
}
