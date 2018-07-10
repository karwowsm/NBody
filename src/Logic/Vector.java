package Logic;

import static java.lang.Math.sqrt;

/**
 *
 * @author Mateusz
 */
public class Vector {

    public double x;
    public double y;
    public double z;

    public Vector() {
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector addVectors(Vector v) {
        return new Vector(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    public Vector substractVectors(Vector v) {
        return new Vector(this.x - v.x, this.y - v.y, this.z - v.z);
    }

    public Vector multiplyVector(double scalar) {
        return new Vector(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public double vectorLength() {
        return sqrt(x * x + y * y + z * z);
    }

    public Vector copy() {
        return new Vector(x, y, z);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Vector && ((Vector) o).x == x && ((Vector) o).y == y && ((Vector) o).z == z;
    }

    @Override
    public String toString() {
        return "x = " + x + " y = " + y + " z = " + z;
    }

}
