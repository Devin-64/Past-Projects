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

public class Coordinate3D {
    private byte [] coordinate = new byte[3];

    public Coordinate3D () { this((byte) -1); }
    public Coordinate3D (byte coord) { this(coord, (byte) -1); }
    public Coordinate3D (byte coord1, byte coord2) { this(coord1, coord2, (byte) -1); }
    public Coordinate3D (byte coord1, byte coord2, byte coord3) {
        this(new byte[] {coord1, coord2, coord3}); }
    public Coordinate3D (byte[] coordinate) { setCoordinate3D(coordinate); }
//    public Coordinate3D (Coordinate3D Coordinate) { }
    public byte[] getCoordinate3D () { return this.coordinate; }
    public void setCoordinate3D (byte[] coordinate) { 
        if (coordinate.length == this.coordinate.length) this.coordinate = coordinate;
        else { 
            try {
                throw new ThreeDimensionalExceptions.CoordinateException(
                    "Array Input of Incorrect Length (Coordinate || setCoordinate3D)", 
                    new Throwable("Resulted in Unchecked Error"));
            } catch (Exception e) {
                //
            }
        }
    }

    public byte coordinateCompare (Coordinate3D First, byte[] coordinate) {
        return coordinateCompare(First, new Coordinate3D(coordinate));  }
    public byte coordinateCompare (Coordinate3D First, Coordinate3D Second) {
        return (byte) ((Math.abs(First.getCoordinate3D()[0]) - Math.abs(Second.getCoordinate3D()[0])) +
               (Math.abs(First.getCoordinate3D()[1]) - Math.abs(Second.getCoordinate3D()[1])) +
               (Math.abs(First.getCoordinate3D()[2]) - Math.abs(Second.getCoordinate3D()[2])));
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