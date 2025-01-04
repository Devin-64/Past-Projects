public class Coordinate extends Board { //DONE V1

    byte coordinate;



    public Coordinate (byte coordinate) { setCoordinate(coordinate); } //DONE
    public Coordinate (byte [] coordinates) { } //Intentionally Empty //DONE
    public Coordinate (Position position) { } //Intentionally Empty //DONE
    public byte getCoordinate () { return coordinate; } //DONE
    public void setCoordinate (byte coordinate) { this.coordinate = coordinate; } //DONE


    public byte[] coordinateCompare (byte newCoordinate, byte oldCoordinate) { //DONE
        /**
         Compares a new single dimensional coordinate against an old coordinate to see if the new Coordinate is a legal position
         and if it is a legal move return error byte and new CoordinateOutOfBoundsException (not thrown);
         nc = newCoordinate;    oC = oldCoordinate    public byte coordinateCompare (byte newCoordinate, byte oldCoordinate)
         nC/oC Negative Value;    return -5;    -    nC/oC Over Maximum Value;    return -10;
         nC = oC;    return 0;    -    |nC|-|oC| = 1;    return 1;    -    |nC|-|oC| = -1;    return -1;
         |nC|-|oC| > 1;    return 2;    -    |nC|-|oC| < -1;    return -2;
         unchecked;    return -3, -4, -8;
         */
        return coordinateCompare(newCoordinate, oldCoordinate, (byte) 0);
    } //DONE

    public byte[] coordinateCompare (byte newCoordinate, byte oldCoordinate, byte isLegal) { //DONE
        byte [] rtn = new byte[2]; //NEW ARRAY TO RETURN
        byte size = 0; //SIZE COUNTER

        //Manual Override return [-1, -100, ...]
        if (isLegal < 0) { size ++; rtn[0] = size; rtn[size] = -100; rtn[0] = (byte) (-1 * rtn[0]); return rtn; }
        //Manual Override return [1, 100, ...]
        else if (isLegal > 0) { size ++; rtn[0] = size; rtn[size] = 100; return rtn; }
        else {
            byte compared = coordinateCompareIsLegal(newCoordinate, oldCoordinate); //calls coordinateCompareLegal
            size ++; rtn[0] = size; rtn[size] = compared; return rtn;
        }
    } //DONE

    private byte coordinateCompareIsLegal (byte newCoordinate, byte oldCoordinate) { //DONE
        if (isCoordinate(newCoordinate) != 0 || isCoordinate(oldCoordinate) !=0) {
            return coordinateCompareIllegal(newCoordinate, oldCoordinate);
        }
        byte difference = (byte) (Math.abs(newCoordinate) - Math.abs(oldCoordinate));
        if (difference == 0) { return 0; }
        else if (difference == -1) { return -1;}
        else if (difference == 1) {return 1;}
        else if (difference < -1){ return -2; }
        else if (difference > 1) { return 2; }
        else {
            new CoordinateException("Unknown Exception (Coordinate || coordinateCompareLegal)",
                    new Throwable("Resulted In Unchecked Error"));
            return -3;
        }
    } //DONE

    private byte coordinateCompareIllegal (byte newCoordinate, byte oldCoordinate) { //DONE
        if (isCoordinate(newCoordinate) == 0 && isCoordinate(oldCoordinate) == 0) { return -4; }
        else if (isCoordinate(newCoordinate) == -1 || isCoordinate(oldCoordinate) == -1) {
            String negative = "";
            if (isCoordinate(newCoordinate) == -1) { negative += "newCoordinate; "; }
            if (isCoordinate(oldCoordinate) == -1) { negative += "oldCoordinate; "; }
            new CoordinateOutOfBoundsException(String.format("Known Exception (Coordinate || coordinateCompareIllegal)" +
                    "\n\tIllegal Coordinate; Coordinate Out of Bounds"), new Throwable(negative + "Negative Value"));
            return -5;
        }
        else if (isCoordinate(newCoordinate) == 1 || isCoordinate(newCoordinate) == 1) {
            String exceeds = "";
            if (isCoordinate(newCoordinate) == 1) { exceeds += "newCoordinate; "; }
            if (isCoordinate(oldCoordinate) == 1) { exceeds += "oldCoordinate; "; }
            new CoordinateOutOfBoundsException(String.format("Known Exception (Coordinate || coordinateCompareIllegal)" +
                    "\n\tIllegal Coordinate; Coordinate Out of Bounds"), new Throwable(exceeds + "Value Exceeds Set Max"));
            return -10;
        }
        else {
            new Exception("Known Exception (Coordinate || coordinateCompareIllegal)",
                    new Throwable("Caused by isCoordinate returning value != 0, 1, -1"));
            return -8;
        }
    } //DONE

    public byte isCoordinate (byte coordinate) { //DONE
        if ((coordinate < 0 )) { return -1; }
        else if (coordinate > getSize()) { return 1; }
        return 0;
    } //DONE

    public byte[] arrayCombine(byte[] toReturn, byte[] toAdd) {
        return arrayCombine(toReturn, (short) toReturn.length, toAdd, (short) toAdd.length);
    }

        //Adds second to first after initialized values, (may expand the size of array returned)
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

}
