/* Copyright (c) 2025 [Devin Dumonceau]
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 * Contact: [jobs.devin.dumonceau@gmail.com]	 */

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
