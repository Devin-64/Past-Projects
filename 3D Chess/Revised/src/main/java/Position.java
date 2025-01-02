public class Position { //FIXME
    public byte [] coordinates = new byte[3];

    public Position (byte xCoordinate, byte yCoordinate, byte zCoordinate) { this(new byte[] {xCoordinate, yCoordinate, zCoordinate}); }

    public Position (byte[] coordinates) { super(coordinates); } //FIXME

    public Position (Position position) { super(position); } //FIXME ADD bytePosition*/

    public byte[] getCoordinates () { return coordinates; }
    public byte getXCoordinate () { return coordinates[0]; }
    public byte getYCoordinate () { return coordinates[1]; }
    public byte getZCoordinate () { return coordinates[2]; }

    public void setPosition (byte xCoordinate, byte yCoordinate, byte zCoordinate) {
        byte [] coordinates = new byte[]{xCoordinate, yCoordinate, zCoordinate};
        if (isPosition(coordinates)) { setCoordinates(coordinates); } //TODO
        else //TODO
    }

    public void setCoordinates (byte[] coordinates) { if(isPosition(coordinates)){ this.coordinates = coordinates; } } //TODO

    public void setPosition (Position position) { this.position = position; }

    public boolean isPosition (byte[] position) { //TODO
        if (position.length != 3) {
            new CoordinateException("Wrong Coordinate Format: Need Length 3", new Throwable("Length !3"));
            return false;
        }
        else if (isCoordinate(position[0]) + isCoordinate(position[1]) + isCoordinate(position[2]) != 0) { //TODO Add check if 2D mode
            if () { } //TODO
            if () { } //TODO
            if () { } //TODO
        }
        return true;
    }

}
