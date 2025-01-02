public class 3DCoordinate{
    private byte [] coordinate = new byte[3];

    public 3DCoordinate () { 3DCoordinate(-1); }
    public 3DCoordinate (byte coord) { 3DCoordinate(coord,-1); }
    public 3DCoordinate (byte coord1, byte coord2) { 3DCoordinate(coord1, coord2, -1); }
    public 3DCoordinate (byte coord1, byte coord2, byte coord3) {
        3DCoordinate(new byte[] {coord1, coord2, coord3}); }
    public 3DCoordinate (byte[] coordinate) { set3DCoordinate(coordinate); }
    public byte get3DCoordinate () { return this.coordinate; }
    public void set3DCoordinate (byte[] coordinate) { 
        if (coordinate.length == this.coordinate.lenght) this.coordinate = coordinate;
        else new CoordinateException("Array Input of Incorect length (Coordinate || set3DCoordinate)",
                new Throwable("Resulted In Unchecked Error"));
    }

    public byte coordinateCompare (3DCoordinate First, byte[] coordinate) {
        return coordinateCompare(First, new 3DCoordinate(coordinate));  }
    public byte coordinateCompare (3DCoordinate First, 3DCoordinate Second) {
        return (Math.abs(First.get3DCoordinate()[0]) - Math.abs(Second.get3DCoordinate()[0])) +
               (Math.abs(First.get3DCoordinate()[1]) - Math.abs(Second.get3DCoordinate()[1])) +
               (Math.abs(First.get3DCoordinate()[2]) - Math.abs(Second.get3DCoordinate()[2]));
    }
// This section is being moved into other classes in the next revision as it is unessesary here
//
//     public byte[] coordinateCompare (byte newCoordinate, byte oldCoordinate) { //DONE
//         return coordinateCompare(newCoordinate, oldCoordinate, (byte) 0);
//     } //DONE

//     public byte[] coordinateCompare (byte newCoordinate, byte oldCoordinate, byte isLegal) { //DONE
//         byte [] rtn = new byte[2]; //NEW ARRAY TO RETURN
//         byte size = 0; //SIZE COUNTER

//         //Manual Override return [-1, -100, ...]
//         if (isLegal < 0) { size ++; rtn[0] = size; rtn[size] = -100; rtn[0] = (byte) (-1 * rtn[0]); return rtn; }
//         //Manual Override return [1, 100, ...]
//         else if (isLegal > 0) { size ++; rtn[0] = size; rtn[size] = 100; return rtn; }
//         else {
//             byte compared = coordinateCompareIsLegal(newCoordinate, oldCoordinate); //calls coordinateCompareLegal
//             size ++; rtn[0] = size; rtn[size] = compared; return rtn;
//         }
//     } //DONE

//     private byte coordinateCompareIsLegal (byte newCoordinate, byte oldCoordinate) { //DONE
//         if (isCoordinate(newCoordinate) != 0 || isCoordinate(oldCoordinate) !=0) {
//             return coordinateCompareIllegal(newCoordinate, oldCoordinate);
//         }
//         byte difference = (byte) (Math.abs(newCoordinate) - Math.abs(oldCoordinate));
//         if (difference == 0) { return 0; }
//         else if (difference == -1) { return -1;}
//         else if (difference == 1) {return 1;}
//         else if (difference < -1){ return -2; }
//         else if (difference > 1) { return 2; }
//         else {
//             new CoordinateException("Unknown Exception (Coordinate || coordinateCompareLegal)",
//                     new Throwable("Resulted In Unchecked Error"));
//             return -3;
//         }
//     } //DONE

//     private byte coordinateCompareIllegal (byte newCoordinate, byte oldCoordinate) { //DONE
//         if (isCoordinate(newCoordinate) == 0 && isCoordinate(oldCoordinate) == 0) { return -4; }
//         else if (isCoordinate(newCoordinate) == -1 || isCoordinate(oldCoordinate) == -1) {
//             String negative = "";
//             if (isCoordinate(newCoordinate) == -1) { negative += "newCoordinate; "; }
//             if (isCoordinate(oldCoordinate) == -1) { negative += "oldCoordinate; "; }
//             new CoordinateOutOfBoundsException(String.format("Known Exception (Coordinate || coordinateCompareIllegal)" +
//                     "\n\tIllegal Coordinate; Coordinate Out of Bounds"), new Throwable(negative + "Negative Value"));
//             return -5;
//         }
//         else if (isCoordinate(newCoordinate) == 1 || isCoordinate(newCoordinate) == 1) {
//             String exceeds = "";
//             if (isCoordinate(newCoordinate) == 1) { exceeds += "newCoordinate; "; }
//             if (isCoordinate(oldCoordinate) == 1) { exceeds += "oldCoordinate; "; }
//             new CoordinateOutOfBoundsException(String.format("Known Exception (Coordinate || coordinateCompareIllegal)" +
//                     "\n\tIllegal Coordinate; Coordinate Out of Bounds"), new Throwable(exceeds + "Value Exceeds Set Max"));
//             return -10;
//         }
//         else {
//             new Exception("Known Exception (Coordinate || coordinateCompareIllegal)",
//                     new Throwable("Caused by isCoordinate returning value != 0, 1, -1"));
//             return -8;
//         }
//     } //DONE

//     public byte isCoordinate (byte coordinate) { //DONE
//         if ((coordinate < 0 )) { return -1; }
//         else if (coordinate > getSize()) { return 1; }
//         return 0;
//     } //DONE

//     public byte[] arrayCombine(byte[] first, byte[] second) {
//         return arrayCombine(first, first.length, second, second.length);
//     }

//     // Returns the second array added to the first and padded with 10 bytes
//     public byte[] arrayCombine(byte[] first, short firstSize, byte[] second, short secondSize) {        byte [] rtn;
//         rtn = arrayExpand(first, firstSize + secondSize + 10);
//         for (int i = 0; i < secondSize; i++) { rtn[i + firstSize - 1] = second[i] }
//         return rtn;
//    }

//     public byte[] arrayExpand(byte[] array) {
//         return arrayExpand(array, 10)
//     }

//     public byte[] arrayExpand(byte[] array, byte extend) {
//         byte [] rtn = new byte[array.length + extend];
//         for (int i = 0; i < array.length; i++) { rtn[i] = array[i]; }
//         return rtn;
//     }

}