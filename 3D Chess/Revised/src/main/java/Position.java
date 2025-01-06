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

//import ThreeDimensionalExceptions.CoordinateException;

public class Position extends ThreeDimensionalExceptions { //FIXME
    public byte [] coordinates = new byte[3];

    public Position (byte xCoordinate, byte yCoordinate, byte zCoordinate) { this(new byte [] {xCoordinate, yCoordinate, zCoordinate}); }

    public Position (byte[] coordinates) { this.coordinates = coordinates; } //FIXME

    public Position (Position position) { ; } //FIXME ADD bytePosition*/

    public byte[] getCoordinates () { return coordinates; }
    public byte getXCoordinate () { return coordinates[0]; }
    public byte getYCoordinate () { return coordinates[1]; }
    public byte getZCoordinate () { return coordinates[2]; }

    public void setPosition (byte xCoordinate, byte yCoordinate, byte zCoordinate) {
        byte [] coordinates = new byte[]{xCoordinate, yCoordinate, zCoordinate};
        if (isPosition(coordinates)) { setPosition(coordinates); } //TODO
        // else //TODO
    }

    public void setPosition (byte[] coordinates) { if(isPosition(coordinates)){ this.coordinates = coordinates; } } //TODO

//    public void setPosition (Position position) { this.position = position; }

    public boolean isPosition (byte[] position) { //TODO
        if (position.length != 3) {
            try {
                throw new ThreeDimensionalExceptions.CoordinateException("Wrong Coordinate Format: Need Length 3", new Throwable("Length !3"));
            } catch (Exception e) {
                // TODO: handle exception
            }
            return false;
        }
        //else if (isCoordinate(position[0]) + isCoordinate(position[1]) + isCoordinate(position[2]) != 0) { //TODO Add check if 2D mode
            // if () { } //TODO
            // if () { } //TODO
            // if () { } //TODO
        //}
        return true;
    }

}
