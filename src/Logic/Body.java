package Logic;

import GUI.VisualizationPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Mateusz
 */
public class Body {

    public double mass;
    public Vector position;  //polozenie ciala
    public Vector velocity;  //predkosc ciala
    public Vector position_t0;
    public Vector velocity_t0;
    public Vector temp_position;
    private static final int BODYSIZE = 25;
    private Color color;

    public Body(double mass, Vector position, Vector velocity) {
        this.mass = mass;
        this.position = position;
        this.velocity = velocity;
        this.position_t0 = position.copy();
        this.velocity_t0 = velocity.copy();
    }

    public Body copy() {
        Body b = new Body(mass, new Vector(position.x, position.y, position.z), new Vector(velocity.x, velocity.y, velocity.z));
        b.setColor(color);
        return b;
    }

    @Override
    public String toString() {
        return "Masa = " + mass + "\tWspółrzędne: " + position + "\tPrędkość: " + velocity;
    }

    public void draw(Graphics g) {
        if (color == null) {
            g.setColor(Color.BLUE);
        } else {
            g.setColor(color);
        }
        g.fillOval(VisualizationPanel.x + (int) ((position.x - VisualizationPanel.min_x) / (VisualizationPanel.max_x - VisualizationPanel.min_x) * (VisualizationPanel.WIDTH - 2 * VisualizationPanel.GAP)) - BODYSIZE / 2,
                VisualizationPanel.y - (int) ((position.y - VisualizationPanel.min_y) / (VisualizationPanel.max_y - VisualizationPanel.min_y) * (VisualizationPanel.HEIGHT - 2 * VisualizationPanel.GAP)) - BODYSIZE / 2,
                BODYSIZE, BODYSIZE);
    }

    public boolean contains(double x, double y) {        //sprawdza czy punkt (x, y) należy do ciała
        int a = VisualizationPanel.x + (int) ((position.x - VisualizationPanel.min_x) / (VisualizationPanel.max_x - VisualizationPanel.min_x) * (VisualizationPanel.WIDTH - 2 * VisualizationPanel.GAP));
        int b = VisualizationPanel.y - (int) ((position.y - VisualizationPanel.min_y) / (VisualizationPanel.max_y - VisualizationPanel.min_y) * (VisualizationPanel.HEIGHT - 2 * VisualizationPanel.GAP));
        double distance = (a - x) * (a - x) + (b - y) * (b - y);
        return distance < BODYSIZE * BODYSIZE / 4;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
