public class MoveComparePiece extends MoveCompareHelper {
    Position newPosition;
    Position oldPosition;
    byte xCompare;
    byte yCompare;
    byte zCompare;

    public MoveComparePiece(Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare) {
        this.newPosition = newPosition;
        this.oldPosition = oldPosition;
        this.xCompare = xCompare;
        this.yCompare = yCompare;
        this.zCompare = zCompare;
    }

    public byte[] moveComparePAWN () {
        return moveComparePAWN(newPosition, oldPosition, xCompare, yCompare, zCompare, (byte) 0);
    }

    public byte[] moveComparePAWN (Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare) {
        return moveComparePAWN(newPosition, oldPosition, xCompare, yCompare, zCompare, (byte) 0);
    }

    //TODO
    public byte[] moveComparePAWN (Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare, byte isLegal) { //TODO
        byte [] rtn = new byte[33];

        byte size = 0;
        if (isLegal < 0) { size++; rtn[0] = size; rtn[size] = -100; return rtn; } //-100
        if (isLegal > 0) { size++; rtn[0] = size; rtn[size] = 100; return rtn; } //100
        if (xCompare > 1 || yCompare > 1 || zCompare > 1) {
            if (pawnFirstMove(oldPosition)) {

            }

            exceptions(xCompare);
            new MovementRulesException(("Known Exception (MoveCompare || moveComparePAWN)" +
                    "\n\tIllegal Move; Pawn Moved More than one space"), new Throwable("Exceeds PAWN Movement"));
        }
        if (xCompare == 1 || yCompare == 1 && zCompare == 0){
            new MovementRulesException("En Passe Capture");//TODO

        }
        if (xCompare == 1 || yCompare == 0 && zCompare == 1){
            new MovementRulesException("En Passe Capture");//TODO
        }
        if (xCompare == 0 || yCompare == 1 && zCompare == 1){
            new MovementRulesException("En Passe Capture");//TODO
        }

        return rtn;
    }

    public byte[] moveCompareKIGHT (Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare) {
        return moveCompareKIGHT(newPosition, oldPosition, xCompare, yCompare, zCompare, (byte) 0);
    }

    public byte[] moveCompareKIGHT (Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare, byte isLegal) { //TODO
        byte[] rtn = new byte[33];
        return rtn;
    }

    public byte[] moveCompareROOK (Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare) {
        return moveCompareROOK(newPosition, oldPosition, xCompare, yCompare, zCompare, (byte) 0);
    }

    public byte[] moveCompareROOK (Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare, byte isLegal) { //TODO
        byte[] rtn = new byte[33];
        return rtn;
    }

    public byte[] moveCompareBISHOP (Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare) {
        return moveCompareBISHOP(newPosition, oldPosition, xCompare, yCompare, zCompare, (byte) 0);
    }

    public byte[] moveCompareBISHOP (Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare, byte isLegal) { //TODO
        byte[] rtn = new byte[33];
        return rtn;
    }

    public byte[] moveCompareQUEEN (Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare) {
        return moveCompareQUEEN(newPosition, oldPosition, xCompare, yCompare, zCompare, (byte) 0);
    }

    public byte[] moveCompareQUEEN (Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare, byte isLegal) { //TODO
        byte[] rtn = new byte[33];
        return rtn;
    }

    public byte[] moveCompareKING (Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare) {
        return moveCompareKING(newPosition, oldPosition, xCompare, yCompare, zCompare, (byte) 0);
    }

    public byte[] moveCompareKING (Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare, byte isLegal) { //TODO
        byte[] rtn = new byte[33];
        return rtn;
    }

    public byte[] moveComparePIECE (Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare) {
        return moveComparePIECE(newPosition, oldPosition, xCompare, yCompare, zCompare, (byte) 0);
    }

    public byte[] moveComparePIECE (Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare, byte isLegal) { //TODO
        byte[] rtn = new byte[33];
        return rtn;
    }

}
