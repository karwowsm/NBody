package Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Mateusz
 */
public class Simulator {

    private ArrayList<Body> bodies;
    private int dt;
    private final static double G = 6.67408e-11;
    public double E1;
    public double E2;
    public double max_x;
    public double max_y;
    public double min_x;
    public double min_y;

    public Simulator(ArrayList<Body> bodies, int dt) {
        this.bodies = bodies;
        this.dt = dt;
        E1 = countEnergy();
    }

    public void doSimulationStep() {

        Vector rij;
        double Rij;
        Vector temp;
        Vector ai = new Vector();
        Vector[] temp_position = new Vector[bodies.size()];

        for (int i = 0; i < bodies.size(); i++) {
            for (int j = 0; j < bodies.size(); j++) {
                if (j != i) {
                    rij = bodies.get(i).position.substractVectors(bodies.get(j).position);
                    Rij = rij.vectorLength();
                    temp = countAcceleration(bodies.get(j).mass, Rij, rij);
                    ai = ai.addVectors(temp);
                }
            }
            ai = ai.multiplyVector((-1.0) * G);
            bodies.get(i).velocity = bodies.get(i).velocity.addVectors(ai.multiplyVector(dt));
            temp_position[i] = bodies.get(i).position.addVectors(bodies.get(i).velocity.multiplyVector(dt));
        }
        for (int i = 0; i < bodies.size(); i++) {
            bodies.get(i).position = temp_position[i];
        }
    }

    public void doSimulation(int stepNum, File f) throws FileNotFoundException, IOException {
        if (f == null) {
            throw new IOException("Nie wybrałeś pliku z danymi wyjściowymi.");
        }
        try {
            PrintWriter p;
            p = new PrintWriter(f);
            E1 = countEnergy();
            min_x = min_y = Double.POSITIVE_INFINITY;
            max_x = max_y = Double.NEGATIVE_INFINITY;
            for (int c = 0; c < stepNum; c++) {
                doSimulationStep();
                for (int i = 0; i < bodies.size(); i++) {
                    if (bodies.get(i).position.x > max_x) {
                        max_x = bodies.get(i).position.x + 0.1 * Math.abs(bodies.get(i).position.x);
                    }
                    if (bodies.get(i).position.y > max_y) {
                        max_y = bodies.get(i).position.y + 0.1 * Math.abs(bodies.get(i).position.y);
                    }
                    if (bodies.get(i).position.x < min_x) {
                        min_x = bodies.get(i).position.x - 0.1 * Math.abs(bodies.get(i).position.x);
                    }
                    if (bodies.get(i).position.y < min_y) {
                        min_y = bodies.get(i).position.y - 0.1 * Math.abs(bodies.get(i).position.y);
                    }
                    p.println(bodies.get(i).position.x + " " + bodies.get(i).position.y + " " + bodies.get(i).position.z);
                }
            }
            p.close();
            E2 = countEnergy();
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("Nie mogę otworzyć pliku o nazwie " + f.getName());
        }
    }

    private Vector countAcceleration(double m, double r, Vector Rvector) {
        return Rvector.multiplyVector(m / (r * r) * 1.0 / r);
    }

    private double countEnergy() {
        Vector licznik = new Vector(0, 0, 0);
        double masa = 0.0;

        double E = 0.0;
        for (Body i : bodies) {
            licznik = licznik.addVectors(i.position.multiplyVector(i.mass));
            masa += i.mass;
        }
        Vector srm = licznik.multiplyVector(1 / masa);      //środek masy
        Vector v;
        for (Body i : bodies) {
            v = i.position.substractVectors(srm);
            E += -G * i.mass * masa / v.vectorLength();
        }
        return E;
    }

    public void setE2() {
        E2 = countEnergy();
    }
}
