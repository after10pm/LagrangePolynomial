import java.awt.*;

public class Point {

    private double x;
    private double y;
    private int size;
    private Color color;

    public Point (double x, double y, int size){
      this.x = x;
      this.y = y;
      this.size = size;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw(Graphics2D gr){
        gr.drawOval((int)getX(), (int) getY(), getSize(), getSize());
    }
}
