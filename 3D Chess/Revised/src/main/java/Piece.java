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