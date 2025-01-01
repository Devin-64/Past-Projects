public class Coordinates extends Coordinate {


    public Coordinates(byte[] coordinates) { //TODO
        super(coordinates);
    }

    public byte[] toCoordinates(byte xCoordinate, byte yCoordinate, byte zCoordinate){
        return new byte[]{xCoordinate, yCoordinate, zCoordinate};
    }

    /* //TODO Change to return 3D arrays
    public byte[] arrayCombine(byte[] toReturn, short rSize, byte[] toAdd, short aSize) { //TODO CHECK FOR OB1 ERRORS
        byte [] rtn;
        if(rSize + aSize > toReturn.length) {
            rtn = new byte[rSize + aSize];
            int rtnSize = 0;
            for (int i = 0; i < rSize; i++) { rtn[rtnSize] = toReturn[i]; rtnSize ++; }
            for (int i = 0; i < aSize; i++) { rtn[rtnSize] = toAdd[i]; rtnSize ++; }
        }
        else {
            rtn = new byte[toReturn.length];
            for (int i = 0; i < rSize; i++) { rtn[i] = toReturn[i]; }
            for (int i = 0; i < aSize; i++) { rtn[rSize + i] = toAdd[i]; }
        }
        return rtn;
    }

    public byte[] arrayExpand(byte[] array){
        byte [] rtn = new byte[array.length + 10];
        for (int i = 0; i < array.length; i++) { rtn[i] = array[i]; }
        return rtn;
    }
    */

}
