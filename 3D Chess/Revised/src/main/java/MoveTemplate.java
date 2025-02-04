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
import Pieces.*;


public class MoveTemplate extends Move { //COMBINE WITH MOVEMENT

    public MoveTemplate(Position position) {
        super(position);
    }

    // public MoveTemplate (Position position) { super(position); } //FIXME Position

    // public Position move (Piece piece, Position position, PieceTYPE type) { //DONE
    //     return move(piece, position, type, (byte) 0);
    // } //DONE

    public Position move (Piece piece, Position position, PieceTYPE type, byte isLegal) { //TODO
        { /** Position newPosition = new Position(new byte[]{-1,-1,-1}); FOR TESTING
         Position oldPosition = new Position(new byte[]{-1,-1,-1}); FOR TESTING **/ }
        Position newPosition = position;
        Position oldPosition = piece.getPosition();
        byte [] rtn = moveHelper(newPosition, oldPosition, type, isLegal);
        if (rtn[0] > 0 && rtn[1] != 100) { return newPosition; }
        else if (rtn[1] == 100) {
            return newPosition;
            //TODO return new Position (newPosition, isLegal = rtn)
        }
        else if (rtn[1] == -100){
            return new Position(new byte[]{-1, -1, -1});
            //TODO return new Position (newPosition, isLegal = rtn)
        }
        //TODO ADD ELSE IF FOR RTN == 0;
        else {
            new Exception("Unknown Exception (Coordinate || coordinateCompare)", new Throwable("Resulted In Unchecked Error"));
            return new Position(new byte[] {-1, -1, -1}); //TODO ILLEGAL STATE IN MOVEMENT
        }
    } //TODO

    public byte[] moveHelper (Position newPosition, Position oldPosition, PieceTYPE type) { //TODO MAYBE COMBINE WITH MOVE;
        // byte xCompare = coordinateCompare(newPosition.getXCoordinate(), oldPosition.getXCoordinate())[1]; //TODO
        // byte yCompare = coordinateCompare(newPosition.getYCoordinate(), oldPosition.getYCoordinate())[1]; //TODO
        // byte zCompare = coordinateCompare(newPosition.getZCoordinate(), oldPosition.getZCoordinate())[1]; //TODO
        // if (xCompare < 0 || yCompare < 0 || zCompare < 0) return new byte[] {1,-1}; //TODO
        // else return Move(newPosition, oldPosition, xCompare, yCompare, zCompare, type); //TODO
        return Move(newPosition, oldPosition, (byte)(-1), (byte)(-1), (byte)(-1), type);
    } //TODO

    public byte[] moveHelper (Position newPosition, Position oldPosition, PieceTYPE type, byte isLegal) { //TODO MAYBE COMBINE WITH MOVE
        // byte xCompare = coordinateCompare(newPosition.getXCoordinate(), oldPosition.getXCoordinate(), isLegal)[1]; //TODO
        // byte yCompare = coordinateCompare(newPosition.getYCoordinate(), oldPosition.getYCoordinate(), isLegal)[1]; //TODO
        // byte zCompare = coordinateCompare(newPosition.getZCoordinate(), oldPosition.getZCoordinate(), isLegal)[1]; //TODO
        return Move(newPosition, oldPosition, (byte)(-1), (byte)(-1), (byte)(-1), type, (byte) 100); //TODO
    } //TODO

}
