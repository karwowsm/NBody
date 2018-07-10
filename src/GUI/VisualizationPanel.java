package GUI;

import Logic.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

/**
 *
 * @author Mateusz
 */
public class VisualizationPanel extends javax.swing.JPanel {

    public void setStepNum(int stepNum) {
        this.stepNum = stepNum;
    }

    public static int x;
    public static int y;
    public static int WIDTH;
    public static int HEIGHT;
    public static int GAP = 15;

    private ArrayList<Body> bodies;

    protected static boolean isDimSetted;
    public static double max_x;
    public static double max_y;
    public static double min_x;
    public static double min_y;

    private int toSleep;        //czas w ms, na który symulacja jest usypiana po każdym jej kroku
    private int toSleep_i;      //zmienna iteracyjna
    private int toSleep_n;      //ilość kroków symulacji, po której zostaje ona uśpiona na 1ms
    private int stepNum;
    private int step;
    private Simulator simulator;

    public VisualizationPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (bodies == null) {
                    return;
                }
                for (Body b : bodies) {
                    if (b.contains(me.getX(), me.getY())) {
                        isDimSetted = false;
                        bodies.remove(b);
                        return;
                    }
                }
            }
        });
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    protected void paintComponent(Graphics g) {

        WIDTH = getSize().width;
        HEIGHT = getSize().height;
        x = GAP;
        y = HEIGHT - GAP;

        g.clearRect(0, 0, WIDTH, HEIGHT);

        if (bodies != null) {
            for (int i = 0; i < bodies.size(); i++) {
                bodies.get(i).draw(g);
            }
            g.setColor(Color.BLACK);
            g.drawLine(GAP, HEIGHT - GAP, GAP, GAP);
            g.drawLine(GAP, HEIGHT - GAP, WIDTH - GAP, HEIGHT - GAP);

            g.drawLine(GAP, GAP, GAP + GAP / 5, GAP + GAP / 2);
            g.drawLine(GAP, GAP, GAP - GAP / 5, GAP + GAP / 2);
            g.drawLine(WIDTH - GAP, HEIGHT - GAP, WIDTH - GAP - GAP / 2, HEIGHT - GAP + GAP / 5);
            g.drawLine(WIDTH - GAP, HEIGHT - GAP, WIDTH - GAP - GAP / 2, HEIGHT - GAP - GAP / 5);
            Font f = new Font("serif", Font.BOLD, GAP);

            g.setFont(f);

            g.drawString(Double.toString(min_x), GAP, HEIGHT - GAP / 4);
            int width = g.getFontMetrics().stringWidth(Double.toString(max_x));
            g.drawString(Double.toString(max_x), WIDTH - GAP - width, HEIGHT - GAP / 4);
            Graphics2D g2 = (Graphics2D) g;
            AffineTransform affineTransform = new AffineTransform();
            affineTransform.rotate(Math.toRadians(-90), 0, 0);
            Font rotatedFont = f.deriveFont(affineTransform);
            g2.setFont(rotatedFont);
            g.drawString(Double.toString(min_y), GAP - GAP / 4, HEIGHT - GAP);
            String str = Double.toString(max_y);

            width = (int) rotatedFont.getStringBounds(str, g2.getFontRenderContext()).getWidth();
            g.drawString(str, GAP - GAP / 4, GAP + width);
        }
    }

    public int getProgress() {
        return (int) (100 * (double) step / stepNum);
    }

    public void doSimulationStep() {

        if (step < stepNum) {
            simulator.doSimulationStep();
            if (!isDimSetted) {
                setMinMax();
            }
            step++;
        } else {
            if (simulator.E2 == 0) {
                simulator.setE2();
            }
            isDimSetted = true;
            for (int i = 0; i < bodies.size(); i++) {
                bodies.get(i).position = bodies.get(i).position_t0.copy();
                bodies.get(i).velocity = bodies.get(i).velocity_t0.copy();
            }
            step = 0;
        }

        try {
            if (toSleep_i >= toSleep_n) {
                java.lang.Thread.sleep(toSleep + 1);
                toSleep_i = 1;
            } else {
                if (toSleep != 0) {
                    java.lang.Thread.sleep(toSleep);
                }
                toSleep_i++;
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(VisualizationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
    }

    public void setTempo(int tempo) {
        double time = 30000.0 / stepNum - (290.0 / stepNum * tempo);
        toSleep = (int) time;
        toSleep_i = 1;
        toSleep_n = (int) Math.round((1.0 / (time - toSleep)));
    }

    public int getToSleep() {
        return toSleep;
    }

    public void setBodies(ArrayList<Body> bodies) {
        this.bodies = bodies;
        Random r = new Random();
        for (int i = 0; i < bodies.size(); i++) {
            bodies.get(i).setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        }
    }

    public void setMinMax() {
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
        }
    }

    public static void setMinMax(double a, double b, double c, double d) {
        max_x = a;
        max_y = b;
        min_x = c;
        min_y = d;
    }

    public void setSimulator(Simulator simulator) {
        step = 0;
        this.simulator = simulator;
    }

    public int getToSleep_n() {
        return toSleep_n;
    }

}
