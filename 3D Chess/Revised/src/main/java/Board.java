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
