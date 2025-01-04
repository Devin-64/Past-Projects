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

//import Revised.src.main.java.*;

public class Move extends Piece {
    public Move(Position position) {
        super(position);
    }

    public byte[] Move(Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare,
                              PieceTYPE type) { //DONE

        return Move(newPosition, oldPosition, xCompare, yCompare, zCompare, type, (byte) 0);
    } //DONE

    //public byte[] MoveCompare(Position newPosition, Position oldPosition, Coordinates coordinates, PieceTYPE type, byte isLegal) {

    public byte[] Move(Position newPosition, Position oldPosition, byte xCompare, byte yCompare, byte zCompare,
                              PieceTYPE type, byte isLegal) { //TODO

        byte[] rtn = new byte[33];
        byte size = 0;
        //xCompare = xCompare; //TODO FIXME WHEN 3D ARRAY
        //yCompare = yCompare; //TODO FIXME WHEN 3D ARRAY
        //zCompare = zCompare; //TODO FIXME WHEN 3D ARRAY

        if (isLegal > 0) { size++; rtn[0] = size; rtn[size] = 100; return rtn; }
        if (isLegal < 0) { size++; rtn[0] = size; rtn[size] = -100; return rtn; }
        if (xCompare < 0 || yCompare < 0 || zCompare < 0) {
            if (xCompare < 0) { size++; rtn[0] = size; rtn[size] = xCompare; isLegal--; }
            if (yCompare < 0) { size++; rtn[0] = size; rtn[size] = xCompare; isLegal--; }
            if (zCompare < 0) { size++; rtn[0] = size; rtn[size] = xCompare; isLegal--; }
        }
        if (isLegal < 0) {
            return rtn;
        }
        if (xCompare == 0 && yCompare == 0 && zCompare == 0) { size++; rtn[0] = size; rtn[size] = 0; return rtn; }

        MoveComparePiece moveCompare = new MoveComparePiece(newPosition, oldPosition, xCompare, yCompare, zCompare);

        switch (type) {
            case PAWN: {
                byte[] temp = moveCompare.moveComparePAWN();
                if (temp[0] < 0) {
                    isLegal--;
                }
                if (temp[1] < 0) {
                    isLegal--;
                }
                if (temp[2] < 0) {
                    isLegal--;
                } //Tracks how many errors
    //            arrayCombine(rtn, temp);
                break;
            }
            case KNIGHT: {
                //TODO
            }
            case ROOK: {
                //TODO
            }
            case BISHOP: {
                //TODO
            }
            case QUEEN: {
                //TODO
            }
        }


        if (isLegal < 0) {
            return rtn;
        } //if errors return
        return rtn;
    }



}