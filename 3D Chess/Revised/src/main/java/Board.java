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

public class Board extends Rules {

    byte [][][] board;
    byte sizeByte;
    short sizeShort;
    int sizeInt;
    short boardSizeCap = 32;

    public Board () { this((byte) 8); }
    public Board (byte size) {
        if (size > 4 && size < boardSizeCap){ //IF number of pieces change, change this
            board = new byte[size][size][size];
            sizeByte = size; sizeShort = -1; sizeInt = -1;
        }
    }

    public Board (short size) { this(size,(short)32); }
    public Board (short size, short maxSizeOverride) {
        if (size > 4 && size < maxSizeOverride){ //IF number of pieces change, change this
            board = new byte[size][size][size];
            sizeByte = -1; sizeShort = size; sizeInt = -1;
        }
    }

    public Board (int size) { this(size,(short)32); }
    public Board (int size, short maxSizeOverride) {
        if (size > 4 && size < maxSizeOverride){ //IF number of pieces change, change this
            board = new byte[size][size][size];
            sizeByte = -1; sizeShort = -1; sizeInt = size;
        }
    }

    public int getSize () {
        if (sizeByte > 0) { return sizeByte; }
        else if (sizeShort > 0) { return sizeShort; }
        else if (sizeInt > 0) { return sizeInt; }
        else return -1;
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
